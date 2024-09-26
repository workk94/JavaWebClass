package model;

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
		
		Connection con = null;
		
		try {
			
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
	
	private void dbclose(AutoCloseable ...autoCloseables) {
		
		for(AutoCloseable a : autoCloseables) {
			if(a != null) {
				try {
					a.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	// user_id로 유저 찾기
	public User selectOne(String id) {
		
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String sql = "select * from user_100 where id = ?";
		
		User user = null;
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				String u_id = rs.getString(1);
				String u_name = rs.getString(2);
				String u_phone = rs.getString(3);
				String u_address = rs.getString(4);
				String u_gender = rs.getString(5);
				int u_height = rs.getInt(6);
				int u_weight = rs.getInt(7);
				String u_password = rs.getString(8);
				
				user = new User(u_id, u_name, u_phone, u_address, u_gender, u_height, u_weight, u_password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(con, pst, rs);
		}
		
		return user;
		
	}
	
	// 유저 등록
	public int insert(User user) {
		
		int rRow = 0;
		
		Connection con = dbcon();
		PreparedStatement pst = null;
		
		String sql = "insert into user_100(id, name, phone, address, gender, height, weight, password) values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getId());
			pst.setString(2, user.getName());
			pst.setString(3, user.getPhone());
			pst.setString(4, user.getAddress());
			pst.setString(5, user.getGender());
			pst.setInt(6, user.getHeight());
			pst.setInt(7, user.getWeight());
			pst.setString(8, user.getPassword());
			
			rRow = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(con, pst);
		}
		
		return rRow;
		
	}
	
	public ArrayList<User> selectAll(){
		Connection con = null;
		String sql = "select * from user_100";
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<User> list = new ArrayList<>();
		con=dbcon();
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String address = rs.getString(4);
				String gender = rs.getString(5);
				String height_ = rs.getString(6);
				String weight_ = rs.getString(7);
				String password = rs.getString(8);
				
				int height = 0; 
				int weight = 0; 
				
				if(height_ != null) height = Integer.parseInt(height_);
				if(weight_ != null) weight = Integer.parseInt(weight_);
				
				User user = new User(id, name, phone, address, gender, height, weight, password);
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(rs,pst,con);
		}
		
		return list;
	}
	
	public int getUserTotalAmount(String id) {
		
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		int totalAmount = 0;
		
		String sql = "select sum(i.quantity * p.price) from order_100 o join order_item_100 i on o.order_id = i.order_id join product_100 p on i.product_no = p.product_no where o.user_id = ?";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				totalAmount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(con, pst, rs);
		}
		
		return totalAmount;
		
	}
		
	
	
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
//		ArrayList<User> list = dao.selectAll();
//		System.out.println(list);
		
		int totalAmount = dao.getUserTotalAmount("bol04");
		System.out.println(totalAmount);
	}

}
