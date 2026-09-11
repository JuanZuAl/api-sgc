package co.github.JuanZuAl.services;

import co.github.JuanZuAl.domain.models.Enrollment;
import java.util.List;

public interface EnrollmentService {
    Enrollment findById(long id);
    Enrollment create(Enrollment enrollment);
    Enrollment update(Enrollment enrollment);
    void deleteById(long id);
    List<Enrollment> findAll();
    Enrollment findByStudentId(long studentId);
    Enrollment findByCourseId(long courseId);


}
