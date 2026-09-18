package co.github.JuanZuAl.dto;

import co.github.JuanZuAl.domain.models.EnrollmentStatus;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UpdateEnrollmentDto(
        @NotNull
        Long enrollmentId,
        @NotNull
        Long studentId,
        @NotNull
        Long courseId,
        @NotNull
        LocalDate enrollmentDate,
        @NotNull
        EnrollmentStatus status
) {

}
