package ro.example.online.shop.datasource.repo;


import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ro.example.online.shop.datasource.model.DatabaseProduct;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<DatabaseProduct, UUID> {

    Optional<DatabaseProduct> findByProductId(UUID productId);
}
