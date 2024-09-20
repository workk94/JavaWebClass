package day02.ex;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sum")
public class SumServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String value = req.getParameter("value");
		int n = Integer.parseInt(value);
		
		int sum = 0;
		for(int i = 1; i <=n; i++) {
			sum +=i;
		}
		
		req.setAttribute("result", sum);
		req.setAttribute("value", value);
		
		req.getRequestDispatcher("test.jsp").forward(req, resp);
	}
}
