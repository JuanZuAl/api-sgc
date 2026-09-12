package co.github.JuanZuAl.application.exceptions;

/**
 * Se lanza cuando no se encuentra un estudiante.
 */
public class StudentNotFoundException extends ResourceNotFoundException {
    public StudentNotFoundException(String message) {
        super(message);
    }
    public StudentNotFoundException(String message, Throwable cause) {
        super(message);
    }
    public StudentNotFoundException(Throwable cause) {
        super("Estudiante no encontrado");
    }
}
