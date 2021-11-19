package ro.example.online.shop.mapper;

import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ro.example.online.shop.api.model.generated.AddToCartRequest;
import ro.example.online.shop.api.model.generated.CartIdentity;
import ro.example.online.shop.api.model.generated.Product;
import ro.example.online.shop.api.model.generated.ShoppingCartItem;
import ro.example.online.shop.datasource.model.DatabaseProduct;
import ro.example.online.shop.datasource.model.Order;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class OnlineShopMapperImpl implements OnlineShopMapper {

    @Override
    public Product toProduct(DatabaseProduct databaseProduct) {
        if ( databaseProduct == null ) {
            return null;
        }

        Product product = new Product();

        if ( databaseProduct.getOldPrice() != null ) {
            product.setOldPrice( BigDecimal.valueOf( databaseProduct.getOldPrice() ) );
        }
        if ( databaseProduct.getNewPrice() != null ) {
            product.setNewPrice( BigDecimal.valueOf( databaseProduct.getNewPrice() ) );
        }
        if ( databaseProduct.getDiscount() != null ) {
            product.setDiscount( BigDecimal.valueOf( databaseProduct.getDiscount() ) );
        }
        product.setPhoto( databaseProduct.getPhoto() );

        product.setProductId( databaseProduct.getProductId().toString() );

        return product;
    }

    @Override
    public ShoppingCartItem toShoppingCartItem(DatabaseProduct databaseProduct) {
        if ( databaseProduct == null ) {
            return null;
        }

        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();

        shoppingCartItem.setProductId( databaseProduct.getProductId().toString() );

        return shoppingCartItem;
    }

    @Override
    public Order toOrder(AddToCartRequest addToCartRequest, String products, BigDecimal totalOrderCost) {
        if ( addToCartRequest == null && products == null && totalOrderCost == null ) {
            return null;
        }

        Order order = new Order();

        if ( products != null ) {
            order.setProducts( products );
        }
        if ( totalOrderCost != null ) {
            order.setTotalOrderCost( totalOrderCost );
        }
        order.setOrderId( java.util.UUID.fromString(addToCartRequest.getUserId()) );
        order.setUserId( java.util.UUID.fromString(addToCartRequest.getUserId()) );

        return order;
    }

    @Override
    public CartIdentity toCartIdentity(String userId, String orderId) {
        if ( userId == null && orderId == null ) {
            return null;
        }

        CartIdentity cartIdentity = new CartIdentity();

        if ( userId != null ) {
            cartIdentity.setUserId( userId );
        }
        if ( orderId != null ) {
            cartIdentity.setOrderId( orderId );
        }

        return cartIdentity;
    }
}
