package co.github.JuanZuAl.domain.models;

/**
 * Representa un curso disponible en el sistema.
 */
public class Course {
    private Long id;
    /** Código del curso. */
    private String code;
    /** Nombre del curso. */
    private String name;
    /** Descripción del curso. */
    private String description;
    /** Capacidad máxima del curso. */
    private Integer maxCapacity;

    public Course(Long id, String code, String name, String description, Integer maxCapacity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.maxCapacity = maxCapacity;
    }

    public Course() {
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
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
        return "Course [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + ", maxCapacity=" + maxCapacity + "]";
    }

}
