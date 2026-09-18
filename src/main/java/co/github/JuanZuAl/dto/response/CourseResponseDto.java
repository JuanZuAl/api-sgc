package co.github.JuanZuAl.dto.response;

import co.github.JuanZuAl.domain.models.Course;

public record CourseResponseDto (
        Long courseId,
        String code,
        String name,
        String description,
        Integer maxCapacity
){
    public static CourseResponseDto from(Course course) {
        return new CourseResponseDto(
                course.getCourseId(),
                course.getCode(),
                course.getName(),
                course.getDescription(),
                course.getMaxCapacity()
        );
    }
}
