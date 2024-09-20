package day02;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hap10")
public class 합10응답서블릿 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//
		int sum = 0;
		for(int i = 0; i <= 10; i++) {
			sum += i;
		}
		
		PrintWriter out = resp.getWriter();
		out.println(sum);
	}
}
