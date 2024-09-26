package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Review;
import model.ShopService;


@WebServlet("/review/create")
public class ReviewCreateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reviewId = req.getParameter("reviewid");
		String userId = req.getParameter("userid");
		String productNo = req.getParameter("productno");
		String productName = req.getParameter("productname");
		String itemNo = req.getParameter("itemno");
		String content = req.getParameter("content");
		String rating = req.getParameter("rating");
		
		System.out.println(reviewId + userId + productNo + productName + itemNo + content + rating);
		
		ShopService service = new ShopService();
		int result = service.createReview(new Review(reviewId, userId, productNo, productName, itemNo, content, rating));
		System.out.println(result);
		
		resp.sendRedirect("/acornshop/orders");
	}

}
