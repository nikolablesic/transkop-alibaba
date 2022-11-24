package transkop.tracking.controller;

import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import transkop.tracking.controller.dto.ProductLocationRequest;
import transkop.tracking.controller.dto.ProductLocationResponse;
import transkop.tracking.controller.dto.ProductRequest;
import transkop.tracking.controller.dto.ProductResponse;
import transkop.tracking.controller.dto.mapper.ProductLocationMapper;
import transkop.tracking.controller.dto.mapper.ProductMapper;
import transkop.tracking.exception.ProductNotFoundException;
import transkop.tracking.model.Location;
import transkop.tracking.model.Product;
import transkop.tracking.service.LocationService;
import transkop.tracking.service.ProductService;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/product-locations")
public class ProductLocationController {

    private LocationService locationService;
    private ProductService productService;
    private SimpMessagingTemplate template;

    public ProductLocationController(LocationService locationService, ProductService productService, SimpMessagingTemplate template) {
        this.locationService = locationService;
        this.productService = productService;
        this.template = template;
    }

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody ProductLocationRequest request) {
        Product product = null;
        try{
            product = productService.getById(request.getProductId());
        } catch(ProductNotFoundException e){
            Message message = new Message() {
                @Override
                public Object getPayload() {
                    HashMap<String, Object> error = new HashMap<String, Object>();
                    error.put("id", request.getProductId());
                    error.put("creationDate", new Date());
                    Gson gson = new Gson();
                    String ret = gson.toJson(error);
                    return ret.getBytes();
                }

                @Override
                public MessageHeaders getHeaders() {
                    return null;
                }
            };
            template.send("/location/new", message);
            throw new ProductNotFoundException(request.getProductId());
        }
        Location location = ProductLocationMapper.dtoToEntity(request, product);
        Location createdProduct = locationService.create(location);
        //return ResponseEntity.ok(ProductLocationMapper.entityToDto(createdProduct));
        Message message = new Message() {
            @Override
            public Object getPayload() {
                Gson gson = new Gson();
                String ret = gson.toJson(createdProduct);
                return ret.getBytes();
            }

            @Override
            public MessageHeaders getHeaders() {
                return null;
            }
        };
        template.send("/location/new", message);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ProductLocationResponse>> getAll(){
        List<Location> response = locationService.getAll();
        return ResponseEntity.ok(response
                .stream()
                .map(r -> ProductLocationMapper.entityToDto(r))
                .collect(Collectors.toList()));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll(){
        locationService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<Void> deleteById(@PathVariable long id){
        locationService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
