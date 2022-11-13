package transkop.tracking.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@AllArgsConstructor
public class ProductRequest {
    @NotBlank(message = "Polje name je obavezno")
    private String name;
    @NotBlank(message = "Polje dimensions je obavezno")
    private String dimensions;
    @NotNull(message = "Polkje productionDate je obavezno")
    private Date productionDate;
}
