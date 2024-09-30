package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;


@WebServlet("/reviewList")
public class ControllerReviewList   extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter  out = response.getWriter();	 
		
		ModelReviewService service = new ModelReviewService();
		JSONArray  arr  =service.getFoodJsonArray();		
		out.print( arr);
		 
	 
		
	}
}
