package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserService;

@WebServlet("/register")
public class UserRegServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/views/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String pw = req.getParameter("pw");
		String phone = req.getParameter("phone");
		String addr = req.getParameter("addr");
		String gender = req.getParameter("gender");
		String height_ = req.getParameter("height");
		String weight_ = req.getParameter("weight");		
		int height = Integer.parseInt(req.getParameter("height"));
		int weight = Integer.parseInt(req.getParameter("weight"));
		
		UserService service = new UserService();
		User existingUser = service.getMember(id); 
		
		
		//System.out.println(   existingUser);
		
		
		boolean isUserExist = (existingUser != null);   // 널이 아니면 true ,기존고객이면 true 
		
		//System.out.println(service.getMember(id));
		
		if(!isUserExist) {  // 신규이면
			User user = new User(id, name, phone, addr, gender, height, weight, pw);
			service.registerMember(user);
			System.out.println("등록완료");
			resp.sendRedirect("/acornshop/users");
		} else {
			System.out.println("회원이 이미 존재");
			req.setAttribute("isUserExist", "이미 존재하는 유저입니다");
			req.getRequestDispatcher("WEB-INF/views/register.jsp").forward(req, resp);
		}
		
	}
}
