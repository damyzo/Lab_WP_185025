//package mk.ukim.finki.wp.lab.web.servlet;
//
//import mk.ukim.finki.wp.lab.service.StudentService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(name = "create-student", urlPatterns = "/createStudent")
//public class CreateStudentServlet extends HttpServlet {
//    private final StudentService studentService;
//    private final SpringTemplateEngine templateEngine;
//
//
//    public CreateStudentServlet(StudentService studentService, SpringTemplateEngine templateEngine) {
//        this.studentService = studentService;
//        this.templateEngine = templateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        WebContext context = new WebContext(req,resp, req.getServletContext());
//        this.templateEngine.process("addStudent.html",context,resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        String name = req.getParameter("name");
//        String surname = req.getParameter("surname");
//        studentService.save(username,password,name,surname);
//        resp.sendRedirect("/AddStudent");
//    }
//}
