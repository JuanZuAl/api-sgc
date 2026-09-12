package co.github.JuanZuAl.controller;


import co.github.JuanZuAl.application.exceptions.BusinessException;
import co.github.JuanZuAl.application.exceptions.CourseNotFoundException;
import co.github.JuanZuAl.application.exceptions.EnrollmentNotFoundException;
import co.github.JuanZuAl.application.exceptions.StudentNotFoundException;
import co.github.JuanZuAl.domain.models.Enrollment;
import co.github.JuanZuAl.services.EnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public ResponseEntity<Object> list() {
        try {
            var enrollments = enrollmentService.findAll().stream().map(enrollment -> {
                return new Enrollment(enrollment.getId(), enrollment.getStudentId(), enrollment.getCourseId(), enrollment.getEnrollmentDate(), enrollment.getStatus());
            }).toList();
            return ResponseEntity.ok(enrollments);
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(enrollmentService.findById(id));
        } catch (EnrollmentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("student/{studentId}")
    public ResponseEntity<Object> findByStudentId(@PathVariable Long studentId) {
        try {
            return ResponseEntity.ok(enrollmentService.findByStudentId(studentId));
        } catch (StudentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("course/{courseId}")
    public ResponseEntity<Object> findByCourseId(@PathVariable Long courseId) {
        try {
            return ResponseEntity.ok(enrollmentService.findByCourseId(courseId));
        } catch (CourseNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Enrollment enrollment) {
        try {
            var createdEnrollment = enrollmentService.create(enrollment);
            return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Enrollment [id=%s] created", createdEnrollment.getId()));
        } catch (StudentNotFoundException | CourseNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        try {
            enrollment.setId(id);
            var updatedEnrollment = enrollmentService.update(enrollment);
            return ResponseEntity.ok(updatedEnrollment);
        } catch (EnrollmentNotFoundException | StudentNotFoundException | CourseNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("{id}/cancel")
    public ResponseEntity<Object> cancel(@PathVariable Long id) {
        try {
            var cancelledEnrollment = enrollmentService.cancel(id);
            return ResponseEntity.ok(cancelledEnrollment);
        } catch (EnrollmentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try {
            enrollmentService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EnrollmentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (BusinessException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
