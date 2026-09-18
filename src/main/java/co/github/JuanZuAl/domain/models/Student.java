package co.github.JuanZuAl.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * Representa a un estudiante en el sistema.
 */
@Entity
@Table(name = "students")
public class Student {
    @Id
    private long  studentId;
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
    /** Número de teléfono del estudiante. */
    @Column(name = "phone_number", nullable = false)
    @NotNull(message = "El numero de celular no puede estar vacio")
    private String phoneNumber;

    public Student() {
    }
    public Student(long studentId, String firstName, String lastName, String email, String phoneNumber) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getStudentId() {
        return studentId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Student [id=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName  + ", email=" + email + ", celNumber=" + phoneNumber + "]";
    }


}