package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {


    public static List<Course> courses = new ArrayList<>();
    public static List<Student> studentList = new ArrayList<>();


    @PostConstruct
    public void init(){
        studentList.add(new Student("student1","password1","Student","First"));
        studentList.add(new Student("student2","password2","Student","Second"));
        studentList.add(new Student("student3","password3","Student","Third"));
        studentList.add(new Student("student4","password4","Student","Fourth"));
        studentList.add(new Student("student5","password5","Student","Fifth"));

        courses.add(new Course(0L,"Web Programming","Web Programming desc",new ArrayList<>()));
        courses.add(new Course(1L,"Data Science","Dataaaa!",new ArrayList<>()));
        courses.add(new Course(2L,"Web Design","UX/UI",new ArrayList<>()));
        courses.add(new Course(3L,"Mobile Development","Mobile games!",new ArrayList<>()));
        courses.add(new Course(4L,"Calculus","Math is fun :D",new ArrayList<>()));

    }
}
