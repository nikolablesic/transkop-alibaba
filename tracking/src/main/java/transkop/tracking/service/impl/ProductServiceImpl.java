package transkop.tracking.service.impl;

import org.springframework.stereotype.Service;
import transkop.tracking.exception.ProductNotFoundException;
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

    @Override
    public Product getById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public Product update(Product product) {
        if(!productRepository.existsById(product.getId())){
            throw new ProductNotFoundException(product.getId());
        }
        return productRepository.save(product);
    }
}
