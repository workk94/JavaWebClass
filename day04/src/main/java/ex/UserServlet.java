package ex;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/user")
public class UserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		UserService service = new UserService();
		ArrayList<UserDTO> list = service.showUser();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(req, resp);
	}
}
