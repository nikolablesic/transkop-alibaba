package transkop.tracking.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ProductResponse {
    private String id;
    private String name;
    private String dimensions;
    private Date productionDate;
}
