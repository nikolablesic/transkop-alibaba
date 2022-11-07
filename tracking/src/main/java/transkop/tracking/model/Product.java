package transkop.tracking.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String dimensions;
    private Date productionDate;

    public Product(String name, String dimensions, Date productionDate){
        this.name = name;
        this.dimensions = dimensions;
        this.productionDate = productionDate;
    }

}
