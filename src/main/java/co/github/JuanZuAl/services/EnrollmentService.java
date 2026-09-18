package co.github.JuanZuAl.services;

import co.github.JuanZuAl.domain.models.Enrollment;
import co.github.JuanZuAl.dto.CreateEnrollmentDto;
import co.github.JuanZuAl.dto.UpdateEnrollmentDto;

import java.util.List;

public interface EnrollmentService {

    Enrollment findById(Long id);
    List<Enrollment> findAll();
    List<Enrollment> findByStudentId(Long studentId);
    List<Enrollment> findByCourseId(Long courseId);
    Enrollment create(CreateEnrollmentDto enrollment);
    Enrollment update(Long enrollmentId, UpdateEnrollmentDto enrollment);
    Enrollment cancel(Long id);
    void deleteById(Long id);
    boolean existsById(Long id);
}
