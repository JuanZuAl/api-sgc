package co.github.JuanZuAl.application.exceptions;

/**
 * Representa una excepción de negocio.
 */
public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
     public BusinessException(String message, Throwable cause) {
        super(message, cause);
     }

}
