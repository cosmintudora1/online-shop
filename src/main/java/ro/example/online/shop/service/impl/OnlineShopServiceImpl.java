package ro.example.online.shop.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ro.example.online.shop.api.model.generated.AddToCartRequest;
import ro.example.online.shop.api.model.generated.CartIdentity;
import ro.example.online.shop.api.model.generated.ProductsResponse;
import ro.example.online.shop.api.model.generated.ShoppingCartItem;
import ro.example.online.shop.api.model.generated.ShoppingCartItems;
import ro.example.online.shop.datasource.model.DatabaseProduct;
import ro.example.online.shop.datasource.model.Order;
import ro.example.online.shop.datasource.repo.OrderRepository;
import ro.example.online.shop.datasource.repo.ProductsRepository;
import ro.example.online.shop.exception.OnlineShopException;
import ro.example.online.shop.mapper.OnlineShopMapper;
import ro.example.online.shop.service.OnlineShopService;

@Service
@Slf4j
@RequiredArgsConstructor
public class OnlineShopServiceImpl implements OnlineShopService {

    private final ProductsRepository productsRepository;
    private final OrderRepository orderRepository;
    private final OnlineShopMapper onlineShopMapper;
    private final ObjectMapper objectMapper;

    @Override
    public ProductsResponse getProducts(BigDecimal page, BigDecimal numberOfProducts) {
        var products = productsRepository.findAll(PageRequest.of(page.intValue(), numberOfProducts.intValue())).getContent().stream()
            .map(onlineShopMapper::toProduct).collect(Collectors.toList());
        return new ProductsResponse().products(products);
    }

    @SneakyThrows
    @Override
    @Transactional
    public CartIdentity addProductToCart(AddToCartRequest addToCartRequest) {
        var product = productsRepository.findByProductId(getUUID(addToCartRequest.getProductId()));
        if (product.isEmpty()) {
            throw new OnlineShopException("Product does not exist");
        }

        // refactor this
        if (addToCartRequest.getOrderId() == null) {
            return computeNewOrder(addToCartRequest, product.get());
        }

        var order = orderRepository.findByOrderIdAndUserId(getUUID(addToCartRequest.getOrderId()), getUUID(addToCartRequest.getUserId()));
        if (order.isPresent()) {
            return computeExistingOrder(addToCartRequest, product.get(), order.get());
        }
        throw new OnlineShopException("Order does not exist");
    }

    @SneakyThrows
    @Override
    public ShoppingCartItems getCartProducts(String userId, String orderId) {
        var order = orderRepository.findByOrderIdAndUserId(getUUID(orderId), getUUID(userId));
        if (order.isEmpty()) {
            throw new OnlineShopException("Order does not exist");
        }
        var productList = objectMapper.readValue(order.get().getProducts(), new TypeReference<List<ShoppingCartItem>>() {
        });
        return new ShoppingCartItems().products(productList).totalValue(computeTotalCost(productList));
    }

    private CartIdentity computeExistingOrder(AddToCartRequest addToCartRequest, DatabaseProduct product, Order existingOrder)
        throws JsonProcessingException {
        var products = objectMapper.readValue(existingOrder.getProducts(), new TypeReference<List<ShoppingCartItem>>() {
        });
        var shoppingCartItemOptional = products.stream().filter(x -> x.getProductId().equalsIgnoreCase(addToCartRequest.getProductId()))
            .findAny();
        if (shoppingCartItemOptional.isPresent()) {
            var index = products.indexOf(shoppingCartItemOptional.get());
            products.set(index, updateProductQuantity(addToCartRequest, product, shoppingCartItemOptional.get()));
        } else {
            products.add(updateProductQuantity(addToCartRequest, product, onlineShopMapper.toShoppingCartItem(product)));
        }
        existingOrder.setProducts(objectMapper.writeValueAsString(products));
        existingOrder.setTotalOrderCost(computeTotalCost(products));
        orderRepository.save(existingOrder);
        return onlineShopMapper.toCartIdentity(addToCartRequest.getUserId(), addToCartRequest.getOrderId());
    }

    private CartIdentity computeNewOrder(AddToCartRequest addToCartRequest, DatabaseProduct product) throws JsonProcessingException {
        var productList = List.of(updateProductQuantity(addToCartRequest, product, onlineShopMapper.toShoppingCartItem(product)));
        var newOrder = onlineShopMapper.toOrder(addToCartRequest, objectMapper.writeValueAsString(productList), computeTotalCost(productList));
        var savedOrder = orderRepository.save(newOrder);
        return onlineShopMapper.toCartIdentity(addToCartRequest.getUserId(), savedOrder.getOrderId().toString());
    }

    private ShoppingCartItem updateProductQuantity(AddToCartRequest addToCartRequest, DatabaseProduct product, ShoppingCartItem item) {
        var quantity = item.getQuantity() == null ? addToCartRequest.getQuantity() : addToCartRequest.getQuantity().add(item.getQuantity());
        item.setQuantity(quantity);
        item.setPrice(BigDecimal.valueOf(product.getNewPrice()));
        item.setTotalPriceItem(BigDecimal.valueOf(product.getNewPrice()).multiply(quantity));
        return item;
    }

    private UUID getUUID(String name) {
        return UUID.fromString(name);
    }

    private BigDecimal computeTotalCost(List<ShoppingCartItem> items) {
        var cost = items.stream().mapToInt(x -> x.getTotalPriceItem().intValue()).sum();
        return new BigDecimal(cost);
    }
}
