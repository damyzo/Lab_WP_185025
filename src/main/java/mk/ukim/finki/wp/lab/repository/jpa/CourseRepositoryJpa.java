package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepositoryJpa extends JpaRepository<Course, Long> {
    void deleteByCourseId(Long courseId);
    void deleteByName(String name);
}
