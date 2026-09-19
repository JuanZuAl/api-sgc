package co.github.JuanZuAl.controller;

import co.github.JuanZuAl.dto.CreateStudentDto;
import co.github.JuanZuAl.dto.UpdateStudentDto;
import co.github.JuanZuAl.dto.response.StudentResponseDto;
import co.github.JuanZuAl.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<Object> list() {
            var students = studentService.findAll();
            return ResponseEntity.ok(students);
    }

    @GetMapping("{studentId}")
    public ResponseEntity<Object> findById(@PathVariable Long studentId) {
            return ResponseEntity.ok(StudentResponseDto.from(studentService.findById(studentId)));
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody CreateStudentDto student) {
            var createdStudent = studentService.create(student);
            return ResponseEntity.status(HttpStatus.CREATED).body( StudentResponseDto.from(createdStudent));
    }

    @PutMapping("{studentId}")
    public ResponseEntity<Object> update(@PathVariable Long studentId, @Valid @RequestBody UpdateStudentDto student) {
            var updatedStudent = studentService.update(studentId, student);
            return ResponseEntity.ok(StudentResponseDto.from(updatedStudent));
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity<Object> delete(@PathVariable Long studentId) {

            studentService.deleteById(studentId);
            return ResponseEntity.noContent().build();

    }
}
