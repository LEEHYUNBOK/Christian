package gdsc.skhu.jwt.repository;

import gdsc.skhu.jwt.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    // User이름을 찾을 수 있도록 하는 findByUsername
    Optional<Teacher> findByEmail(String username);
}