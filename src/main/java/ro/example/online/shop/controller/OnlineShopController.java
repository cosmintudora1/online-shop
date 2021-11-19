package ro.example.online.shop.controller;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ro.example.online.shop.api.controller.generated.AddToCartApi;
import ro.example.online.shop.api.controller.generated.CartProductsApi;
import ro.example.online.shop.api.controller.generated.ProductsApi;
import ro.example.online.shop.api.controller.generated.RemoveFromCartApi;
import ro.example.online.shop.api.model.generated.AddToCartRequest;
import ro.example.online.shop.api.model.generated.CartIdentity;
import ro.example.online.shop.api.model.generated.ProductsResponse;
import ro.example.online.shop.api.model.generated.RemoveItemRequest;
import ro.example.online.shop.api.model.generated.ShoppingCartItems;
import ro.example.online.shop.service.OnlineShopService;


@RestController
@RequiredArgsConstructor
@Slf4j
public class OnlineShopController implements AddToCartApi, CartProductsApi, ProductsApi, RemoveFromCartApi {

    private final OnlineShopService onlineShopService;


    @Override
    public ResponseEntity<CartIdentity> addProductToCart(String requestId, AddToCartRequest addToCartRequest) {
        return ResponseEntity.ok(onlineShopService.addProductToCart(addToCartRequest));
    }

    @Override
    public ResponseEntity<ShoppingCartItems> getCartProducts(String requestId, String userId, String orderId) {
        return ResponseEntity.ok(onlineShopService.getCartProducts(userId, orderId));
    }

    @Override
    public ResponseEntity<ProductsResponse> getProducts(String requestId, BigDecimal page, BigDecimal numberOfProducts) {
        return ResponseEntity.ok(onlineShopService.getProducts(page, numberOfProducts));
    }

    @Override
    public ResponseEntity<ShoppingCartItems> removeProductFromCart(String requestId, RemoveItemRequest removeItemRequest) {
        return null;
    }
}
