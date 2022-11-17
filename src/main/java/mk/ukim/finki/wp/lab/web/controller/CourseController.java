package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private final TeacherService teacherService;
    private final CourseService courseService;

    public CourseController(TeacherService teacherService, CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
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
        return "add-course";
    }
    @GetMapping("/add-form")
    public String getAddCoursePage(Model model){
        model.addAttribute("teachers", teacherService.findAll());
        return "add-course";
    }

    @PostMapping("/add")
    public String saveCourse(@RequestParam String courseName, @RequestParam String courseDesc, @RequestParam Long teacherId){
        courseService.save(courseName,courseDesc,teacherService.findById(teacherId));
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




}
