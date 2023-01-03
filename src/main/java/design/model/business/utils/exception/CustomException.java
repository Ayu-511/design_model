package design.model.business.utils.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private Integer code;

    private final String message;

    public CustomException(String message) {
        super(message);
        this.code = 500;
        this.message = message;
    }

    public CustomException(String message, Integer code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public CustomException(Integer code, String message) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public CustomException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    public CustomException(Throwable e) {
        super(e);
        this.message = e.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
