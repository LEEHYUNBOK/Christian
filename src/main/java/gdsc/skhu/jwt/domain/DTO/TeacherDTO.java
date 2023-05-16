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

    private String memberId;

    private String name;

    private List<ClassTypeDTO> classTypes;
}
