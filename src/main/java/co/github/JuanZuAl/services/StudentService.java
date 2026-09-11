package co.github.JuanZuAl.services;

import co.github.JuanZuAl.domain.models.Student;
import co.github.JuanZuAl.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

public interface StudentService  {


    Student create(Student student);
    void deleteById(Long id);
    boolean existsById(Long id);
    boolean existsByEmail(String email);
    List<Student> findAll();
    Optional<Student> findByName(String name);
    boolean existsByStudentId(Long studentId);
    Optional<Student> update(Student student);
    boolean enrollmentStatus(Long studentId);
}
