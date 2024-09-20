package ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/myServlet2")
public class MyServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

		UserDAO dao = new UserDAO();
		ArrayList<User> list  =dao.getUserList();
		
		
		req.setAttribute("list", list);		
		req.getRequestDispatcher("WEB-INF/views/userlist.jsp").forward(req, resp);
		
	}
}
