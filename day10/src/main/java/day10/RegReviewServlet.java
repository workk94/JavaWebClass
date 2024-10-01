package day10;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reg1")
public class RegReviewServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String content = req.getParameter("content");
		
		System.out.println(id);
		System.out.println(content);
		
		Review review = new Review(id, content);
		
		//서비스를 통해서 데이터베이스에 등록
		
		System.out.println(review);
		
		resp.getWriter().println("ok");
		
	}
}
