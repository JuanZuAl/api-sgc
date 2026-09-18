package co.github.JuanZuAl.services.impl;

import co.github.JuanZuAl.application.exceptions.EnrollmentAlreadyExistsException;
import co.github.JuanZuAl.application.exceptions.EnrollmentConflictException;
import co.github.JuanZuAl.application.exceptions.EnrollmentNotFoundException;
import co.github.JuanZuAl.domain.models.Course;
import co.github.JuanZuAl.domain.models.Enrollment;
import co.github.JuanZuAl.domain.models.EnrollmentStatus;
import co.github.JuanZuAl.dto.CreateEnrollmentDto;
import co.github.JuanZuAl.dto.UpdateEnrollmentDto;
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
    public Enrollment create(CreateEnrollmentDto enrollment) {
        if (enrollmentRepository.existsById(enrollment.enrollmentId())) {
            throw new EnrollmentAlreadyExistsException("Enrollment with id " + enrollment.enrollmentId() + " already exists");
        }

        // El estudiante y el curso deben existir
        studentService.findById(enrollment.studentId());
        Course course = courseService.findById(enrollment.courseId());

        if (enrollmentRepository.existsByStudentIdAndCourseId(enrollment.studentId(), enrollment.courseId())) {
            throw new EnrollmentAlreadyExistsException("Student " + enrollment.studentId()
                    + " is already enrolled in course " + enrollment.courseId());
        }
        if (enrollmentRepository.countByCourseId(course.getCourseId()) >= course.getMaxCapacity()) {
            throw new EnrollmentConflictException("Course " + course.getCourseId() + " has reached its max capacity");
        }

        Enrollment newEnrollment = new Enrollment(
                enrollment.enrollmentId(),
                enrollment.studentId(),
                enrollment.courseId(),
                enrollment.enrollmentDate() != null ? enrollment.enrollmentDate() : LocalDate.now(),
                enrollment.status() != null ? enrollment.status() : EnrollmentStatus.ACTIVE
        );
        return enrollmentRepository.save(newEnrollment);
    }

    @Override
    public Enrollment update(Long enrollmentId, UpdateEnrollmentDto enrollment) {
        Enrollment existing = findById(enrollmentId);
        studentService.findById(enrollment.studentId());
        courseService.findById(enrollment.courseId());

        // Si cambia el par estudiante/curso, no puede chocar con otra inscripción existente
        boolean pairChanged = !existing.getStudentId().equals(enrollment.studentId())
                || !existing.getCourseId().equals(enrollment.courseId());
        if (pairChanged && enrollmentRepository.existsByStudentIdAndCourseId(enrollment.studentId(), enrollment.courseId())) {
            throw new EnrollmentAlreadyExistsException("Student " + enrollment.studentId()
                    + " is already enrolled in course " + enrollment.courseId());
        }

        Enrollment updatedEnrollment = new Enrollment(
                enrollmentId,
                enrollment.studentId(),
                enrollment.courseId(),
                enrollment.enrollmentDate(),
                enrollment.status()
        );
        return enrollmentRepository.save(updatedEnrollment);
    }

    @Override
    public Enrollment cancel(Long id) {
        Enrollment enrollment = findById(id);
        if (enrollment.getStatus() != EnrollmentStatus.ACTIVE) {
            throw new EnrollmentConflictException("Only ACTIVE enrollments can be cancelled");
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
}
