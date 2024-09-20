package day02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//1.HttpServlet 상속받기
//2.서블릿으로 등록하기 @WebServlet("/hi")
//3.service 매서드를 자신의 요청에 맞게 응답할 수 있도록 재정의 해야 한다 
//4.출력스트림을 통해서 만든 응답내용을 보내야 한다 

@WebServlet("/starEx")
public class 별응답서블릿 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//resp.setContentType("text/plain;charset=utf-8");
		
		//출력스트림을 얻어오기전에 설정해야한다. !! 
		
		PrintWriter out = resp.getWriter();
		out.println("★★★★★★★★★");
	}
}
