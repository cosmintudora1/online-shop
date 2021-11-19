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
 * RemoveItemRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class RemoveItemRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("userId")
  private String userId;

  @JsonProperty("orderId")
  private String orderId;

  @JsonProperty("quantity")
  private BigDecimal quantity;

  @JsonProperty("productId")
  private String productId;

  public RemoveItemRequest userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  @ApiModelProperty(example = "421fdfhh", required = true, value = "")
  @NotNull


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public RemoveItemRequest orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Get orderId
   * @return orderId
  */
  @ApiModelProperty(example = "hfsahlga", required = true, value = "")
  @NotNull


  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public RemoveItemRequest quantity(BigDecimal quantity) {
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

  public RemoveItemRequest productId(String productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
  */
  @ApiModelProperty(example = "r152r1rsa", required = true, value = "")
  @NotNull


  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RemoveItemRequest removeItemRequest = (RemoveItemRequest) o;
    return Objects.equals(this.userId, removeItemRequest.userId) &&
        Objects.equals(this.orderId, removeItemRequest.orderId) &&
        Objects.equals(this.quantity, removeItemRequest.quantity) &&
        Objects.equals(this.productId, removeItemRequest.productId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, orderId, quantity, productId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RemoveItemRequest {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
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

