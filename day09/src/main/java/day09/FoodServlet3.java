package day09;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//메뉴정보 리스트를 제공하기 

@WebServlet("/pracFood3")
public class FoodServlet3 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		
		ArrayList<Food> list = new ArrayList<>();
		list.add(new Food("오므라이스", 4000));
		list.add(new Food("돈까스", 10000));
		list.add(new Food("비빔밥", 8000));
		
		PrintWriter out = resp.getWriter();
		
		out.println(list);
	}
}
