package ex;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/todo")
public class TodoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<String> list = new ArrayList<>();
		list.add("9/23 일정1");
		list.add("9/24 일정2");
		list.add("9/25 일정3");
		
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/todo.jsp").forward(req, resp);
	}
}
