package day02.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dan")
public class Gugudan extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String _num = req.getParameter("num");
		int num = Integer.parseInt(_num);
		
		PrintWriter out = resp.getWriter();
		for(int i = 1; i <=9; i++) {
			out.println(num + " X " + i + " = " + num * i);
		}
		
	}
}
