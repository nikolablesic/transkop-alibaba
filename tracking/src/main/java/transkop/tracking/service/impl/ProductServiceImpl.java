package transkop.tracking.service.impl;

import org.springframework.stereotype.Service;
import transkop.tracking.model.Product;
import transkop.tracking.repository.ProductRepository;
import transkop.tracking.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
