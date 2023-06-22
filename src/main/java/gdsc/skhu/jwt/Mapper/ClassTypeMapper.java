package gdsc.skhu.jwt.Mapper;

import gdsc.skhu.jwt.domain.ClassType;
import gdsc.skhu.jwt.domain.DTO.ClassTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassTypeMapper {
    ClassTypeMapper INSTANCE = Mappers.getMapper(ClassTypeMapper.class);
    ClassType dtoToclassType(ClassTypeDTO classTypeDTO);

    ClassTypeDTO classTypeToDTO(ClassType classType);

    List<ClassTypeDTO> listClassTypeToDTO(List<ClassType> classTypes);
}
