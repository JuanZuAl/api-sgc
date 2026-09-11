package co.github.JuanZuAl.services;

import co.github.JuanZuAl.domain.models.Course;
import co.github.JuanZuAl.domain.models.Enrollment;
import co.github.JuanZuAl.repository.CourseRepository;

import java.util.List;

public interface CourseService  {
    Course findById(long id);
    Course create(Course course);
    Course update(Course course);
    void deleteById(long id);
    List<Course> findAll();
    Course findByName(String name);
}
