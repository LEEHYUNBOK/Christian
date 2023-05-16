package gdsc.skhu.jwt.controller;


import gdsc.skhu.jwt.domain.DTO.JoinDTO;
import gdsc.skhu.jwt.domain.DTO.LoginDTO;
import gdsc.skhu.jwt.domain.DTO.TokenDTO;
import gdsc.skhu.jwt.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    // /login 페이지 이동
    @PostMapping("/login")
    public TokenDTO login(@RequestBody LoginDTO memberLoginRequestDto) {
        String loginId = memberLoginRequestDto.getLoginId();
        String password = memberLoginRequestDto.getPassword();
        TokenDTO tokenDTO = teacherService.login(loginId, password);
        return tokenDTO;
    }
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody JoinDTO memberJoinDto) {
        teacherService.join(memberJoinDto);
        return ResponseEntity.ok("회원가입 성공");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> admin() {
        return ResponseEntity.ok("admin");
    }
}