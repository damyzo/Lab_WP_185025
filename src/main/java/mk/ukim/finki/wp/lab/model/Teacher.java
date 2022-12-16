package mk.ukim.finki.wp.lab.model;

import lombok.*;
import org.hibernate.Hibernate;

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
    private String name;
    private String surname;

    private LocalDate dateOfEmployment;

    @OneToMany(mappedBy = "teacher")
    @ToString.Exclude
    private List<Course> courseList;

    public Teacher(String name, String surname, LocalDate dateOfEmployment) {
        this.name = name;
        this.surname = surname;
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
