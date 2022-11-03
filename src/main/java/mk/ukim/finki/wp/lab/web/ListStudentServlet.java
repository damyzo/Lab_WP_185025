package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.StudentService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "list-students", urlPatterns = "/AddStudent")
public class ListStudentServlet extends HttpServlet {
    private final CourseService courseService;
    private final StudentService studentService;
    private final SpringTemplateEngine templateEngine;

    public ListStudentServlet(CourseService courseService, StudentService studentService, SpringTemplateEngine templateEngine) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.templateEngine = templateEngine;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp,req.getServletContext());

        context.setVariable("students",studentService.listAll());
        Object studentId = req.getSession().getAttribute("courseSelected");
        context.setVariable("courseId", studentId);
        templateEngine.process("listStudents.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("size");
        Object id = req.getSession().getAttribute("courseSelected");
        String courseName = courseService.addStudentInCourse(username, Long.valueOf((id.toString()))).getName();
        req.getSession().setAttribute("courseName", courseName);
        resp.sendRedirect("/StudentEnrollmentSummary");
    }
}
