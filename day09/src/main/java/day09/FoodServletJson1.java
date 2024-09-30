package day09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


@WebServlet("/pracJson1")
public class FoodServletJson1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//
		Food food = new Food("오므라이스", 4000);	
		
		//Json으로 변환한 다음 응답하기 { name : "오므라이스", price : 4000 };
		
		//
		JSONObject o = new JSONObject();
		o.put("name", food.getName());
		o.put("price", food.getPrice());
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().println(o);
		
		
	}
}
