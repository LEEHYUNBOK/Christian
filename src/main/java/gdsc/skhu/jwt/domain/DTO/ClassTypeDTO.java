package gdsc.skhu.jwt.domain.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@Builder
public class ClassTypeDTO {
    private Long id;
    private String name;
    private TeacherDTO teacher;
    private List<StudentDTO> students;
}
