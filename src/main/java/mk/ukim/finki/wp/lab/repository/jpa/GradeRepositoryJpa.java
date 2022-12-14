package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Grade;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GradeRepositoryJpa extends JpaRepository<Grade, Long> {
    List<Grade> findAllByCourse(Course course);
    Grade findByCourseAndStudent(Course course, Student student);

    List<Grade> findAllByTimestampAfterAndTimestampBefore(LocalDateTime from, LocalDateTime to);
}
