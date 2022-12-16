package mk.ukim.finki.wp.lab.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


@WebFilter(filterName = "CourseSelectionCheck", urlPatterns = "/*")
public class CourseSelectionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig){
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Object selection = request.getSession().getAttribute("courseSelected");
        String path = request.getServletPath();

        if( !path.equals("/courses")
                && !path.equals("/listCourses")
                && !path.matches("/courses/listStudents/[0-9]*")
                && !path.matches("/courses/delete/[0-9]*")
                && !path.equals("/courses/add-form")
                && !path.equals("/courses/add")
                && !path.matches("/courses/*")
                && !path.matches("/courses/edit-form/[0-9]*")
                && !path.matches("/h2")
                && !path.matches("/h2/*")
                && selection == null
                ){
            response.sendRedirect("/courses");
        }else {
            if(path.equals("/listCourses") && Objects.equals(request.getMethod(), "GET"))
            {
                response.sendRedirect("/courses");
            }
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
