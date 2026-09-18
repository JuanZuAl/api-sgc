package co.github.JuanZuAl.application.exceptions;

/**
 * Se lanza cuando se intenta crear una inscripción que ya existe
 * (por id o porque el estudiante ya está inscrito en el curso).
 */
public class EnrollmentAlreadyExistsException extends ResourceAlreadyExistsException {
    public EnrollmentAlreadyExistsException(String message) {
        super(message);
    }
}
