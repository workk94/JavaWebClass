package prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pracHello5")
public class HelloServletMVC3 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HelloService service = new HelloService();
		String data = service.getData();
		
		
		// 모델 저장 (모델: 데이터를 만드는데 사용되는 순수한 자바)
		//요청이 들어오고 응답이 될때까지만 살아있음 
		req.setAttribute("data", data);
		req.getRequestDispatcher("WEB-INF/views/pracHello5.jsp").forward(req, resp);
	}
}
