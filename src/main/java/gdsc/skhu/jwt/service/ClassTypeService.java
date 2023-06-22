package gdsc.skhu.jwt.service;

import gdsc.skhu.jwt.Mapper.ClassTypeMapper;
import gdsc.skhu.jwt.domain.ClassType;
import gdsc.skhu.jwt.domain.DTO.ClassTypeDTO;
import gdsc.skhu.jwt.domain.Teacher;
import gdsc.skhu.jwt.repository.ClassTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ClassTypeService {
    private final ClassTypeRepository classTypeRepository;
    private final ClassTypeMapper classTypeMapper = ClassTypeMapper.INSTANCE;

    @Transactional
    public List<ClassTypeDTO> findAll(){
//        List<ClassType> classTypes = classTypeRepository.findAll();
//        return classTypes.stream()
//                .map(ClassType::ToDTO)
//                .collect(Collectors.toList());

        return classTypeMapper.listClassTypeToDTO(classTypeRepository.findAll());
    }

    @Transactional
    public void save(String className, Teacher teacher){
        classTypeRepository.save(
                ClassType.builder()
                        .name(className)
                        .teacher(teacher)
                        .build()
        );
    }

    @Transactional
    public ClassTypeDTO findById(Long id) {
        return classTypeMapper.classTypeToDTO(
                classTypeRepository.findById(id)
                        .orElseThrow(() -> new NoSuchElementException(String.format("해당 수업을 찾을 수 없습니다.")))
        );
    }

    @Transactional
    public void update(String name, ClassType classType){
        classType.update(name);
        classTypeRepository.save(classType);
    }
}
