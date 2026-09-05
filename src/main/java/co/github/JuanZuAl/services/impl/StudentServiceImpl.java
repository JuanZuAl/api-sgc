package co.github.JuanZuAl.services.impl;

import co.github.JuanZuAl.domain.models.Student;
import co.github.JuanZuAl.repository.StudentRepository;
import co.github.JuanZuAl.services.StudentService;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {

    private final StudentService studentService;

    public StudentServiceImpl(StudentService studentService) {
        this.studentService= studentService;
    }


    public List<Student> findAll() {
        return List.of();
    }


    public Optional<Student> findByName(String name) {
        return Optional.empty();
    }


    public Student create(Student student) {
        if (existsByStudentId(student.getId())) {
            throw new IllegalArgumentException("Student with ID " + student.getId() + " already exists.");
        }
        if  (existsByEmail(student.getEmail())) {
            throw new IllegalArgumentException("Student with email " + student.getEmail() + " already exists.");
        }
        if (student.getFirstName() == null || student.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("Student first name cannot be null or empty.");
        }
        if (student.getLastName() == null || student.getLastName().isEmpty()) {
            throw new IllegalArgumentException("Student last name cannot be null or empty.");
        }
        if (student.getEmail() == null || student.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Student email cannot be null or empty.");
        }
        return studentService.create(student);
    }


    public void deleteById(Long id) {
        if (!existsByStudentId(id)) {
            throw new IllegalArgumentException("Student with ID " + id + " does not exist.");
        }
        studentService.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        if (!existsByStudentId(id)) {
            throw new IllegalArgumentException("Student with ID " + id + " does not exist.");
        }
        if (id == null) {
            throw new IllegalArgumentException("Student ID cannot be null.");
        }
        return studentService.existsById(id);
    }

    public boolean existsByStudentId(Long studentId) {
        if (studentId == null) {
            throw new IllegalArgumentException("Student ID cannot be null.");
        }
        if(!studentService.existsById(studentId)) {
            throw new IllegalArgumentException("Student with ID " + studentId + " does not exist.");
        }
        return studentService.existsById(studentId);
    }


    public boolean existsByEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Student email cannot be null or empty.");
        }
        if (!studentService.existsByEmail(email)) {
            throw new IllegalArgumentException("Student with email " + email + " does not exist.");
        }
        return studentService.existsByEmail(email);
    }




    public Optional<Student> update(Student student) {
     if (!existsByStudentId(student.getId())) {
            throw new IllegalArgumentException("Student with ID " + student.getId() + " does not exist.");
        }
        if (student.getFirstName() == null || student.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("Student first name cannot be null or empty.");
        }
        if (student.getLastName() == null || student.getLastName().isEmpty()) {
            throw new IllegalArgumentException("Student last name cannot be null or empty.");
        }
        if (student.getEmail() == null || student.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Student email cannot be null or empty.");
        }

        return studentService.update(student);
    }
}