package co.github.JuanZuAl.application.exceptions;

/**
 * Se lanza cuando una operación sobre un curso viola una regla de negocio.
 */
public class CourseConflictException extends ResourceConflictException {
    public CourseConflictException(String message) {
        super(message);
    }
}
