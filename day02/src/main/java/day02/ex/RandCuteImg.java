package day02.ex;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cute/img/random")
public class RandCuteImg extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//웹 어플리케이션이 사용되는 리소스의 실제파일 경로, webapp 아래 
		String IMG_DIR = getServletContext().getRealPath("/img");
		File dir = new File(IMG_DIR);
		String[] filenames = dir.list();
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<img src=\"/day02/img/" + filenames[(int)(Math.random()*filenames.length)] + "\" width=\"500\" height=\"500\"/>");
		out.println("</body>");
		out.println("</html>");
	}
}
