package transkop.tracking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import transkop.tracking.controller.dto.ProductRequest;
import transkop.tracking.controller.dto.ProductResponse;
import transkop.tracking.controller.dto.mapper.ProductMapper;
import transkop.tracking.model.Product;
import transkop.tracking.service.ProductService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest request) {
        Product product = ProductMapper.dtoToEntity(request);
        Product createdProduct = productService.create(product);
        return ResponseEntity.ok(ProductMapper.entityToDto(createdProduct));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll() {
        List<Product> books = productService.getAll();
        return ResponseEntity.ok(books.stream().map(product -> ProductMapper.entityToDto(product)).collect(Collectors.toList()));
    }
}
