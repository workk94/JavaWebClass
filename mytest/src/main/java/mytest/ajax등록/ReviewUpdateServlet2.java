package mytest.ajax등록;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


@WebServlet("/update2")
public class ReviewUpdateServlet2 extends HttpServlet{
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 클라이언트가 body로 보낸 데이터를 읽음 
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		StringBuffer sb = new StringBuffer();
		String line;
		
		while((line=br.readLine())!= null) {
			sb.append(line);
		}
		
		System.out.println(sb.toString());
		br.close();
		
		
		// 읽은 본문을 json으로 파싱 
		JSONObject jsonBody = new JSONObject(sb.toString());
		String id = jsonBody.getString("id");
		String content = jsonBody.getString("content");
		
		System.out.println(id);
		System.out.println(content);
		
		Review review = new Review(id, content);
		System.out.println(review);
		
		
	}
}
