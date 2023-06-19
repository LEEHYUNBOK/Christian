package gdsc.skhu.jwt.domain;

import gdsc.skhu.jwt.domain.DTO.ClassTypeDTO;
import gdsc.skhu.jwt.domain.DTO.TeacherDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ClassType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(targetEntity = Teacher.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "classType", fetch = FetchType.LAZY,cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Student> students =new ArrayList<>();

    public static ClassTypeDTO ToDTO(ClassType classType) {
        return ClassTypeDTO.builder()
                .name(classType.getName())
                .students(
                        classType.getStudents().stream()
                                .map(Student::ToDTO)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
