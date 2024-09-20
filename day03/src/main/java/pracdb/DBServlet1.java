package pracdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/acornList")
public class DBServlet1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
	
		//db
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String user = "scott";
		String password = "tiger";
		
		
		ArrayList<Acorn> list = new ArrayList<>();
		try {
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "select *from acorntbl";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery(sql);
			
			while(rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				
				Acorn acorn = new Acorn(id, pw, name);
				list.add(acorn);
			
			}
			rs.close();
			pst.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//
		for(Acorn acorn : list)
		{
			System.out.println(acorn);
		}
		
		//응답하기
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("table, td { border:1px solid black };");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>아이디</td>");
		out.println("<td>비밀번호</td>");
		out.println("<td>이름</td>");
		out.println("</tr>");
		
		
		for(Acorn acorn : list) {

			out.println("<tr>");
			out.println("<td>" + acorn.getId() + "</td>");
			out.println("<td>" + acorn.getPw() + "</td>");
			out.println("<td>" + acorn.getName() + "</td>");
			out.println("</tr>");
			
			
		}
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		

	}
}
