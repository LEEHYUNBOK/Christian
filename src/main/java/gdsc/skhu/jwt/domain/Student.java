package gdsc.skhu.jwt.domain;

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
    @Id
    @Column(updatable = false, unique = true, nullable = false)
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
}
