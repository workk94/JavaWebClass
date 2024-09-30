package day09;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

//메뉴정보 리스트 json으로 제공하기
//get

@WebServlet("/pracJson2")
public class FoodServletJson2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ArrayList<Food> list = new ArrayList<>();
		list.add(new Food("오므라이스", 4000));
		list.add(new Food("돈까스", 10000));
		list.add(new Food("비빔밥", 8000));

		// list => jsonArray로 변환
		
		
		JSONArray arr = new JSONArray();
		
		for(Food food : list ) {
			//JSONObject 변환
			//JSONArray에 추가 
			JSONObject o = new JSONObject();
			o.put("name", food.getName());
			o.put("price", food.getPrice());
			
			arr.put(o);
		}
		
		
		System.out.println(arr);
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		
		resp.getWriter().println(arr);
	}
}
