package exceptiontest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/regcustomer")
public class RegCustomer  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		
		
		//오류발생
		AcornDAO dao= new AcornDAO();
		dao.insert();
		
		
		resp.getWriter().println("ok");
	}

}
