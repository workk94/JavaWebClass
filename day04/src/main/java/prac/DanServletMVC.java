package prac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/danPracMVC")
public class DanServletMVC extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//사용자 입력부분
		String su_ = req.getParameter("su");
		int su = 2;
		
		if(su_ != null) {
			su = Integer.parseInt(su_);
		}
		
		System.out.println(su);
		//데이터 만들기
		
		//POJO
		DanService service = new DanService();
		String result = service.getDan(su);
		
		//응답 view forward
		req.setAttribute("dan", result);
		req.getRequestDispatcher("WEB-INF/views/danView.jsp").forward(req, resp);
		
	}
}