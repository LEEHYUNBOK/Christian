package gdsc.skhu.jwt.repository;

import gdsc.skhu.jwt.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
