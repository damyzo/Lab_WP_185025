package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Grade;
import mk.ukim.finki.wp.lab.model.GradeEnum;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Type;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.GradeService;
import mk.ukim.finki.wp.lab.service.StudentService;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private final TeacherService teacherService;
    private final CourseService courseService;
    private final GradeService gradeService;

    private final StudentService studentService;


    public CourseController(TeacherService teacherService, CourseService courseService,
                            GradeService gradeService, StudentService studentService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
        this.gradeService = gradeService;
        this.studentService = studentService;
    }


    @GetMapping("")
    public String getCoursePage(@RequestParam(required = false) String error, Model model, HttpSession session){
        session.removeAttribute("courseSelected");

        if(error != null && !error.isEmpty())
        {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        courseService.sort();
        model.addAttribute("coursesList", courseService.listAll());

        return "listCourses";
    }
    @GetMapping("/edit-form/{id}")
    public String getEditCoursePage(@PathVariable Long id, Model model){
        model.addAttribute("course",courseService.findById(id));
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("types", Type.values());
        return "add-course";
    }
    @GetMapping("/add-form")
    public String getAddCoursePage(Model model){
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("types", Type.values());
        return "add-course";
    }

    @PostMapping("/add")
    public String saveCourse(@RequestParam String courseName, @RequestParam String courseDesc, @RequestParam Long teacherId,@RequestParam String type){
        courseService.save(courseName,courseDesc,teacherService.findById(teacherId),type);
        return "redirect:/courses/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id){
        if(courseService.deleteById(id))
        {
            return "redirect:/courses";
        }
        return "redirect:/courses?error=Invalid Id can't delete course";
    }

    @GetMapping("/listStudents/{courseId}")
    public String listAllStudent(@PathVariable Long courseId, Model model){
        model.addAttribute("stu", courseService.listStudentsByCourse(courseId));
        model.addAttribute("courseName",courseService.findById(courseId).getName());
        model.addAttribute("grades", gradeService.findAllByCourse(courseService.findById(courseId)));
        model.addAttribute("gradeValues", GradeEnum.values());
        return "listGrades";
    }

    @GetMapping("/addGrade")
    public String addGrade(@RequestParam Long grade, Model model)
    {

        model.addAttribute("grade", gradeService.findById(grade));
        model.addAttribute("gradeValues", GradeEnum.values());
        return "add-grade";
    }
    @PostMapping("/addedGrade")
    public String addedGrade(@RequestParam Long gradeId, @RequestParam String grade,@RequestParam Long courseId, @RequestParam String username, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime date)
    {
        gradeService.save(gradeId,grade,courseId,studentService.findByUsername(username),date);

        return "redirect:/courses";
    }




}
