package gdsc.skhu.jwt.Mapper;

import gdsc.skhu.jwt.domain.DTO.StudentDTO;
import gdsc.skhu.jwt.domain.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student DtoToStudent(StudentDTO studentDTO);

}
