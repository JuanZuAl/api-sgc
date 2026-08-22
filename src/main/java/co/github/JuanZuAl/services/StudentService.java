package co.github.JuanZuAl.services;

import co.github.JuanZuAl.domain.models.Student;
import co.github.JuanZuAl.repository.StudentRepository;
import java.util.List;
import java.util.Optional;

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> findAll() {
        return List.of();
    }


    public Optional<Student> findByName(String name) {
        return Optional.empty();
    }


    public Student save(Student student) {
        return studentRepository.save(student);
    }


    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public boolean existsByStudentId(Long studentId) {
        return studentRepository.existsById(studentId);
    }


    public boolean existsByEmail(String email) {
        return studentRepository.existsByEmail(email);
    }


    public void deleteStudentById(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        }
    }


    public Optional<Student> update(Student student) {
        if (studentRepository.existsById(student.getId())) {
            return Optional.of(studentRepository.save(student));
        }
        return Optional.empty();
    }
}