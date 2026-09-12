package co.github.JuanZuAl.application.exceptions;

/**
 * Se lanza cuando no se encuentra una inscripción.
 */
public class EnrollmentNotFoundException extends ResourceNotFoundException {
    public EnrollmentNotFoundException(String message) {
        super(message);
    }
    public EnrollmentNotFoundException(String message, Throwable cause) {
        super(message);
    }
    public EnrollmentNotFoundException(Throwable cause) {
        super("Inscripción no encontrada");
    }
}
