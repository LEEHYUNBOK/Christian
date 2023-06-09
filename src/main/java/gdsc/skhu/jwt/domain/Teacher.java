package gdsc.skhu.jwt.domain;

import gdsc.skhu.jwt.domain.DTO.TeacherDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

// UserDetails 구현
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Teacher implements UserDetails {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(updatable = false, unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "teacher", fetch = FetchType.LAZY,cascade = CascadeType.PERSIST, orphanRemoval = true)
    private ClassType classType;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public static TeacherDTO ToDTO(Teacher teacher) {
        return TeacherDTO.builder()
                .email(teacher.getEmail())
                .name(teacher.getName())
                .className(teacher.getClassType().getName())
                .studentCount(teacher.getClassType().getStudents().size())
                .build();
    }

    public void update(TeacherDTO teacher) {
        this.email = teacher.getEmail();
        this.name = teacher.getName();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    // 참고 https://zgundam.tistory.com/49

    // 계정 만료 여부, defalt true
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정 잠김 여부, defalt true
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 계정 패스워드 만료 여부, defalt true
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정 사용 여부, defalt true
    @Override
    public boolean isEnabled() {
        return true;
    }
}