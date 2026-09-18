package co.github.JuanZuAl.dto.response;

import co.github.JuanZuAl.domain.models.Student;

public record StudentResponseDto(
        long studentId,
        String firstName,
        String lastName,
        String email,
        String phoneNumber
) {

    public static StudentResponseDto from (Student student) {
        return new StudentResponseDto(
                student.getStudentId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getPhoneNumber()
        );
    }
}
