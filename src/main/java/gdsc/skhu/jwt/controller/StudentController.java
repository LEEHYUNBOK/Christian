package gdsc.skhu.jwt.controller;

import gdsc.skhu.jwt.domain.DTO.StudentDTO;
import gdsc.skhu.jwt.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/student/{id}/save")
    public String studentSave(@RequestBody StudentDTO studentDTO, @PathVariable Long id) {
        studentService.save(id,studentDTO);
        return "Success";
    }
}
