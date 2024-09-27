package day08.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 로그인 서비스를 제공하는 서블릿
// get : 로그인 화면
// post : 실제 로그인 기능 제공 

@WebServlet("/loginex")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		System.out.println(id);
		System.out.println(pw);
		
		
		//LoginService service = new LoginService();
		//
		
		boolean result = false;
		
		if(id.equals(pw)) result = true;
		
		//회원이면(로그인 성공이면)
		//세션에 로그인 정보를 저장
		
		//if(result == true) {
		if(result) {
			HttpSession session = req.getSession();
			session.setAttribute("loginId", id);
			//메인페이지( 메인 서블릿을 호출할 수 있도록 resp.sendRedirect("/day08/main)
			System.out.println("로그인 성공, 메인페이지");
			
			//
			resp.sendRedirect("/day08/mainex");
		} else {
			
			System.out.println("로그인 실패, 로그인페이지");
			
			req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
		}
	}
}
