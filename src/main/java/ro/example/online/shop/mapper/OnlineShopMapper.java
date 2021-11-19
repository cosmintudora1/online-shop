package ro.example.online.shop.mapper;

import java.math.BigDecimal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.example.online.shop.api.model.generated.AddToCartRequest;
import ro.example.online.shop.api.model.generated.CartIdentity;
import ro.example.online.shop.api.model.generated.Product;
import ro.example.online.shop.api.model.generated.ShoppingCartItem;
import ro.example.online.shop.datasource.model.DatabaseProduct;
import ro.example.online.shop.datasource.model.Order;

@Mapper(componentModel = "spring")
public interface OnlineShopMapper {

    @Mapping(target = "productId", expression = "java(databaseProduct.getProductId().toString())")
    Product toProduct(DatabaseProduct databaseProduct);

//    @Mapping(target = "price", source = "newPrice")
    @Mapping(target = "productId", expression = "java(databaseProduct.getProductId().toString())")
    ShoppingCartItem toShoppingCartItem(DatabaseProduct databaseProduct);

    @Mapping(target = "orderId", expression = "java(java.util.UUID.fromString(addToCartRequest.getUserId()))")
    @Mapping(target = "userId", expression = "java(java.util.UUID.fromString(addToCartRequest.getUserId()))")
    Order toOrder(AddToCartRequest addToCartRequest, String products, BigDecimal totalOrderCost);

    CartIdentity toCartIdentity(String userId, String orderId);
}
