//package mk.ukim.finki.wp.lab.web.servlet;
//
//
//import mk.ukim.finki.wp.lab.model.Course;
//import mk.ukim.finki.wp.lab.service.CourseService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name = "list-courses", urlPatterns = "/listCourses")
//public class CoursesServlet extends HttpServlet {
//
//    private final CourseService courseService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public CoursesServlet(CourseService courseService, SpringTemplateEngine springTemplateEngine){
//        this.courseService = courseService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        WebContext context = new WebContext(req,resp, req.getServletContext());
//        List<Course> cours = this.courseService.listAll();
//        context.setVariable("coursesList",cours);
//
//        this.springTemplateEngine.process("listCourses.html",context,resp.getWriter());
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String courseId = request.getParameter("courseId");
//        request.getSession().setAttribute("courseSelected",courseId);
//        response.sendRedirect(request.getContextPath() + "/AddStudent");
//    }
//}
