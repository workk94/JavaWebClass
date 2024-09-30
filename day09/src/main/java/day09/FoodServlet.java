package day09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//메뉴정보 제공하는 서비스(data만 제공하는 서비스)
//Get요청
@WebServlet("/pracFood1")
public class FoodServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		
		//메뉴정보 한 개를 응답 하기
		
		PrintWriter out = resp.getWriter();
		String menu = "오므라이스 4000원";
		out.println(menu);
	}
}
