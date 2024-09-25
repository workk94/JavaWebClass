package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserService;
import oracle.jdbc.replay.driver.TxnReplayableSqlxml;

@WebServlet("/login")
public class UserLoginServelt extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id"); //아이디
		
		UserService service = new UserService();
		service.getMember(id);		
		//req.getRequestDispatcher("WEB-INF/views/mypage.jsp").forward(req, resp);
		
		resp.sendRedirect("/acornshop/product");
	}
}
