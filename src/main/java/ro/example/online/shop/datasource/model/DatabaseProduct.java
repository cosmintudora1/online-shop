package ro.example.online.shop.datasource.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@Embeddable
@Table(name = "products", schema = "onlineshop")
public class DatabaseProduct {

    @Column(name = "product_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID productId;
    @Column(name = "old_price")
    private Integer oldPrice;
    @Column(name = "new_price")
    private Integer newPrice;
    @Column(name = "discount")
    private Integer discount;
    @Column(name = "available_quantity")
    private Integer availableQuantity;
    @Column(name = "photo")
    private String photo;
}
