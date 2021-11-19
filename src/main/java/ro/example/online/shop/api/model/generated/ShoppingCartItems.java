package ro.example.online.shop.api.model.generated;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import ro.example.online.shop.api.model.generated.ShoppingCartItem;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ShoppingCartItems
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ShoppingCartItems  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("products")
  @Valid
  private List<ShoppingCartItem> products = new ArrayList<ShoppingCartItem>();

  @JsonProperty("totalValue")
  private BigDecimal totalValue;

  public ShoppingCartItems products(List<ShoppingCartItem> products) {
    this.products = products;
    return this;
  }

  public ShoppingCartItems addProductsItem(ShoppingCartItem productsItem) {
    this.products.add(productsItem);
    return this;
  }

  /**
   * Get products
   * @return products
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<ShoppingCartItem> getProducts() {
    return products;
  }

  public void setProducts(List<ShoppingCartItem> products) {
    this.products = products;
  }

  public ShoppingCartItems totalValue(BigDecimal totalValue) {
    this.totalValue = totalValue;
    return this;
  }

  /**
   * Get totalValue
   * @return totalValue
  */
  @ApiModelProperty(example = "1955", value = "")

  @Valid

  public BigDecimal getTotalValue() {
    return totalValue;
  }

  public void setTotalValue(BigDecimal totalValue) {
    this.totalValue = totalValue;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShoppingCartItems shoppingCartItems = (ShoppingCartItems) o;
    return Objects.equals(this.products, shoppingCartItems.products) &&
        Objects.equals(this.totalValue, shoppingCartItems.totalValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(products, totalValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShoppingCartItems {\n");
    
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
    sb.append("    totalValue: ").append(toIndentedString(totalValue)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

