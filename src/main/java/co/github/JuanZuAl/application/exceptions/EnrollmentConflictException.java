package co.github.JuanZuAl.application.exceptions;

/**
 * Se lanza cuando una operación sobre una inscripción viola una regla de negocio
 * (curso sin cupo, cancelar una inscripción que no está activa, etc.).
 */
public class EnrollmentConflictException extends ResourceConflictException {
    public EnrollmentConflictException(String message) {
        super(message);
    }
}
