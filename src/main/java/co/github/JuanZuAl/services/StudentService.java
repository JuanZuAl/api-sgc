package co.github.JuanZuAl.services;

import co.github.JuanZuAl.domain.models.Student;
import co.github.JuanZuAl.dto.CreateStudentDto;
import co.github.JuanZuAl.dto.UpdateStudentDto;
import co.github.JuanZuAl.dto.response.StudentResponseDto;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student findById(Long studentId);
    List<StudentResponseDto> findAll();
    Optional<Student> findByName(String name);

    Student create(CreateStudentDto student);

    Student update(Long studentId, UpdateStudentDto student);
    void deleteById(Long studentId);
    boolean existsById(Long studentId);
    boolean existsByEmail(String email);
}
