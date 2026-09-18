package co.github.JuanZuAl.controller;


import co.github.JuanZuAl.domain.models.Course;
import co.github.JuanZuAl.dto.CreateCourseDto;
import co.github.JuanZuAl.dto.UpdateCourseDto;
import co.github.JuanZuAl.dto.response.CourseResponseDto;
import co.github.JuanZuAl.services.CourseService;
import jakarta.validation.Valid;
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
        var courses = courseService.findAll().stream().map(course -> {
            return new Course(course.getCourseId(), course.getCode(), course.getName(), course.getDescription(), course.getMaxCapacity());
        }).toList();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.findById(id));
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Object> findByName(@PathVariable String name) {
        return ResponseEntity.ok(courseService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody CreateCourseDto course) {
        var createdCourse = courseService.create(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(CourseResponseDto.from(createdCourse));
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @Valid @RequestBody UpdateCourseDto course) {
        var updatedCourse = courseService.update(id, course);
        return ResponseEntity.ok(CourseResponseDto.from(updatedCourse));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        courseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
