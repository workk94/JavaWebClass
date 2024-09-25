package day05;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//회원 전체정보 제공 서비스

@WebServlet("/acornList")
public class AcornList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		
		//
		AcornService service = new AcornService();
		ArrayList<Acorn> list = service.getMemberList();
		
		//저장소(request)
		//응답이 완료되면 사라짐 
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/acornlist.jsp").forward(req, resp);
	}
}
