package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";	
	

	
	private Connection dbcon() {		
		Connection con =null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return con;		
	}
	
	
	
	//에이콘목록가져오기 
	public ArrayList<User>  getUserList(){
		Connection con  =dbcon();
		PreparedStatement  pst=null;
		ResultSet  rs= null;
		
		String sql ="SELECT * FROM USER_100";
		
		ArrayList<User> list = new ArrayList<>();
		try {
			 pst =con.prepareStatement(sql);
			 rs= pst.executeQuery();
			 
			 while( rs.next()) {
				 String id  = rs.getString(1);
				 String name  = rs.getString(2);
				 String phone  = rs.getString(3);
				 String addr  = rs.getString(4);
				 User user = new User( id, name, phone, addr);
				 list.add(user); 
			 }
			 
			 
			 rs.close();
			 pst.close();
			 con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public static void main(String[] args) {
		
		UserDAO  dao = new UserDAO();
		ArrayList<User> list  =dao.getUserList();
		
		for( User user : list) {
			System.out.println( user);
			
		}
		
	}
}
