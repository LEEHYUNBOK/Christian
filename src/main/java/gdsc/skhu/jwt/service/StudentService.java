package gdsc.skhu.jwt.service;

import gdsc.skhu.jwt.Mapper.StudentMapper;
import gdsc.skhu.jwt.domain.ClassType;
import gdsc.skhu.jwt.domain.DTO.StudentDTO;
import gdsc.skhu.jwt.domain.Student;
import gdsc.skhu.jwt.repository.ClassTypeRepository;
import gdsc.skhu.jwt.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ClassTypeRepository classTypeRepository;
    private StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);
    public void save(Long classId, StudentDTO studentDTO){
        ClassType classType = classTypeRepository.findById(classId)
                .orElseThrow(()->new UsernameNotFoundException("해당 수업을 찾을 수 없습니다."));
//        Student student = Student.builder()
//                .age(studentDTO.getAge())
//                .sex(studentDTO.getSex())
//                .name(studentDTO.getName())
//                .memo(studentDTO.getMemo())
//                .photo(studentDTO.getPhoto())
//                .classType(classType)
//                .build();
        Student student = studentMapper.DtoToStudent(studentDTO);
        student.addClass(classType);
        studentRepository.save(student);
    }

    public void delete(Long studnetId) {
        Student student = studentRepository.findById(studnetId)
                .orElseThrow(()->new UsernameNotFoundException("해당 수업을 찾을 수 없습니다."));

        studentRepository.delete(student);
    }
}
