package gdsc.skhu.jwt.domain.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class StudentDTO {
    private String name;
    private String photo;
    private String age;
    private String sex;
    private String memo;
}
