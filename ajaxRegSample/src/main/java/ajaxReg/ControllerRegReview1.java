package ajaxReg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


@WebServlet("/reg1")
public class ControllerRegReview1  extends HttpServlet {
 
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		req.setCharacterEncoding("utf-8"); 		 
		String id = req.getParameter("id");
		String content = req.getParameter("content");
		
		
		System.out.println( id);
		System.out.println( content);
		
		//서비스 객체를 통해서 데이터베이스 저장
		 
		resp.getWriter().print("ok");
	}
}
