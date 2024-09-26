package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Review;
import model.ShopService;

@WebServlet("/review/update")
public class ReviewUpdateServelet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reviewId = req.getParameter("id");
		String newContent = req.getParameter("content");
		String newRating = req.getParameter("rating");
		
		System.out.println(newContent);
		System.out.println(newRating);
		
		ShopService service = new ShopService();
		Review review = service.getReview(reviewId);
		
		service.updateReview(review, newContent, newRating);
		
		resp.sendRedirect("/acornshop/mypage");
	}
}
