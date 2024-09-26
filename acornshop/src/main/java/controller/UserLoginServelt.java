package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Review;
import model.User;
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
		String id = req.getParameter("id"); // 아이디
		String pw = req.getParameter("pw"); // 패스워드
		
		UserService userService = new UserService();
		User user = userService.getMember(id);
		
		if(user != null && id.equals(user.getId()) && pw.equals(user.getPassword())) {
			req.getSession().setAttribute("id", id);
			resp.sendRedirect("/acornshop/mypage");
		} else {
			req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
		}
		
		
	}
}
