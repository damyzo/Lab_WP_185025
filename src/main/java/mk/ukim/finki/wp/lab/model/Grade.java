package mk.ukim.finki.wp.lab.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Character grade;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    private LocalDateTime timestamp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Grade grade = (Grade) o;
        return id != null && Objects.equals(id, grade.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
