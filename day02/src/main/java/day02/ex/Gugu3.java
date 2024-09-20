package day02.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dan3")
public class Gugu3 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//
		PrintWriter out = resp.getWriter();
		
		for(int i = 1; i <= 9; i++) {
			out.println("3 X " + i + " = " + 3 * i);
		}
		
	}
	
	
}
