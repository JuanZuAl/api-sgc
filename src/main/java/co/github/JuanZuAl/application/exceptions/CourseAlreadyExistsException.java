package co.github.JuanZuAl.application.exceptions;

/**
 * Se lanza cuando se intenta crear un curso que ya existe (por id o por código).
 */
public class CourseAlreadyExistsException extends ResourceAlreadyExistsException {
    public CourseAlreadyExistsException(String message) {
        super(message);
    }
}
