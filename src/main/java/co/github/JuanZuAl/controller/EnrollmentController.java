package co.github.JuanZuAl.controller;


import co.github.JuanZuAl.dto.CreateEnrollmentDto;
import co.github.JuanZuAl.dto.UpdateEnrollmentDto;
import co.github.JuanZuAl.dto.response.EnrollmentResponseDto;
import co.github.JuanZuAl.services.EnrollmentService;
import jakarta.validation.Valid;
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
        var enrollments = enrollmentService.findAll().stream()
                .map(EnrollmentResponseDto::from)
                .toList();
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return ResponseEntity.ok(EnrollmentResponseDto.from(enrollmentService.findById(id)));
    }

    @GetMapping("student/{studentId}")
    public ResponseEntity<Object> findByStudentId(@PathVariable Long studentId) {
        var enrollments = enrollmentService.findByStudentId(studentId).stream()
                .map(EnrollmentResponseDto::from)
                .toList();
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("course/{courseId}")
    public ResponseEntity<Object> findByCourseId(@PathVariable Long courseId) {
        var enrollments = enrollmentService.findByCourseId(courseId).stream()
                .map(EnrollmentResponseDto::from)
                .toList();
        return ResponseEntity.ok(enrollments);
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody CreateEnrollmentDto enrollment) {
        var createdEnrollment = enrollmentService.create(enrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(EnrollmentResponseDto.from(createdEnrollment));
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @Valid @RequestBody UpdateEnrollmentDto enrollment) {
        var updatedEnrollment = enrollmentService.update(id, enrollment);
        return ResponseEntity.ok(EnrollmentResponseDto.from(updatedEnrollment));
    }

    @PatchMapping("{id}/cancel")
    public ResponseEntity<Object> cancel(@PathVariable Long id) {
        var cancelledEnrollment = enrollmentService.cancel(id);
        return ResponseEntity.ok(EnrollmentResponseDto.from(cancelledEnrollment));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        enrollmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
