	package day05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//회원탈퇴 서비스

@WebServlet("/deleteAcorn")
public class AcornDelete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String id = req.getParameter("id");
		System.out.println(id);
		
		AcornService service = new AcornService();
		service.deleteMember(id);
		
		//req.getRequestDispatcher("WEB-INF/views/deleteok.jsp").forward(req, resp);
		
		
		//redirect (브라우저에게 자동으로 요청하라는 의미)
		resp.sendRedirect("/day05/acornList");
	}
}
