package day03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿(controller)
//jsp(view)
//Model(에이콘 학생목록 - ArrayList<Acorn>)

@WebServlet("/acornList2")
public class MVC2맛보기학생조회 extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

		AcornDAO dao = new AcornDAO();
		ArrayList<Acorn> list  =dao.getAllAcorns();
		
		
		request.setAttribute("list", list);		
		request.getRequestDispatcher("WEB-INF/views/list.jsp").forward(request, response);
	
    }
		
		
	 
}
