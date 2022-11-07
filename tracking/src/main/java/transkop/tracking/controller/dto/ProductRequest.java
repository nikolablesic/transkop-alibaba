package transkop.tracking.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@AllArgsConstructor
public class ProductRequest {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Dimensions is mandatory")
    private String dimensions;
    @NotNull(message = "Production date is mandatory")
    private Date productionDate;
}
