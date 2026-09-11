package co.github.JuanZuAl.services.impl;

import co.github.JuanZuAl.domain.models.Course;
import co.github.JuanZuAl.services.CourseService;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private final CourseService courseService;

    public CourseServiceImpl(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public List<Course> findAll() {
        return List.of();
    }

    @Override
    public Course findByName(String name) {
        if (courseService.findAll().isEmpty()) {
            throw new EntityNotFoundException("Course with name " + name + " not found");
        }
        return courseService.findAll().stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Course with name " + name + " not found"));
    }

    @Override
    public Course findById(long id) {
        if (courseService.findById(id) == null || courseService.findAll().isEmpty()) {
            throw new EntityNotFoundException("Course with id " + id + " not found");
        }
        if (courseService.findById(id) == null) {
            throw new EntityNotFoundException("Course with id " + id + " not found");
        }
        return courseService.findById(id);
    }

    @Override
    public Course create(Course course) {
        if (courseService.findById(course.getId()) != null || courseService.findAll().stream().anyMatch(c -> c.getId().equals(course.getId()))) {;
            throw new IllegalArgumentException("Course with id " + course.getId() + " already exists");
        }
        if (courseService.findAll().isEmpty()) {
            throw new IllegalArgumentException("Course cannot be empty");
        }
        return courseService.create(course);
    }

    @Override
    public Course update(Course course) {
        if (courseService.findById(course.getId()) == null) {
            throw new EntityNotFoundException("Course with id " + course.getId() + " not found");
        }
        if (courseService.findAll().isEmpty()) {
            throw new IllegalArgumentException("Course cannot be empty");
        }
        return courseService.update(course);
    }

    @Override
    public void deleteById(long id) {
        if (courseService.findById(id) == null || courseService.findAll().isEmpty()) {
            throw new EntityNotFoundException("Course with id " + id + " not found");
        }
        if (courseService.findAll().stream().noneMatch(c -> c.getId().equals(id))) {
            throw new EntityNotFoundException("Course with id " + id + " not found");
        }
        courseService.deleteById(id);
    }

}

