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

@WebServlet("/mypage")
public class UserPageServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		//String user = req.getParameter("id");
		
		//특정 유저
		String userid = "latest665";
		
		ShopService service = new ShopService();
		ArrayList<Review> list= service.getUserReview(userid);
				
		req.setAttribute("list", list);
		req.getRequestDispatcher("WEB-INF/views/mypage.jsp").forward(req, resp);
	}
}
