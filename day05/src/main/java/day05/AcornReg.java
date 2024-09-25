package day05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿 -> 하나의 서비스 
//학생 등록 서비스 

//GET, POST, view, model - service, dao

@WebServlet("/acornReg")
public class AcornReg extends HttpServlet{
	
	
	// GET(등록화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//
		req.getRequestDispatcher("WEB-INF/views/reg.jsp").forward(req, resp);
	}
	
	
	//POST(등록작업-데이터베이스)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사용자 정보 얻어오기
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id"); // form 태그내에 있는 요소들의 이름 name이 설정되어 있어야 한다 
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		
		Acorn acorn = new Acorn(id, pw, name);
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		
		//등록 서비스 호출 
		
		AcornService service = new AcornService();
		int rtn = service.registerMember(acorn);
		
		//결과에 따라서 다른 view 보여줄수 있음 
		
		req.getRequestDispatcher("WEB-INF/views/ok.jsp").forward(req, resp);
	}
}
