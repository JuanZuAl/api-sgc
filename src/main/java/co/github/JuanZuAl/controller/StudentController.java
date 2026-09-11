package co.github.JuanZuAl.controller;


import co.github.JuanZuAl.application.exceptions.BusinessException;
import co.github.JuanZuAl.domain.models.Student;
import co.github.JuanZuAl.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }
    @GetMapping
    public ResponseEntity<Object> list() {
        try {
            var students = studentService.findAll().stream().map(student -> {
                return new Student(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail(),student.getBirthDate());
            }).toList();
            return ResponseEntity.ok(students);
        }catch (BusinessException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Student student) {
        try {
            var createdStudent = studentService.create(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Student [id=%s] created", createdStudent.getId()));
        } catch (BusinessException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<Object> delete(@PathVariable Long id) {

            studentService.deleteById(id);
            return ResponseEntity.noContent().build();

    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@RequestBody Student student) {
        try {
            var updatedStudent = studentService.update(student);
            return ResponseEntity.ok(updatedStudent);
        } catch (BusinessException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
