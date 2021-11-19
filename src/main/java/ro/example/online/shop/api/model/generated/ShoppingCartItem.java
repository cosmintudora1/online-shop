package ro.example.online.shop.api.model.generated;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ShoppingCartItem
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ShoppingCartItem  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("productId")
  private String productId;

  @JsonProperty("price")
  private BigDecimal price;

  @JsonProperty("quantity")
  private BigDecimal quantity;

  @JsonProperty("totalPriceItem")
  private BigDecimal totalPriceItem;

  public ShoppingCartItem productId(String productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
  */
  @ApiModelProperty(example = "421fdfhh", required = true, value = "")
  @NotNull


  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public ShoppingCartItem price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  @ApiModelProperty(example = "150", required = true, value = "")
  @NotNull

  @Valid

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public ShoppingCartItem quantity(BigDecimal quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  */
  @ApiModelProperty(example = "2", required = true, value = "")
  @NotNull

  @Valid

  public BigDecimal getQuantity() {
    return quantity;
  }

  public void setQuantity(BigDecimal quantity) {
    this.quantity = quantity;
  }

  public ShoppingCartItem totalPriceItem(BigDecimal totalPriceItem) {
    this.totalPriceItem = totalPriceItem;
    return this;
  }

  /**
   * Get totalPriceItem
   * @return totalPriceItem
  */
  @ApiModelProperty(example = "300", required = true, value = "")
  @NotNull

  @Valid

  public BigDecimal getTotalPriceItem() {
    return totalPriceItem;
  }

  public void setTotalPriceItem(BigDecimal totalPriceItem) {
    this.totalPriceItem = totalPriceItem;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShoppingCartItem shoppingCartItem = (ShoppingCartItem) o;
    return Objects.equals(this.productId, shoppingCartItem.productId) &&
        Objects.equals(this.price, shoppingCartItem.price) &&
        Objects.equals(this.quantity, shoppingCartItem.quantity) &&
        Objects.equals(this.totalPriceItem, shoppingCartItem.totalPriceItem);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, price, quantity, totalPriceItem);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShoppingCartItem {\n");
    
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    totalPriceItem: ").append(toIndentedString(totalPriceItem)).append("\n");
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

