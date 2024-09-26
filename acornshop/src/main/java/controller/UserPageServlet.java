package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Review;
import model.ShopService;
import model.UserService;

@WebServlet("/mypage")
public class UserPageServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		
		String id = (String)req.getSession().getAttribute("id");
		
		ShopService shopService = new ShopService();
		ArrayList<Review> list = shopService.getUserReview(id);
		
		UserService userService = new UserService();
		int totalAmount = userService.getMemberTotalAmount(id);
		
		req.setAttribute("list", list);
		req.setAttribute("totalAmount", totalAmount);
		
		req.getRequestDispatcher("WEB-INF/views/mypage.jsp").forward(req, resp);
	}
}
