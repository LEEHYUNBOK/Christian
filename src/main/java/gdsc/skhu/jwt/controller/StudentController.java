package gdsc.skhu.jwt.controller;

import gdsc.skhu.jwt.domain.DTO.StudentDTO;
import gdsc.skhu.jwt.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/student/{id}/save")
    public String studentSave(@RequestBody StudentDTO studentDTO, @PathVariable Long id) {
        studentService.save(id,studentDTO);
        return "Success";
    }

    @DeleteMapping("/student/delete")
    public String studentDelete(@RequestParam Long studentId) {
        studentService.delete(studentId);
        return "Success";
    }
}
