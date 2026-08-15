package co.github.JuanZuAl.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

/**
 * Representa a un estudiante en el sistema.
 */
@Entity
@Table(name = "students")
public class Student {
    @Id
    private long  id;
    /** Nombre del estudiante. */
    @Column(name = "first_name", nullable = false)
    @NotEmpty(message = "El nombre no puede estar vacío")
    private String firstName;
    /** Apellido del estudiante. */
    @Column(name = "last_name", nullable = false)
    @NotEmpty(message = "El apellido no puede estar vacío")
    private String lastName;
    /** Correo electrónico del estudiante. */
    @Column(name = "email", nullable = false)
    @NotEmpty(message = "El correo electrónico no puede estar vacío")
    @Email(message = "El correo electrónico debe tener un formato válido")
    private String email;
    /** Fecha de nacimiento del estudiante. */
    @Column(name = "birth_date", nullable = false)
    @NotEmpty(message = "La fecha de nacimiento no puede estar vacía")
    private LocalDate birthDate;
    public Student(long id, String firstName, String lastName   , String email, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Student() {
    }

    public long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName  + ", email=" + email + ", birthDate=" + birthDate + "]";
    }
}