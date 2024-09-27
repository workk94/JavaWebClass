package login;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);		
	}
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		 //
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		// LoginService service = new LoginService( );
		// boolean result  =  service.userCheck(id, pwd);
		
		boolean result=true;
		//회원인경우 , 세션에 아이디저장 , 주문정보 화면
		
		result =  (id.equals(pwd))?true:false;
		if(result) {
		//회원인경우 session저장소 이용
			HttpSession session  = request.getSession();
			session.setAttribute("id", id);
			request.getRequestDispatcher("WEB-INF/views/main.jsp").forward(request, response);
		}
		else {
		   //비회원인경우			
			String message  = URLEncoder.encode("아이디확인","utf-8");
			
			//sendRedirect시 데이터를 보낼 수 있디. 이때 한글인 경우 utf-8인코딩이 필요하다
			//url로 요청시는 웹브라우저가 자동으로 인코딩을 해준다 
			
			response.sendRedirect("/sessionSample/login?message=" + message);
			
		}
	}

}
