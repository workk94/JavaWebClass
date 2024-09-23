package movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";	
	
	// 
	Connection dbCon() {
		Connection con = null;
		
		try {
			
			//1.
			Class.forName(driver);
			
			//2.
			con = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	public ArrayList<Movie> selectAll(){
		//3.
		Connection con = dbCon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from  movietbl";
		
		ArrayList<Movie> list = new ArrayList<>();
		
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) { // 한 행(레코드)
				String id = rs.getString(1);
				String title = rs.getString(2);
				String url = rs.getString(3);
				String genre = rs.getString(4);
				
				Movie m = new Movie(id, title, url, genre);
				list.add(m);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pst != null) pst.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	
	
	
	public static void main(String[] args) {
		MovieDAO m = new MovieDAO();
		
		ArrayList<Movie> list = m.selectAll();
		System.out.println(list);
	}
	
}
