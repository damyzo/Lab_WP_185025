package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.service.CourseService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "student-enrollment-summary", urlPatterns = "/StudentEnrollmentSummary")
public class StudentEnrollmentSummaryServlet extends HttpServlet {
    private final CourseService courseService;
    private final SpringTemplateEngine templateEngine;

    public StudentEnrollmentSummaryServlet(CourseService courseService, SpringTemplateEngine templateEngine) {
        this.courseService = courseService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp, req.getServletContext());
        Object param = req.getSession().getAttribute("courseSelected");
        Object courseName = req.getSession().getAttribute("courseName");
        context.setVariable("courseName", courseName.toString());
        List<Student> studentList = courseService.listStudentsByCourse(Long.valueOf(param.toString()));
        context.setVariable("stu",studentList);
        templateEngine.process("studentsInCourse.html",context,resp.getWriter());

    }
}
