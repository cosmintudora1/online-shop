package ro.example.online.shop.service;

import java.math.BigDecimal;
import ro.example.online.shop.api.model.generated.AddToCartRequest;
import ro.example.online.shop.api.model.generated.CartIdentity;
import ro.example.online.shop.api.model.generated.ProductsResponse;
import ro.example.online.shop.api.model.generated.ShoppingCartItems;

public interface OnlineShopService {

    ProductsResponse getProducts(BigDecimal page, BigDecimal numberOfProducts);

    CartIdentity addProductToCart(AddToCartRequest addToCartRequest);

    ShoppingCartItems getCartProducts(String userId, String orderId);
}
