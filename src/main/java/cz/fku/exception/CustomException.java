package cz.fku.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Filip on 19.02.2017.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CustomException() {}

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
