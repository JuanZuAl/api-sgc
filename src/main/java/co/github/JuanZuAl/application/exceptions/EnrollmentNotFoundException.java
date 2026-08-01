package co.github.JuanZuAl.application.exceptions;

public class EnrollmentNotFoundException extends RuntimeException {
    public EnrollmentNotFoundException(String message) {
        super(message);
    }
    public EnrollmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public EnrollmentNotFoundException(Throwable cause) {
        super("Enrollment not found", cause);
    }
}

