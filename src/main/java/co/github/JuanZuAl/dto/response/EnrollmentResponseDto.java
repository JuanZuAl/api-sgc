package co.github.JuanZuAl.dto.response;

import co.github.JuanZuAl.domain.models.Enrollment;
import co.github.JuanZuAl.domain.models.EnrollmentStatus;

import java.time.LocalDate;

public record EnrollmentResponseDto(
        Long enrollmentId,
        Long studentId,
        Long courseId,
        LocalDate enrollmentDate,
        EnrollmentStatus status
) {

    public static EnrollmentResponseDto from(Enrollment enrollment) {
        return new EnrollmentResponseDto(
                enrollment.getEnrollmentId(),
                enrollment.getStudentId(),
                enrollment.getCourseId(),
                enrollment.getEnrollmentDate(),
                enrollment.getStatus()
        );
    }
}
