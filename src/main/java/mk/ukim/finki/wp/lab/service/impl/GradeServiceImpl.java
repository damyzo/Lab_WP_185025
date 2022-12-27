package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Grade;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.exception.CourseNotFoundException;
import mk.ukim.finki.wp.lab.model.exception.GradeCannotBeAddedException;
import mk.ukim.finki.wp.lab.model.exception.GradeNotFoundException;
import mk.ukim.finki.wp.lab.repository.jpa.CourseRepositoryJpa;
import mk.ukim.finki.wp.lab.repository.jpa.GradeRepositoryJpa;
import mk.ukim.finki.wp.lab.service.GradeService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceImpl implements GradeService {

    private final GradeRepositoryJpa gradeRepositoryJpa;
    private final CourseRepositoryJpa courseRepositoryJpa;

    public GradeServiceImpl(GradeRepositoryJpa gradeRepositoryJpa, CourseRepositoryJpa courseRepositoryJpa) {
        this.gradeRepositoryJpa = gradeRepositoryJpa;
        this.courseRepositoryJpa = courseRepositoryJpa;
    }

    @Override
    public List<Grade> findAllByCourse(Course course) {
        return gradeRepositoryJpa.findAllByCourse(course);
    }

    @Override
    public Grade findByCourseAndStudent(Course course, Student student) {
        return gradeRepositoryJpa.findByCourseAndStudent(course,student);
    }

    @Override
    public Grade save(Long gradeId,String grade, Long courseId, Student student, LocalDateTime date) {
        if(grade != null && !grade.isEmpty() && courseId != null && student != null && date != null){
            gradeRepositoryJpa.deleteById(gradeId);
            if(courseRepositoryJpa.findById(courseId).isPresent())
            {
                return gradeRepositoryJpa.save(new Grade(grade.charAt(0),student,courseRepositoryJpa.findById(courseId).get(),date));
            }else{
                throw new CourseNotFoundException(courseId);
            }

        }else{
            throw new GradeCannotBeAddedException();
        }
    }

    @Override
    public Grade findById(Long id) {
        Optional<Grade> grade = gradeRepositoryJpa.findById(id);
        if(grade.isEmpty()){
            throw new GradeNotFoundException(id);
        }
        return grade.get();
    }
}
