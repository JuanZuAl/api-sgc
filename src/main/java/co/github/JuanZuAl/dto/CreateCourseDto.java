package co.github.JuanZuAl.dto;

import jakarta.validation.constraints.*;

public record CreateCourseDto(
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
