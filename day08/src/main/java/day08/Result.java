package day08;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/resultex")
public class Result extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String flower = req.getParameter("flower");
		
		//세션에 저장하기 
		HttpSession session = req.getSession();
		
		//설문정보 저장하기
		
		session.setAttribute("survey2", flower);
		
		
		req.getRequestDispatcher("WEB-INF/views/result.jsp").forward(req, resp);
	}
}
