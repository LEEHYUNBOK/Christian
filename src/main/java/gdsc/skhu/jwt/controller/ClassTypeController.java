package gdsc.skhu.jwt.controller;

import gdsc.skhu.jwt.domain.DTO.ClassTypeDTO;
import gdsc.skhu.jwt.service.ClassTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ClassTypeController {
    private final ClassTypeService classTypeService;

    @GetMapping("/class")
    public ResponseEntity<List<ClassTypeDTO>> findAll(){
        List<ClassTypeDTO> classTypes = classTypeService.findAll();
        return ResponseEntity.ok(classTypes);
    }
}
