package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.model.Type;

import java.util.List;

public interface CourseService {
    List<Course> listAll();
    List<Student> listStudentsByCourse(Long courseId);
    Course addStudentInCourse(String username, Long courseId);

    Course save(String name, String desc, Teacher teacher, String type);

    boolean deleteById(Long id);

    void sort();

    Course findById(Long id);
}
