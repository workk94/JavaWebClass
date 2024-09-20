package day02.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/msg/random")
public class RandCheerUp extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String[] msg = {"오늘도 화이팅!!", "굿굿", "할수있다"};

		PrintWriter out = resp.getWriter();
		out.println(msg[(int)(Math.random()*msg.length)]);
	}
}
