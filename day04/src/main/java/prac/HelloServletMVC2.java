package prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pracHello4")
public class HelloServletMVC2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//모델(model)
		String content = "Acorn Student";
		
		//저장소 사용(request 저장소를 사용)
			
						// key		value
		req.setAttribute("content", content); // 모델 저장 		
		req.getRequestDispatcher("WEB-INF/views/pracHello4.jsp").forward(req, resp);
	}
}
