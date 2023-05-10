package gdsc.skhu.jwt.domain.DTO;

import lombok.Data;

@Data
public class LoginDTO {
    private String loginId;
    private String password;
}
