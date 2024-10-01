package day10;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pracEl1")
public class ELServlet1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// request : 서비스가 요청 ~ 응답되기까지 사용할 수 있는 저장소
		// session : 하나의 클라이언트가 사용할 수 있는 저장소
		
		req.setCharacterEncoding("utf-8");
		req.setAttribute("data", "EL은 좋아요");
		
		req.getRequestDispatcher("WEB-INF/views/el1.jsp").forward(req, resp);
	}
}
