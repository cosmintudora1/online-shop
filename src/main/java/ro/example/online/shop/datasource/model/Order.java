package ro.example.online.shop.datasource.model;

import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
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
@Table(name = "orders", schema = "onlineshop")
public class Order {

    @Column(name = "order_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID orderId;
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "products")
    private String products;
    @Column(name = "total_order_cost")
    private BigDecimal totalOrderCost;
}
