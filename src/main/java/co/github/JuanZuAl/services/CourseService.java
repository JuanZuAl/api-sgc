package co.github.JuanZuAl.services;

import co.github.JuanZuAl.domain.models.Course;

import java.util.List;

public interface CourseService {

    Course findById(Long id);
    List<Course> findAll();
    Course findByName(String name);
    Course create(Course course);
    Course update(Course course);
    void deleteById(Long id);
    boolean existsById(Long id);
}
