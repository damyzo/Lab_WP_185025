package mk.ukim.finki.wp.lab.model;

import lombok.*;
import mk.ukim.finki.wp.lab.model.converters.TeacherFullnameConverter;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = TeacherFullnameConverter.class)
    private TeacherFullname teacherFullname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfEmployment;

    @OneToMany(mappedBy = "teacher")
    @ToString.Exclude
    private List<Course> courseList;

    public Teacher(TeacherFullname teacherFullname, LocalDate dateOfEmployment) {
        this.teacherFullname = teacherFullname;
        this.dateOfEmployment = dateOfEmployment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Teacher teacher = (Teacher) o;
        return id != null && Objects.equals(id, teacher.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
