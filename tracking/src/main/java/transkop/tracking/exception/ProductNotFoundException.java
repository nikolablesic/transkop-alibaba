package transkop.tracking.exception;

public class ProductNotFoundException extends RuntimeException {

    private String id;

    public ProductNotFoundException(String id) {
        super(String.format("Proizvod sa identifikatorom %s nije pronadjen!", id));
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
