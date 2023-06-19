package gdsc.skhu.jwt.service;

import gdsc.skhu.jwt.domain.ClassType;
import gdsc.skhu.jwt.domain.DTO.StudentDTO;
import gdsc.skhu.jwt.domain.Student;
import gdsc.skhu.jwt.repository.ClassTypeRepository;
import gdsc.skhu.jwt.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ClassTypeRepository classTypeRepository;
    public void save(Long classId, StudentDTO studentDTO){
        ClassType classType = classTypeRepository.findById(classId)
                .orElseThrow(()->new UsernameNotFoundException("해당 수업을 찾을 수 없습니다."));
        studentRepository.save(
                Student.builder()
                        .age(studentDTO.getAge())
                        .sex(studentDTO.getSex())
                        .name(studentDTO.getName())
                        .memo(studentDTO.getMemo())
                        .photo(studentDTO.getPhoto())
                        .classType(classType)
                        .build()
        );
    }
}
