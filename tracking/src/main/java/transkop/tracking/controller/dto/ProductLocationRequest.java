package transkop.tracking.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class ProductLocationRequest {
    @NotBlank(message = "Polje productId je obavezno")
    private String productId;
    private double longitude;
    private double latitude;
}
