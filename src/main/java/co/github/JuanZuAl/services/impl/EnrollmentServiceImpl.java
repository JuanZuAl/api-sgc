package co.github.JuanZuAl.services.impl;

import co.github.JuanZuAl.application.exceptions.BusinessException;
import co.github.JuanZuAl.application.exceptions.EnrollmentNotFoundException;
import co.github.JuanZuAl.domain.models.Course;
import co.github.JuanZuAl.domain.models.Enrollment;
import co.github.JuanZuAl.domain.models.EnrollmentStatus;
import co.github.JuanZuAl.repository.EnrollmentRepository;
import co.github.JuanZuAl.services.CourseService;
import co.github.JuanZuAl.services.EnrollmentService;
import co.github.JuanZuAl.services.StudentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository,
                                 StudentService studentService,
                                 CourseService courseService) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @Override
    public Enrollment findById(Long id) {
        return enrollmentRepository.findById(id)
                .orElseThrow(() -> new EnrollmentNotFoundException("Enrollment with id " + id + " not found"));
    }

    @Override
    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    @Override
    public List<Enrollment> findByStudentId(Long studentId) {
        // Lanza StudentNotFoundException si el estudiante no existe
        studentService.findById(studentId);
        return enrollmentRepository.findByStudentId(studentId);
    }

    @Override
    public List<Enrollment> findByCourseId(Long courseId) {
        // Lanza CourseNotFoundException si el curso no existe
        courseService.findById(courseId);
        return enrollmentRepository.findByCourseId(courseId);
    }

    @Override
    public Enrollment create(Enrollment enrollment) {
        if (enrollment.getId() == null) {
            throw new BusinessException("Enrollment id cannot be null");
        }
        if (enrollmentRepository.existsById(enrollment.getId())) {
            throw new BusinessException("Enrollment with id " + enrollment.getId() + " already exists");
        }
        validate(enrollment);

        // El estudiante y el curso deben existir
        studentService.findById(enrollment.getStudentId());
        Course course = courseService.findById(enrollment.getCourseId());

        if (enrollmentRepository.existsByStudentIdAndCourseId(enrollment.getStudentId(), enrollment.getCourseId())) {
            throw new BusinessException("Student " + enrollment.getStudentId()
                    + " is already enrolled in course " + enrollment.getCourseId());
        }
        if (enrollmentRepository.countByCourseId(course.getId()) >= course.getMaxCapacity()) {
            throw new BusinessException("Course " + course.getId() + " has reached its max capacity");
        }

        if (enrollment.getEnrollmentDate() == null) {
            enrollment.setEnrollmentDate(LocalDate.now());
        }
        if (enrollment.getStatus() == null) {
            enrollment.setStatus(EnrollmentStatus.ACTIVE);
        }
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment update(Enrollment enrollment) {
        findById(enrollment.getId());
        validate(enrollment);
        studentService.findById(enrollment.getStudentId());
        courseService.findById(enrollment.getCourseId());
        if (enrollment.getEnrollmentDate() == null) {
            throw new BusinessException("Enrollment date cannot be null");
        }
        if (enrollment.getStatus() == null) {
            throw new BusinessException("Enrollment status cannot be null");
        }
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment cancel(Long id) {
        Enrollment enrollment = findById(id);
        if (enrollment.getStatus() != EnrollmentStatus.ACTIVE) {
            throw new BusinessException("Only ACTIVE enrollments can be cancelled");
        }
        enrollment.setStatus(EnrollmentStatus.CANCELLED);
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public void deleteById(Long id) {
        if (!enrollmentRepository.existsById(id)) {
            throw new EnrollmentNotFoundException("Enrollment with id " + id + " not found");
        }
        enrollmentRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return enrollmentRepository.existsById(id);
    }

    private void validate(Enrollment enrollment) {
        if (enrollment.getStudentId() == null) {
            throw new BusinessException("Enrollment student id cannot be null");
        }
        if (enrollment.getCourseId() == null) {
            throw new BusinessException("Enrollment course id cannot be null");
        }
    }
}
