package co.github.JuanZuAl.repository.impl;

import co.github.JuanZuAl.domain.models.Student;
import co.github.JuanZuAl.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentRepositoryImpl  {

    private final StudentRepository studentRepository;

    public StudentRepositoryImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Optional<Student> findById(Long id) {

        return studentRepository.findById(id);
    }
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public boolean existsByEmail(String email) {
        return studentRepository.existsByEmail(email);
    }

    public boolean existsById(Long id) {
        return studentRepository.existsById(id);
    }
    public Student save(Student student) {
        return studentRepository.save(student);
    }

}
