package mk.ukim.finki.wp.lab.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String name;
    private String description;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Student> students;

    @ManyToOne
    private Teacher teacher;

    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Grade> grades;

    public Course(String name, String description, List<Student> students, Teacher teacher, Type type) {
        this.name = name;
        this.description = description;
        this.students = students;
        this.teacher = teacher;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Course course = (Course) o;
        return courseId != null && Objects.equals(courseId, course.courseId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
