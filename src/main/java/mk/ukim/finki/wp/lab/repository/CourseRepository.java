package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {

    public List<Course> findAllCourses(){
        return DataHolder.courses;
    }

    public Course findById(Long courseId){
        return DataHolder.courses.stream().filter(c -> c.getCourseId().equals(courseId)).findFirst().orElse(null);
    }

    public List<Student> findAllStudentByCourse(Long courseId){
        Course course = DataHolder.courses.stream().filter(c -> c.getCourseId().equals(courseId)).toList().stream().findFirst().orElse(null);
        if(course!=null){
            return course.getStudents();
        }
        return new ArrayList<>();
    }

    public Course addStudentToCourse(Student student, Course course){

        if(DataHolder.courses.contains(course)){
            if(student!=null)
            {
                DataHolder.courses.get(DataHolder.courses.indexOf(course)).getStudents().add(student);
            }
            return course;
        }
       return null;
    }


}
