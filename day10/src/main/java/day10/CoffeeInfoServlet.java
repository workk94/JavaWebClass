package day10;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/coffeeinfo")
public class CoffeeInfoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		CoffeeService service = new CoffeeService();
		ArrayList<Coffee> list = service.getCoffeeList();
		
		req.setAttribute("coffeelist", list);
		req.getRequestDispatcher("WEB-INF/views/coffeeinfo.jsp").forward(req, resp);
	}
}
