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
public class TeacherDTO {

    private String email;

    private String name;

    private String className;

    private int studentCount;
}
