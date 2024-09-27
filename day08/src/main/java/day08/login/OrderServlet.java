package day08.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//주문정보 제공하는 서비스
//get

@WebServlet("/orderex")
public class OrderServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//로그인 여부에 따라 주문정보가 보여지거나 아니면 로그인 페이지가 제공될 수 있도록 하기
		
		//세션저장소에 로그인 정보 가져오기
		
		HttpSession session = req.getSession();
		String userid = (String) session.getAttribute("loginId"); // 
 		
		// 저장소에서 로그인정보 확인
		if(userid != null) { // 로그인 
			//로그인이 O 되었던 고객이다!!
			
			//주문데이터가져오기
			
			req.getRequestDispatcher("WEB-INF/views/orderlist.jsp").forward(req, resp);
			
		} else {
			//로그인 x
			
			resp.sendRedirect("/day08/loginex");
		}
		
		//해당 고객의 주문 정보 데이터 가져오기(모델)
		
		//req.getRequestDispatcher("WEB-INF/views/orderlist.jsp").forward(req, resp);
	}
}
