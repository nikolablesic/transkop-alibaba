package transkop.tracking.service;

import transkop.tracking.model.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    List<Product> getAll();
    Product getById(String id);
}
