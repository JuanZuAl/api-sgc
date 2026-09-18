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
@RequestMapping("/students")
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

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
            return ResponseEntity.ok(StudentResponseDto.from(studentService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody CreateStudentDto student) {
            var createdStudent = studentService.create(student);
            return ResponseEntity.status(HttpStatus.CREATED).body( StudentResponseDto.from(createdStudent));
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @Valid @RequestBody UpdateStudentDto student) {
            var updatedStudent = studentService.update(id, student);
            return ResponseEntity.ok(StudentResponseDto.from(updatedStudent));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {

            studentService.deleteById(id);
            return ResponseEntity.noContent().build();

    }
}
