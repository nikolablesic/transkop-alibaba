package transkop.tracking.controller.dto.mapper;

import transkop.tracking.controller.dto.ProductLocationRequest;
import transkop.tracking.controller.dto.ProductLocationResponse;
import transkop.tracking.controller.dto.ProductResponse;
import transkop.tracking.model.Location;
import transkop.tracking.model.Product;

public class ProductLocationMapper {
    public static ProductLocationResponse entityToDto(Location location) {
        return new ProductLocationResponse(location.getId(), ProductMapper.entityToDto(location.getProduct()), location.getLongitude(), location.getLatitude());
    }
    public static Location dtoToEntity(ProductLocationRequest request, Product product) {
        if (request == null || product == null) {
            return null;
        }
        return new Location(product, request.getLongitude(), request.getLatitude());
    }
}
