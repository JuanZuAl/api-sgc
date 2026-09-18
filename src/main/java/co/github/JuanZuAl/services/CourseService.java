package co.github.JuanZuAl.services;

import co.github.JuanZuAl.domain.models.Course;
import co.github.JuanZuAl.dto.CreateCourseDto;
import co.github.JuanZuAl.dto.CreateStudentDto;
import co.github.JuanZuAl.dto.UpdateCourseDto;

import java.util.List;

public interface CourseService {

    Course findById(Long id);
    List<Course> findAll();
    Course findByName(String name);
    Course create(CreateCourseDto course);
    Course update(Long courseId, UpdateCourseDto course);
    void deleteById(Long id);
    boolean existsById(Long id);
}
