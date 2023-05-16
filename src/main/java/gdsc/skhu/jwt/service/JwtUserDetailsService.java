package gdsc.skhu.jwt.service;

import gdsc.skhu.jwt.domain.Teacher;
import gdsc.skhu.jwt.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private final TeacherRepository teacherRepository;
    private final PasswordEncoder passwordEncoder;

    // USer 찾아서 UserDeails 객체 형식으로 return
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return teacherRepository.findByEmail(username)
                .map(this::createUserDetails)
                .orElseThrow(()->new UsernameNotFoundException("해당 ID를 찾을 수 없습니다."));
    }

    // UserDetails 생성
    private UserDetails createUserDetails(Teacher teacher){
        return User.builder()
                .username(teacher.getUsername())
                .password(teacher.getPassword())
                .roles(teacher.getRoles().toArray(new String[0]))
                .build();
    }
}
