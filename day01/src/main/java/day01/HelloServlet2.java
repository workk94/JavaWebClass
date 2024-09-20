package day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿을 만드는 방법
//1.서블릿을 상속받는다 
//2.서블릿의 시작메서드 service를 오버라이드한다  (  ) // 주문정보, 상품상세정보, 댓글, ...
//3.요청에 대한 내용을 만든다 (응답결과를 만든다)
//4.요청한 쪽으로 응답한다


//요청 (/hi3) => 간단한 메시지를 제공하는 서비스 
//서블릿 만들고 응답하기
//서블릿 url요청 매핑 정하기 


@WebServlet("/hi3")
public class HelloServlet2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//응답하기 
		//응답하기 위한 스트림 얻어오기(출력스트림 : 나가는길)
		
		PrintWriter out = response.getWriter();
		out.println("<html><head></head> <body><h2> ^______^ </h2> </body></html>");
	}
}
