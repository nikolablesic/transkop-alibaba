package transkop.tracking.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import transkop.tracking.exception.ProductNotFoundException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler({ProductNotFoundException.class})
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleEntityNotFoundException(Exception ex) {
        return ex.getMessage();
    }

}
