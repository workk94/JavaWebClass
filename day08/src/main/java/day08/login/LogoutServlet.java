package day08.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutex")
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//세션 지우기
		
		//세션 저장소 얻어오기
		HttpSession session = req.getSession();
		
		//저장소에 있는거 전부삭제
		session.invalidate();
		
		//
		System.out.println("로그아웃");
		//메인페이지로 리다이렉트(웹 브라우저에게 재요청 하세요!! 라는 의미)
		resp.sendRedirect("/day08/mainex");
	}
}
