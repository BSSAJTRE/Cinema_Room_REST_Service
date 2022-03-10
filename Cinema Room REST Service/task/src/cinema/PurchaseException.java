package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PurchaseException extends RuntimeException{
    public PurchaseException(String cause) {
        super(cause);
    }
}
