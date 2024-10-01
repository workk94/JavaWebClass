package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		
		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
				
	} 
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		 String id  =request.getParameter("id");
		 String pw = request.getParameter("pw");
		 
		 
		 if( id.equals(pw)) {
			 //로그인성공
			 //로그인 상태 저장 ( session)
			 HttpSession session = request.getSession();
			 session.setAttribute("id", id);
			 
			 response.sendRedirect("/EL_JSTLSample/home");
			 
		 }else {			 
			 //로그인 실패
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
				
		 }
		 
		
		
	}
	

}
