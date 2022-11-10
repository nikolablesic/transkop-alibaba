package transkop.tracking.exception;

public class ProductNotFoundException extends RuntimeException {

    private String id;

    public ProductNotFoundException(String id) {
        super(String.format("Product with id %s not found!", id));
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
