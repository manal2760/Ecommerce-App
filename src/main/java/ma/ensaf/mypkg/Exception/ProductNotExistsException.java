package ma.ensaf.mypkg.Exception;

public class ProductNotExistsException extends IllegalArgumentException {
    public ProductNotExistsException(String msg) {
        super(msg);
    }
}