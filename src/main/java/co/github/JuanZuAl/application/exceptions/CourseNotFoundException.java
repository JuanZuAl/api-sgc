package co.github.JuanZuAl.application.exceptions;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String message) {
        super(message);
    }
    public CourseNotFoundException(String message, Throwable cause) {
        super(message, cause);

    }
    public CourseNotFoundException(Throwable cause) {
        super("Course not found", cause);
    }
}
