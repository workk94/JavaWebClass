package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserService;

@WebServlet("/users")
public class UserListServelt extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserService service = new UserService();
		
		ArrayList<User> list = service.getAllMember();
		System.out.println(list);
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/userlist.jsp").forward(req, resp);
	}
}
