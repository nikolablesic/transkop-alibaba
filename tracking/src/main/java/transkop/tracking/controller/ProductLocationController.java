package transkop.tracking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import transkop.tracking.controller.dto.ProductLocationRequest;
import transkop.tracking.controller.dto.ProductLocationResponse;
import transkop.tracking.controller.dto.ProductRequest;
import transkop.tracking.controller.dto.ProductResponse;
import transkop.tracking.controller.dto.mapper.ProductLocationMapper;
import transkop.tracking.controller.dto.mapper.ProductMapper;
import transkop.tracking.model.Location;
import transkop.tracking.model.Product;
import transkop.tracking.service.LocationService;
import transkop.tracking.service.ProductService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/product-locations")
public class ProductLocationController {

    private LocationService locationService;
    private ProductService productService;

    public ProductLocationController(LocationService locationService, ProductService productService) {
        this.locationService = locationService;
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductLocationResponse> create(@Valid @RequestBody ProductLocationRequest request) {
        Product product = productService.getById(request.getProductId());
        Location location = ProductLocationMapper.dtoToEntity(request, product);
        Location createdProduct = locationService.create(location);
        return ResponseEntity.ok(ProductLocationMapper.entityToDto(createdProduct));
    }
}
