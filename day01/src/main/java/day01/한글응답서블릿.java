package day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hangul")
public class 한글응답서블릿 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//안녕 서블릿!!! ^^ 반가워
		//응답정보를 설정할 수 있다 
		//서버가 보내는 데이터가 html 형식의 데이터이다 
		//보내는 데이터의 형식을 지정할 수 있다
		//주의사항은 출력스트림을 얻기전에 설정해야 한다 
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//response.setContentType("text/plain;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head></head> <body>안녕 서블릿!!! ^^ 반가워</body></html>");
	}
}
