package co.github.JuanZuAl.services;

import co.github.JuanZuAl.domain.models.Enrollment;
import co.github.JuanZuAl.repository.EnrollmentRepository;
import java.util.List;
import java.util.Optional;

public class EnrollmentService implements EnrollmentRepository {

    EnrollmentRepository enrollmentRepository;
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }


    @Override
    public List<Enrollment> findAll() {
        return List.of();
    }

    @Override
    public Optional<Enrollment> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<Enrollment> update(Enrollment enrollment) {
        return Optional.empty();
    }

    @Override
    public boolean existsByEnrollmentId(Long enrollmentId) {
        return false;
    }
}
