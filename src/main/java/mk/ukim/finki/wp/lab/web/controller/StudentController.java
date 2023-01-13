package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/createStudent")
    public String getStudentForm(){
        return "addStudent";
    }

    @PostMapping("/createStudent")
    public String addStudent(@RequestParam String username,
                             @RequestParam String password,
                             @RequestParam String name,
                             @RequestParam String surname,
                             @SessionAttribute String courseId,
                             Model model){
        model.addAttribute("courseId", courseId);

        studentService.save(username,password,name,surname);
        model.addAttribute("students", studentService.listAll());
        return "listStudents";
    }
}
