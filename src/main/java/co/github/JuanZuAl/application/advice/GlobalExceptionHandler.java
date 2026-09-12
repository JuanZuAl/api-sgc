package co.github.JuanZuAl.application.advice;

import co.github.JuanZuAl.application.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * Traduce las excepciones de negocio a respuestas HTTP.
 * Aplica a todos los controllers de la aplicación.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public String handleException(ResourceNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler
    public String handleException(ResourceAlreadyExistsException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler
    public String handleException(ResourceConflictException ex) {
        return ex.getMessage();
    }
}
