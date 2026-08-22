package co.github.JuanZuAl.controller;


import co.github.JuanZuAl.domain.models.Student;
import co.github.JuanZuAl.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/students")
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

}
