package co.github.JuanZuAl.dto;

import co.github.JuanZuAl.domain.models.EnrollmentStatus;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateEnrollmentDto(
        @NotNull
        Long enrollmentId,
        @NotNull
        Long studentId,
        @NotNull
        Long courseId,
        /** Opcional: si no se envía se usa la fecha actual. */
        LocalDate enrollmentDate,
        /** Opcional: si no se envía se usa ACTIVE. */
        EnrollmentStatus status
) {

}
