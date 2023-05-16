package gdsc.skhu.jwt.domain.DTO;

import gdsc.skhu.jwt.domain.Teacher;
import lombok.Builder;
import lombok.Data;

import java.util.Collections;

@Data
@Builder
public class JoinDTO {
    private String name;
    private String password;
    private String id;

    public Teacher toEntity() {
        return Teacher.builder()
                .email(id)
                .password(password)
                .name(name)
                .roles(Collections.singletonList("USER"))
                .build();
    }
}
