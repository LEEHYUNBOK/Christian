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

    @PostMapping("/student/{id}/save")
    public String studentSave(
            @ModelAttribute StudentDTO studentDTO,
            @PathVariable Long id,
            @ModelAttribute MultipartFile image
    ) {
        imageService.insertImage(image,"I`m batman", "Student");
        studentService.save(id,studentDTO, image);
        return "Success";
    }

    @DeleteMapping("/student/delete")
    public String studentDelete(@RequestParam Long studentId) {
        studentService.delete(studentId);
        return "Success";
    }
}
