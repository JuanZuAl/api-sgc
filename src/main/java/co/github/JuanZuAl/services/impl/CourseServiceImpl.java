package co.github.JuanZuAl.services.impl;

import co.github.JuanZuAl.application.exceptions.BusinessException;
import co.github.JuanZuAl.application.exceptions.CourseAlreadyExistsException;
import co.github.JuanZuAl.application.exceptions.CourseNotFoundException;
import co.github.JuanZuAl.domain.models.Course;
import co.github.JuanZuAl.dto.CreateCourseDto;
import co.github.JuanZuAl.dto.UpdateCourseDto;
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
    public Course create(CreateCourseDto course) {
        if (course.courseId() == null) {
            throw new BusinessException("Course id cannot be null");
        }
        if (courseRepository.existsById(course.courseId())) {
            throw new CourseAlreadyExistsException("Course with id " + course.courseId() + " already exists");
        }
        if (courseRepository.existsByCode(course.code())) {
            throw new CourseAlreadyExistsException("Course with code " + course.code() + " already exists");
        }
        Course newCourse = new Course(
                course.courseId(),
                course.code(),
                course.name(),
                course.description(),
                course.maxCapacity()
        );
        return courseRepository.save(newCourse);
    }

    @Override
    public Course update(Long courseId, UpdateCourseDto course) {
        Course existing = findById(courseId);
        if (!existing.getCode().equals(course.code()) && courseRepository.existsByCode(course.code())) {
            throw new CourseAlreadyExistsException("Course with code " + course.code() + " already exists");
        }
        Course updatedCourse = new Course(
                courseId,
                course.code(),
                course.name(),
                course.description(),
                course.maxCapacity()
        );
        return courseRepository.save(updatedCourse);
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

}
