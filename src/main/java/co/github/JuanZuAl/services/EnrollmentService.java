package co.github.JuanZuAl.services;

import co.github.JuanZuAl.domain.models.Enrollment;

import java.util.List;

public interface EnrollmentService {

    Enrollment findById(Long id);
    List<Enrollment> findAll();
    List<Enrollment> findByStudentId(Long studentId);
    List<Enrollment> findByCourseId(Long courseId);
    Enrollment create(Enrollment enrollment);
    Enrollment update(Enrollment enrollment);
    Enrollment cancel(Long id);
    void deleteById(Long id);
    boolean existsById(Long id);
}
