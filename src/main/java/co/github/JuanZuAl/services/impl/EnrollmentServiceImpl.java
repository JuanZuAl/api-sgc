package co.github.JuanZuAl.services.impl;

import co.github.JuanZuAl.domain.models.Enrollment;
import co.github.JuanZuAl.repository.EnrollmentRepository;
import co.github.JuanZuAl.services.EnrollmentService;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public class EnrollmentServiceImpl implements EnrollmentService {

    EnrollmentService enrollmentService;
    public EnrollmentServiceImpl(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @Override
    public Enrollment findById(long id) {
        if (enrollmentService.findById(id) == null || enrollmentService.findAll().isEmpty()) {
            throw new EntityNotFoundException("Enrollment with id " + id + " not found");
        }
        return enrollmentService.findById(id);
    }

    @Override
    public Enrollment create(Enrollment enrollment) {
        if (enrollmentService.findById(enrollment.getId()) == null || enrollmentService.findAll().isEmpty()) {
            throw new IllegalArgumentException("Enrollment with id " + enrollment.getId() + " already exists");
        }
       if (enrollmentService.findAll().stream().anyMatch(e -> e.getId().equals(enrollment.getId()))) {
            throw new IllegalArgumentException("Enrollment with id " + enrollment.getId() + " already exists");
       }
        return null;
    }

    @Override
    public Enrollment update(Enrollment enrollment) {
        if (enrollmentService.findById(enrollment.getId()) == null || enrollmentService.findAll().isEmpty()) {
            throw new EntityNotFoundException("Enrollment with id " + enrollment.getId() + " not found");
        }
        if (enrollmentService.findAll().stream().noneMatch(e -> e.getId().equals(enrollment.getId()))) {
            throw new EntityNotFoundException("Enrollment with id " + enrollment.getId() + " not found");
        }
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public List<Enrollment> findAll() {
        return List.of();
    }

    @Override
    public Enrollment findByStudentId(long studentId) {
        return null;
    }

    @Override
    public Enrollment findByCourseId(long courseId) {
        return null;
    }
}
