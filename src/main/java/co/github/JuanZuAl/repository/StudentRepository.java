package co.github.JuanZuAl.repository;

import co.github.JuanZuAl.domain.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findById(Long id);
    void deleteById(Long id);
    boolean existsByEmail(String email);
    boolean existsById(Long id);
}
