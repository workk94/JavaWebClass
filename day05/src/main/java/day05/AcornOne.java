package day05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/acorn")
public class AcornOne extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		AcornService service = new AcornService();
		Acorn acorn = service.getMember(id); // Model
		
		//System.out.println(acorn.toString());
		
		req.setAttribute("acorn", acorn);
		
		req.getRequestDispatcher("WEB-INF/views/acorn.jsp").forward(req, resp);
	}
}
