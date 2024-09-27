package loginProj;

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
		req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		MemberService service = new MemberService();		
		boolean check = service.verifyMember(id, pwd);
		
		if(check) {
			HttpSession session = req.getSession();
			Member member = service.getMember(id);
			session.setAttribute("loginMember", member);
			
			System.out.println("로그인 성공");
			
			resp.sendRedirect("/loginProj/main");
			
		} else {
			req.setAttribute("fail", "로그인 실패");
			req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
			
		}
		
	}
}
