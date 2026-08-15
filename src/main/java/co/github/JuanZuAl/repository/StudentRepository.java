package co.github.JuanZuAl.repository;

import co.github.JuanZuAl.domain.models.Student;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    List<Student> findAll();
    Optional<Student> findByName(String name);
    Student save(Student student);
    void deleteById(Long id);
    Optional<Student> update(Student student);
    boolean existsByStudentId(Long studentId);
    boolean existsByEmail(String email);
    void deleteStudentById(Long id);
}
