package paramConfig;

 

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

 
public class ExampleServlet extends HttpServlet {
    private String admin;
    private String url;
    
    
 

    @Override
    public void init(ServletConfig config) throws ServletException {
        

        // init-param 가져오기
        admin = config.getInitParameter("admin");

        // context-param 가져오기
        ServletContext context = config.getServletContext();
        url = context.getInitParameter("url");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1> web.xml  parm !!!</h1>");
        response.getWriter().println("<p>Init Param 어드민: " + admin + "</p>");
        response.getWriter().println("<p>Context Param: " + url + "</p>");
        response.getWriter().println("</body></html>");
    }
}
