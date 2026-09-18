package co.github.JuanZuAl.repository.impl;

import co.github.JuanZuAl.domain.models.Course;
import co.github.JuanZuAl.repository.CourseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepositoryImpl {

    private final CourseRepository courseRepository;

    public CourseRepositoryImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Optional<Course> findByName(String name) {
        return courseRepository.findByName(name);
    }

    public boolean existsById(Long id) {
        return courseRepository.existsById(id);
    }

    public boolean existsByCode(String code) {
        return courseRepository.existsByCode(code);
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}
