package ro.example.online.shop.datasource.repo;


import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.example.online.shop.datasource.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    Optional<Order> findByOrderIdAndUserId(UUID orderId, UUID userId);
}
