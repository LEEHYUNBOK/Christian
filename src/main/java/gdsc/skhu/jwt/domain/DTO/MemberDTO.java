package gdsc.skhu.jwt.domain.DTO;

import gdsc.skhu.jwt.domain.ClassType;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@Builder
public class MemberDTO {

    private String memberId;

    private String name;

    private List<ClassTypeDTO> classTypes;
}
