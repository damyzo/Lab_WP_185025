package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.*;
import mk.ukim.finki.wp.lab.model.exception.CourseNameDescriptionAndTeacherNeededException;
import mk.ukim.finki.wp.lab.model.exception.CourseNotFoundException;
import mk.ukim.finki.wp.lab.model.exception.StudentNotFoundException;
import mk.ukim.finki.wp.lab.repository.jpa.CourseRepositoryJpa;
import mk.ukim.finki.wp.lab.repository.jpa.GradeRepositoryJpa;
import mk.ukim.finki.wp.lab.repository.jpa.StudentRepositoryJpa;
import mk.ukim.finki.wp.lab.service.CourseService;


import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CoursesServiceImpl implements CourseService {
    private final CourseRepositoryJpa courseRepository;
    private final StudentRepositoryJpa studentRepository;

    private final GradeRepositoryJpa gradeRepositoryJpa;

    public CoursesServiceImpl(CourseRepositoryJpa courseRepository, StudentRepositoryJpa studentRepository, GradeRepositoryJpa gradeRepositoryJpa) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.gradeRepositoryJpa = gradeRepositoryJpa;
    }


    @Override
    public List<Course> listAll() {
        return courseRepository.findAll();
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        Optional<Course> course = courseRepository.findById(courseId);
        if(course.isEmpty())
        {
            throw new CourseNotFoundException(courseId);
        }
        return course.get().getStudents();
    }

    @Override
    @Transactional
    public Course addStudentInCourse(String username, Long courseId) {

        Optional<Course> course = courseRepository.findById(courseId);
        Optional<Student> student = studentRepository.findById(username);
        if(course.isEmpty())
        {
            throw new CourseNotFoundException(courseId);
        }
        if(student.isEmpty()){
            throw new StudentNotFoundException(username);
        }
        if(!course.get().getStudents().contains(student.get()))
        {
            course.get().getStudents().add(student.get());
            gradeRepositoryJpa.save(new Grade(null,student.get(),course.get(),null));
        }

        return course.get();
    }

    @Override
    @Transactional
    public Course save(String name, String desc, Teacher teacher, String type) {

        if(name != null && !name.isEmpty()
                && desc != null && !desc.isEmpty()
                && type!= null && !type.isEmpty())
        {
            courseRepository.deleteByName(name);
            return courseRepository.save(new Course(name,desc,new ArrayList<>(),teacher,Type.valueOf(type)));
        }
        throw new CourseNameDescriptionAndTeacherNeededException();
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        if(courseRepository.findById(id).isPresent())
        {
            courseRepository.deleteByCourseId(id);
            return true;
        }

        return false;
    }

    @Override
    public void sort() {
        courseRepository.findAll().sort(Comparator.comparing(Course::getName));
    }

    @Override
    public Course findById(Long id) {
        if(courseRepository.findById(id).isPresent())
        {
            return courseRepository.findById(id).get();
        }
        throw new CourseNotFoundException(id);
    }
}
