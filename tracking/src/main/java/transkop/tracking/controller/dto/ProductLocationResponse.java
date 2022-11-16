package transkop.tracking.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ProductLocationResponse {
    private long id;
    private ProductResponse product;
    private double longitude;
    private double latitude;
    private Date creationDate;
}
