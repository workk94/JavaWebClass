package mytest.ajax연습;

import java.sql.*;
import java.util.ArrayList;

public class MovieDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver" ;
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger";
	
	Connection dbcon() {
		Connection con = null;	
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if(con != null) System.out.println("ok");
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
		String sql = "SELECT title, director, genre, running_time FROM movietbl_100";
		ArrayList<Movie> list = new ArrayList<>();
		
		try(Connection con = dbcon(); 
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery()) {
			while(rs.next()) {
				String title = rs.getString(1);
				String director = rs.getString(2);
				String genre = rs.getString(3);
				int runningTime = rs.getInt(4);
				
				Movie movie = new Movie(title, director, genre, runningTime);
				list.add(movie);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public static void main(String[] args) {
		MovieDAO dao = new MovieDAO();
		ArrayList<Movie> list = null;
		list = dao.selectAll();
		
		for(Movie movie : list) {
			System.out.println(movie);
		}
	}
}
