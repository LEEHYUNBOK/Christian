package gdsc.skhu.jwt.controller;

import gdsc.skhu.jwt.domain.DTO.StudentDTO;
import gdsc.skhu.jwt.service.ImageService;
import gdsc.skhu.jwt.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final ImageService imageService;

    @PostMapping("/student/{classId}/save")
    public String studentSave(
            @ModelAttribute StudentDTO studentDTO,
            @PathVariable Long classId,
            @ModelAttribute MultipartFile image
    ) {
        System.out.println(studentDTO.toString());
        studentService.save(classId,studentDTO, image);
        return "Success";
    }

    @DeleteMapping("/student/delete")
    public String studentDelete(@RequestParam Long studentId) {
        studentService.delete(studentId);
        return "Success";
    }
}
