package transkop.tracking.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        StringBuilder str = new StringBuilder();
        for (ObjectError error : ex.getAllErrors()) {
            str.append(error.getDefaultMessage());
            str.append(System.lineSeparator());
        }
        return str.toString();
    }


}
