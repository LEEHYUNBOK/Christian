package gdsc.skhu.jwt.domain.DTO;

import gdsc.skhu.jwt.domain.Member;
import lombok.Builder;
import lombok.Data;

import java.util.Collections;

@Data
@Builder
public class JoinDTO {
    private String name;
    private String password;
    private String id;

    public Member toEntity() {
        return Member.builder()
                .email(id)
                .password(password)
                .name(name)
                .roles(Collections.singletonList("USER"))
                .build();
    }
}
