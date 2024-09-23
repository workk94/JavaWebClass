package ex;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger";
	
	Connection dbcon() {
		Connection con = null;
		
		try {
			//1.
			Class.forName(driver);
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
	
	public ArrayList<UserDTO> selectAll(){
		ArrayList<UserDTO> list = null;
		list = new ArrayList<>();
		
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		
		try {
			String sql = "SELECT * FROM USER_100";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String addr = rs.getString(4);
				String gender = rs.getString(5);
				String height_ = rs.getString(6);
				String weight_ = rs.getString(7);
				
				int height = 0;
				int weight = 0;
				if(height_!=null) height = Integer.parseInt(height_);
				if(weight_!=null) weight = Integer.parseInt(weight_);
				
				UserDTO user = new UserDTO(id, name, phone, addr, gender, height, weight);
				list.add(user);
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
	
}
