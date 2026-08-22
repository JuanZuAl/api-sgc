package co.github.JuanZuAl.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * Representa la inscripción de un estudiante en un curso.
 */
@Entity
@Table(name = "enrollments")
public class Enrollment {
    @Id
    private Long id;
    /** Identificador del estudiante asociado a esta inscripción. */
    @Column(name = "student_id", nullable = false)
    @NotNull(message = "El ID del estudiante no puede estar vacío")
    private Long studentId;
    /** Identificador del curso asociado a esta inscripción. */
    @Column(name = "course_id", nullable = false)
    @NotNull(message = "El ID del curso no puede estar vacío")
    private Long courseId;
    /** Fecha en que se creó la inscripción. */
    @Column(name = "enrollment_date", nullable = false)
    @NotNull(message = "La fecha de inscripción no puede estar vacía")
    private LocalDate EnrollmentDate;
    /** Estado actual de la inscripción. */
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "El estado de la inscripción no puede estar vacío")
    private EnrollmentStatus status;

    public Enrollment(Long id, Long studentId, Long courseId, LocalDate enrollmentDate, EnrollmentStatus status) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        EnrollmentDate = enrollmentDate;
        this.status = status;
    }

    public Enrollment() {
    }

    public Long getId() {
        return id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public LocalDate getEnrollmentDate() {
        return EnrollmentDate;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        EnrollmentDate = enrollmentDate;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Enrollment [id=" + id + ", studentId=" + studentId + ", courseId=" + courseId + ", EnrollmentDate="
                + EnrollmentDate + ", status=" + status + "]";
    }
}
