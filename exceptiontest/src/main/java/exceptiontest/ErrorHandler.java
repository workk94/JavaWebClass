package exceptiontest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
   
 <error-page>
    <error-code>500</error-code>
    <location>/errorHandle3</location>
</error-page>
  
 */
@WebServlet("/errorHandle3")
public class ErrorHandler  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		req.getRequestDispatcher("WEB-INF/views/err500.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doGet(req, resp);
	}
	
}
