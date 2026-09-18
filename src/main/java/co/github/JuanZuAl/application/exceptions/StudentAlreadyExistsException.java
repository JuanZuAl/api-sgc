package co.github.JuanZuAl.application.exceptions;

/**
 * Se lanza cuando se intenta crear un estudiante que ya existe (por id o por email).
 */
public class StudentAlreadyExistsException extends ResourceAlreadyExistsException {
    public StudentAlreadyExistsException(String message) {
        super(message);
    }
}
