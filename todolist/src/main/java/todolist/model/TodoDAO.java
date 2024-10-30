package todolist.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TodoDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";

	private Connection dbCon() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if (con != null)
				System.out.println("db 연결");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public ArrayList<Todo> selectAll() {

		String sql = "SELECT * FROM todotbl";
		ArrayList<Todo> list = new ArrayList<>();

		try (Connection con = dbCon();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			
			while(rs.next()) {
				String id = rs.getString("id");
				String content = rs.getString("content");
				String createAt = rs.getString("create_at");
				
				list.add(new Todo(id, content, createAt));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//test
	/*
	public static void main(String[] args) {
		TodoDAO dao = new TodoDAO();
		ArrayList<Todo> list = dao.selectAll();
		
		for(Todo item  :  list) {
			System.out.println(item);
		}
	}
	*/
}
