package mytest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("id");
		String userpw = req.getParameter("pw");
		
		System.out.println(userid);
		System.out.println(userpw);
		
		boolean result = false;
		
		if(userid.equals(userpw)) result = true;
		
		
		if(result) {
			//HttpSession 객체 생성 후 userid를 담는다
			HttpSession session = req.getSession();
			session.setAttribute("userid", userid);
			
			//로그인 성공하면 main 페이지로 이동
			System.out.println("로그인 성공");
			resp.sendRedirect("/mytest/main");
		} else {
			//로그인 실패 
			System.out.println("로그인 실패");
			
			req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
		}
		

		
	}
}
