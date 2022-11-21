package transkop.tracking.exception;

public class ProductNotFoundException extends RuntimeException {

    private String id;

    public ProductNotFoundException(String id) {
        super("Ne postoji u bazi.");
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
