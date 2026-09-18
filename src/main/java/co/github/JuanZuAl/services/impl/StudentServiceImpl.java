package co.github.JuanZuAl.services.impl;

import co.github.JuanZuAl.application.exceptions.StudentAlreadyExistsException;
import co.github.JuanZuAl.application.exceptions.StudentNotFoundException;
import co.github.JuanZuAl.domain.models.Student;
import co.github.JuanZuAl.dto.CreateStudentDto;
import co.github.JuanZuAl.dto.UpdateStudentDto;
import co.github.JuanZuAl.dto.response.StudentResponseDto;
import co.github.JuanZuAl.repository.StudentRepository;
import co.github.JuanZuAl.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + studentId + " does not exist."));
    }

    @Override
    public List<StudentResponseDto> findAll() {

        return studentRepository.findAll().stream()
                .map(student -> new StudentResponseDto(
                        student.getStudentId(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getEmail(),
                        student.getPhoneNumber()
                ))
                .toList();
    }

    @Override
    public Optional<Student> findByName(String name) {
        return studentRepository.findByFirstName(name);
    }

    @Override
    public Student create(CreateStudentDto student) {
        if (studentRepository.existsById(student.studentId())) {
            throw new StudentAlreadyExistsException("Student with ID " + student.studentId() + " already exists.");
        }
        if (studentRepository.existsByEmail(student.email())) {
            throw new StudentAlreadyExistsException("Student with email " + student.email() + " already exists.");
        }

        Student newStudent = new Student(
                student.studentId(),
                student.firstName(),
                student.lastName(),
                student.email(),
                student.phoneNumber()
        );
        return studentRepository.save(newStudent);
    }

    @Override
    public Student update(Long studentId, UpdateStudentDto student) {
        Student existing = findById(studentId);
        if (!existing.getEmail().equals(student.email()) && studentRepository.existsByEmail(student.email())) {
            throw new StudentAlreadyExistsException("Student with email " + student.email() + " already exists.");
        }
        Student newUpdatedStudent = new Student(
                studentId,
                student.firstName(),
                student.lastName(),
                student.email(),
                student.phoneNumber()
        );
        return studentRepository.save(newUpdatedStudent);
    }

    @Override
    public void deleteById(Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new StudentNotFoundException("Student with ID " + studentId + " does not exist.");
        }
        studentRepository.deleteById(studentId);
    }

    @Override
    public boolean existsById(Long studentId) {
        return studentRepository.existsById(studentId);
    }

    @Override
    public boolean existsByEmail(String email) {
        return studentRepository.existsByEmail(email);
    }

}
