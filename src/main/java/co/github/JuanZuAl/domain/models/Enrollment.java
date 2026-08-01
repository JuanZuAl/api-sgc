package co.github.JuanZuAl.domain.models;

import java.time.LocalDate;

public class Enrollment {
    private Long id;
    private Long studentId;
    private Long courseId;
    private LocalDate EnrollmentDate;
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
