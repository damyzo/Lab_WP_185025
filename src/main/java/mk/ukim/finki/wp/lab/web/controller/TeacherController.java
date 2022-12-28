package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teacherForm")
    String getTeacherForm(){
        return "add-teacher";
    }

    @PostMapping("/addTeacher")
    String addTeacher(@RequestParam String teacherName,
                      @RequestParam String teacherSurname,
                      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        teacherService.save(teacherName,teacherSurname,date);
        return "redirect:listCourses";

    }
}
