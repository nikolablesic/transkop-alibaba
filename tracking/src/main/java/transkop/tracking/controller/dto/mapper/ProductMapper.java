package transkop.tracking.controller.dto.mapper;

import transkop.tracking.controller.dto.ProductRequest;
import transkop.tracking.controller.dto.ProductResponse;
import transkop.tracking.model.Product;

public class ProductMapper {

    public static ProductResponse entityToDto(Product product) {
        return new ProductResponse(product.getId(), product.getName(), product.getDimensions(), product.getProductionDate());
    }

    public static Product dtoToEntity(ProductRequest request) {
        if (request == null) {
            return null;
        }
        return new Product(request.getName(), request.getDimensions(), request.getProductionDate());
    }

    public static Product dtoToEntity(String id, ProductRequest request) {
        if (request == null) {
            return null;
        }
        return new Product(id, request.getName(), request.getDimensions(), request.getProductionDate());
    }

}
