package transkop.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import transkop.tracking.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}
