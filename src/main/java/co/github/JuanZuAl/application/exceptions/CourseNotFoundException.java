package co.github.JuanZuAl.application.exceptions;

/**
 * Se lanza cuando no se encuentra un curso.
 */
public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String message) {
        super(message);
    }
    public CourseNotFoundException(String message, Throwable cause) {
        super(message, cause);

    }
    public CourseNotFoundException(Throwable cause) {
        super("Curso no encontrado", cause);
    }
}
