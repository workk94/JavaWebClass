package day02.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/star")
public class StrarDrawer extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String _cnt = req.getParameter("cnt");
		int cnt;
		
		if(_cnt == null) {
			cnt = 1;
		} else {
			cnt = Integer.parseInt(_cnt);
		}
		
		PrintWriter out = resp.getWriter();
		for(int i = 1 ; i <= cnt; i++) {
			out.println("★");
		}
	}
}
