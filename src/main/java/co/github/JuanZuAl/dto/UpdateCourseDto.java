package co.github.JuanZuAl.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;

public record UpdateCourseDto(
        @NotNull
        Long courseId,
        @NotBlank
        String code,
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotNull
        @Positive
        Integer maxCapacity
) {
}
