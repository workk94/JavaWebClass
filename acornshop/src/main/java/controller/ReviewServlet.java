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

@WebServlet("/review")
public class ReviewServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String review_id = req.getParameter("id");
				
		ShopService service = new ShopService();
		Review review = service.getReview(review_id);
		
		req.setAttribute("review", review);
		req.getRequestDispatcher("/WEB-INF/views/review.jsp").forward(req, resp);
	}
}
