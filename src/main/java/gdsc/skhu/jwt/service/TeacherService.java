package gdsc.skhu.jwt.service;

import gdsc.skhu.jwt.domain.DTO.JoinDTO;
import gdsc.skhu.jwt.domain.DTO.TeacherDTO;
import gdsc.skhu.jwt.domain.DTO.TokenDTO;
import gdsc.skhu.jwt.domain.Teacher;
import gdsc.skhu.jwt.jwt.TokenProvider;
import gdsc.skhu.jwt.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public TokenDTO login(String loginId, String password) {
        // 1. ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 객체는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginId, password);

        // 2. 실제 검증(사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 JwtUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증된 정보를 기반으로 JWT 토큰 생성
        TokenDTO tokenDTO = tokenProvider.createToken(authentication);

        return tokenDTO;
    }

    @Transactional
    public void join(JoinDTO memberJoinDto) {
        if(teacherRepository.findByEmail(memberJoinDto.getId()).isPresent()) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }

        memberJoinDto.setPassword(passwordEncoder.encode(memberJoinDto.getPassword()));
        teacherRepository.save(memberJoinDto.toEntity());
    }

    @Transactional
    public TeacherDTO findEmail(String email){
        Teacher teacher = findByEmail(email);
        return teacher.ToDTO(teacher);
    }

    @Transactional
    public void updateTeacher(TeacherDTO updateTeacher){
        Teacher teacher = findByEmail(updateTeacher.getEmail());
        teacher.update(updateTeacher);
        teacherRepository.save(teacher);
    }

    @Transactional
    public Teacher findByEmail(String email) throws UsernameNotFoundException {
        return teacherRepository.findByEmail(email)
                .orElseThrow(() -> new NoSuchElementException(String.format("해당 유저(%s)를 찾을 수 없습니다.", email)));
    }

}
