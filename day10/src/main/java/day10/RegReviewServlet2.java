package day10;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/reg2")
public class RegReviewServlet2 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		//클라이언트의 요청바디의 내용 읽어오기
		//req.getInputStream();
		
		BufferedReader reader =  req.getReader();
		
		StringBuilder build = new StringBuilder();
		
		String line = null;
		while((line = reader.readLine()) != null) {
			build.append(line);
		}
		
		System.out.println(build.toString());
		String bodyData = build.toString();
		
		//json객체로 변환 
		//자바객체로 변환
		
		JSONObject o = new JSONObject(bodyData);
		
		String id = o.getString("id");
		String content = o.getString("content");
		
		Review review = new Review(id, content);
		System.out.println(review);
		
		resp.getWriter().println("ok");
	}
}
