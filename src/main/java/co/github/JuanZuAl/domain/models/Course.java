package co.github.JuanZuAl.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * Representa un curso disponible en el sistema.
 */
@Entity
@Table(name = "courses")
public class Course {
    @Id
    private Long courseId;
    /** Código del curso. */
    @Column(name = "code", nullable = false)
    @NotEmpty(message = "El código del curso no puede estar vacío")
    private String code;
    /** Nombre del curso. */
    @Column(name = "name", nullable = false)
    @NotEmpty(message = "El nombre del curso no puede estar vacío")
    private String name;
    /** Descripción del curso. */
    @Column(name = "description", nullable = false)
    @NotEmpty(message = "La descripción del curso no puede estar vacía")
    private String description;
    /** Capacidad máxima del curso. */
    @Column(name = "max_capacity", nullable = false)
    @NotNull(message = "La capacidad máxima del curso no puede estar vacía")
    private Integer maxCapacity;

    public Course(Long courseId, String code, String name, String description, Integer maxCapacity) {
        this.courseId = courseId;
        this.code = code;
        this.name = name;
        this.description = description;
        this.maxCapacity = maxCapacity;
    }

    public Course() {
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
    @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", code=" + code + ", name=" + name + ", description=" + description + ", maxCapacity=" + maxCapacity + "]";
    }

}
