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

@WebServlet("/newReview")
public class NewReviewServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String userId = req.getParameter("userid");
		String productNo = req.getParameter("productno");
		String productName = req.getParameter("productname");
		String itemNo = req.getParameter("itemno");
				
		ShopService service = new ShopService();
		
		ArrayList<Review> list = service.getAllReview();
		int last = 0;
		for(Review r : list) {
			if(last < Integer.parseInt(r.getReview_id().substring(1))) {
				last = Integer.parseInt(r.getReview_id().substring(1));
			}
		}
		int index = last + 1;
		System.out.println(last);
		String reviewId = "r" + String.format("%03d", index);
		System.out.println(reviewId);
		Review review = new Review(reviewId, userId, productNo, productName, itemNo);
		
		req.setAttribute("review", review);
		req.getRequestDispatcher("/WEB-INF/views/newReview.jsp").forward(req, resp);
//		
//		req.setAttribute("review", review);
//		req.getRequestDispatcher("/WEB-INF/views/review.jsp").forward(req, resp);
	}
}
