package transkop.tracking.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class ProductResponse {
    private UUID id;
    private String name;
    private String dimensions;
    private Date productionDate;
}
