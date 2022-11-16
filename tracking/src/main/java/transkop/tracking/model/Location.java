package transkop.tracking.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Product product;
    private double longitude;
    private double latitude;
    private Date creationDate;

    public Location(Product product, double longitude, double latitude){
        this.product = product;
        this.longitude = longitude;
        this.latitude = latitude;
        this.creationDate = new Date();
    }
}
