package co.github.JuanZuAl.repository;

import co.github.JuanZuAl.domain.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByEmail(String email);
    Optional<Student> findByFirstName(String firstName);
}
