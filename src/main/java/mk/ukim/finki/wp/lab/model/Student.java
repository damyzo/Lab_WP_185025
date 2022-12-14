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
public class Student {
    @Id
    private String username;
    private String password;
    private String name;
    private String surname;

    @ManyToMany(mappedBy = "students",fetch = FetchType.EAGER)
    private List<Course> courseList;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Grade> grades;

    public Student(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return username != null && Objects.equals(username, student.username);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
