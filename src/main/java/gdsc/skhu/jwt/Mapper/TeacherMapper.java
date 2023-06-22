package gdsc.skhu.jwt.Mapper;

import gdsc.skhu.jwt.domain.DTO.TeacherDTO;
import gdsc.skhu.jwt.domain.Teacher;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    @BeforeMapping
    default void beforTest() {
        System.out.println("befor");
    }

    @AfterMapping
    default void afterTest() {
        System.out.println("after");
    }

    @Mapping(source = "teacher.classType.name", target = "className")
    @Mapping(target = "studentCount", expression = "java(teacher.getClassType().getStudents().size())")
    TeacherDTO teacherToDto(Teacher teacher);
}
