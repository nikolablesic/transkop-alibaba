package transkop.tracking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import transkop.tracking.utils.generators.HexadecimalSequenceIdGenerator;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @GenericGenerator(
            name = "product_seq",
            strategy = "transkop.tracking.utils.generators.HexadecimalSequenceIdGenerator",
            parameters = {
                    @Parameter(name = HexadecimalSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = HexadecimalSequenceIdGenerator.INITIAL_PARAM, value = "100000"),
                    @Parameter(name = HexadecimalSequenceIdGenerator.LENGTH_PARAM, value = "6") })
    private String id;
    private String name;
    private String dimensions;
    private Date productionDate;

    public Product(String name, String dimensions, Date productionDate){
        this.name = name;
        this.dimensions = dimensions;
        this.productionDate = productionDate;
    }

}
