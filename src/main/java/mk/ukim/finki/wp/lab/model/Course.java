package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class Course {
    private Long courseId;
    String name;
    String description;
    List<Student> students;

    Teacher teacher;

    public Course(String name, String description, List<Student> students, Teacher teacher) {
        this.courseId = (long) (Math.random() * 1000);
        this.name = name;
        this.description = description;
        this.students = students;
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId);
    }
}
