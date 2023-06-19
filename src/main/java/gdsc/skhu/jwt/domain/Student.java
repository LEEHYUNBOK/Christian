package gdsc.skhu.jwt.domain;

import gdsc.skhu.jwt.domain.DTO.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String photo;

    @Column(nullable = false)
    private String age;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = true)
    private String memo;

    @ManyToOne(targetEntity = ClassType.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "classId")
    private ClassType classType;

    public static StudentDTO ToDTO(Student student) {
        return StudentDTO.builder()
                .id(student.id)
                .name(student.name)
                .age(student.age)
                .memo(student.memo)
                .photo(student.photo)
                .sex(student.photo)
                .build();
    }
}
