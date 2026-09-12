package co.github.JuanZuAl.services.impl;

import co.github.JuanZuAl.application.exceptions.BusinessException;
import co.github.JuanZuAl.application.exceptions.CourseNotFoundException;
import co.github.JuanZuAl.domain.models.Course;
import co.github.JuanZuAl.repository.CourseRepository;
import co.github.JuanZuAl.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course with id " + id + " not found"));
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findByName(String name) {
        return courseRepository.findByName(name)
                .orElseThrow(() -> new CourseNotFoundException("Course with name " + name + " not found"));
    }

    @Override
    public Course create(Course course) {
        validate(course);
        if (course.getId() == null) {
            throw new BusinessException("Course id cannot be null");
        }
        if (courseRepository.existsById(course.getId())) {
            throw new BusinessException("Course with id " + course.getId() + " already exists");
        }
        if (courseRepository.existsByCode(course.getCode())) {
            throw new BusinessException("Course with code " + course.getCode() + " already exists");
        }
        return courseRepository.save(course);
    }

    @Override
    public Course update(Course course) {
        validate(course);
        Course existing = findById(course.getId());
        if (!existing.getCode().equals(course.getCode()) && courseRepository.existsByCode(course.getCode())) {
            throw new BusinessException("Course with code " + course.getCode() + " already exists");
        }
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new CourseNotFoundException("Course with id " + id + " not found");
        }
        courseRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return courseRepository.existsById(id);
    }

    private void validate(Course course) {
        if (course.getCode() == null || course.getCode().isEmpty()) {
            throw new BusinessException("Course code cannot be null or empty");
        }
        if (course.getName() == null || course.getName().isEmpty()) {
            throw new BusinessException("Course name cannot be null or empty");
        }
        if (course.getDescription() == null || course.getDescription().isEmpty()) {
            throw new BusinessException("Course description cannot be null or empty");
        }
        if (course.getMaxCapacity() == null || course.getMaxCapacity() <= 0) {
            throw new BusinessException("Course max capacity must be greater than zero");
        }
    }
}
