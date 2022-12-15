package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.model.Type;
import mk.ukim.finki.wp.lab.model.exception.CourseNameDescriptionAndTeacherNeededException;
import mk.ukim.finki.wp.lab.model.exception.CourseNotFoundException;
import mk.ukim.finki.wp.lab.repository.CourseRepository;
import mk.ukim.finki.wp.lab.repository.StudentRepository;
import mk.ukim.finki.wp.lab.service.CourseService;


import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class CoursesServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CoursesServiceImpl(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Course> listAll() {
        return courseRepository.findAllCourses();
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return courseRepository.findAllStudentByCourse(courseId);
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        Student student = null;
        Course course = courseRepository.findById(courseId);
        for (Student student1: studentRepository.findAllStudents())
        {
            if (Objects.equals(student1.getUsername(), username))
            {
                student = student1;
                break;
            }
        }

        courseRepository.addStudentToCourse(student,course);
        return course;
    }

    @Override
    public Course save(String name, String desc, Teacher teacher, String type) {

        if(name != null && !name.isEmpty()
                && desc != null && !desc.isEmpty()
                && teacher != null
                && type!= null && !type.isEmpty())
        {
            return courseRepository.save(name,desc,teacher,Type.valueOf(type));
        }
        throw new CourseNameDescriptionAndTeacherNeededException();
    }

    @Override
    public boolean deleteById(Long id) {
        return courseRepository.deleteById(id);
    }

    @Override
    public void sort() {
        courseRepository.findAllCourses().sort(Comparator.comparing(Course::getName));
    }

    @Override
    public Course findById(Long id) {
        if(courseRepository.findById(id) != null)
        {
            return courseRepository.findById(id);

        }
        throw new CourseNotFoundException(id);
    }
}
