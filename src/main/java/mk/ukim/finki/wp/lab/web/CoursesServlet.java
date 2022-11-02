package mk.ukim.finki.wp.lab.web;


import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.service.CourseService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "list-courses", urlPatterns = "/listCourses")
public class CoursesServlet extends HttpServlet {

    private final CourseService courseService;
    private final SpringTemplateEngine springTemplateEngine;

    public CoursesServlet(CourseService courseService, SpringTemplateEngine springTemplateEngine)throws ServletException, IOException {
        this.courseService = courseService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp, req.getServletContext());
        List<Course> cours = this.courseService.listAll();
        context.setVariable("coursesList",cours);
        resp.setContentType("application/xhtml+xml");
        String val = req.getParameter("courseId");
        req.getSession().setAttribute("courseId", req.getParameter("courseId"));
        this.springTemplateEngine.process("listCourses.html",context,resp.getWriter());
    }

}
