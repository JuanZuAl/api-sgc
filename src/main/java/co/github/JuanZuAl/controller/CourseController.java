package co.github.JuanZuAl.controller;


import co.github.JuanZuAl.application.exceptions.BusinessException;
import co.github.JuanZuAl.application.exceptions.CourseNotFoundException;
import co.github.JuanZuAl.domain.models.Course;
import co.github.JuanZuAl.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<Object> list() {
        try {
            var courses = courseService.findAll().stream().map(course -> {
                return new Course(course.getId(), course.getCode(), course.getName(), course.getDescription(), course.getMaxCapacity());
            }).toList();
            return ResponseEntity.ok(courses);
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(courseService.findById(id));
        } catch (CourseNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Object> findByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(courseService.findByName(name));
        } catch (CourseNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Course course) {
        try {
            var createdCourse = courseService.create(course);
            return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Course [id=%s] created", createdCourse.getId()));
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Course course) {
        try {
            course.setId(id);
            var updatedCourse = courseService.update(course);
            return ResponseEntity.ok(updatedCourse);
        } catch (CourseNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try {
            courseService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (CourseNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
