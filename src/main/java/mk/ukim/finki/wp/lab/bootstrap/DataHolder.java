package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.model.Type;
import mk.ukim.finki.wp.lab.repository.jpa.TeacherRepositoryJpa;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {


    public static List<Course> courses = new ArrayList<>();
    public static List<Student> studentList = new ArrayList<>();

    public static List<Teacher> teachers = new ArrayList<>();

    private final TeacherRepositoryJpa teacherRepositoryJpa;

    public DataHolder(TeacherRepositoryJpa teacherRepositoryJpa) {
        this.teacherRepositoryJpa = teacherRepositoryJpa;
    }

    @PostConstruct
    public void init(){
//        studentList.add(new Student("student1","password1","Student","First"));
//        studentList.add(new Student("student2","password2","Student","Second"));
//        studentList.add(new Student("student3","password3","Student","Third"));
//        studentList.add(new Student("student4","password4","Student","Fourth"));
//        studentList.add(new Student("student5","password5","Student","Fifth"));
//
//        courses.add(new Course("Web Programming","Web Programming desc",new ArrayList<>(), null, Type.ELECTIVE));
//        courses.add(new Course("Data Science","Dataaaa!",new ArrayList<>(), null, Type.WINTER));
//        courses.add(new Course("Web Design","UX/UI",new ArrayList<>() , null, Type.MANDATORY));
//        courses.add(new Course("Mobile Development","Mobile games!",new ArrayList<>(), null,Type.SUMMER));
//        courses.add(new Course("Calculus","Math is fun :D",new ArrayList<>(), null, Type.MANDATORY));

    }
}
