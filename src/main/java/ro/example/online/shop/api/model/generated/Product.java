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
 * Product
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Product  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("productId")
  private String productId;

  @JsonProperty("oldPrice")
  private BigDecimal oldPrice;

  @JsonProperty("newPrice")
  private BigDecimal newPrice;

  @JsonProperty("discount")
  private BigDecimal discount;

  @JsonProperty("photo")
  private String photo;

  public Product productId(String productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
  */
  @ApiModelProperty(example = "421te431", required = true, value = "")
  @NotNull


  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public Product oldPrice(BigDecimal oldPrice) {
    this.oldPrice = oldPrice;
    return this;
  }

  /**
   * Get oldPrice
   * @return oldPrice
  */
  @ApiModelProperty(example = "2000", required = true, value = "")
  @NotNull

  @Valid

  public BigDecimal getOldPrice() {
    return oldPrice;
  }

  public void setOldPrice(BigDecimal oldPrice) {
    this.oldPrice = oldPrice;
  }

  public Product newPrice(BigDecimal newPrice) {
    this.newPrice = newPrice;
    return this;
  }

  /**
   * Get newPrice
   * @return newPrice
  */
  @ApiModelProperty(example = "2000", required = true, value = "")
  @NotNull

  @Valid

  public BigDecimal getNewPrice() {
    return newPrice;
  }

  public void setNewPrice(BigDecimal newPrice) {
    this.newPrice = newPrice;
  }

  public Product discount(BigDecimal discount) {
    this.discount = discount;
    return this;
  }

  /**
   * Get discount
   * @return discount
  */
  @ApiModelProperty(example = "20", required = true, value = "")
  @NotNull

  @Valid

  public BigDecimal getDiscount() {
    return discount;
  }

  public void setDiscount(BigDecimal discount) {
    this.discount = discount;
  }

  public Product photo(String photo) {
    this.photo = photo;
    return this;
  }

  /**
   * Get photo
   * @return photo
  */
  @ApiModelProperty(example = "www.poza.ro", required = true, value = "")
  @NotNull


  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.productId, product.productId) &&
        Objects.equals(this.oldPrice, product.oldPrice) &&
        Objects.equals(this.newPrice, product.newPrice) &&
        Objects.equals(this.discount, product.discount) &&
        Objects.equals(this.photo, product.photo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, oldPrice, newPrice, discount, photo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    oldPrice: ").append(toIndentedString(oldPrice)).append("\n");
    sb.append("    newPrice: ").append(toIndentedString(newPrice)).append("\n");
    sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
    sb.append("    photo: ").append(toIndentedString(photo)).append("\n");
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

