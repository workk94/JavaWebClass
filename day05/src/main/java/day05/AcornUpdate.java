package day05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//회원정보 변경하기 서비스 => 서블릿, (서비스, DAO) => Model, view

@WebServlet("/update")
public class AcornUpdate extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//얻어오기 
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		
		Acorn acorn = new Acorn(id, pw, name);
		AcornService service = new AcornService();
		
		service.modifyMember(acorn);
		
		req.getRequestDispatcher("WEB-INF/views/updateok.jsp").forward(req, resp);
	}
}
