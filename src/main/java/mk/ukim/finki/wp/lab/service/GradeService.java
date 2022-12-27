package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Grade;
import mk.ukim.finki.wp.lab.model.Student;

import java.time.LocalDateTime;
import java.util.List;

public interface GradeService {
    List<Grade> findAllByCourse(Course course);
    Grade findByCourseAndStudent(Course course, Student student);

    Grade save(Long gradeId, String grade, Long courseId, Student student, LocalDateTime date);
    Grade findById(Long id);
}
