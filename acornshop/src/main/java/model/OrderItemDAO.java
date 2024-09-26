package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderItemDAO {
	
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
	
	public ArrayList<OrderItem> selectAllByUserId(String id){
		
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String sql = "select i.item_no, i.order_id, i.product_no, i.quantity, i.item_size, o.user_id, to_char(o.order_date, 'YYYY-MM-DD HH24:mm:ss'), p.name, i.quantity * p.price from order_item_100 i join order_100 o on i.order_id = o.order_id join product_100 p on i.product_no = p.product_no where o.user_id = ?";
		
		ArrayList<OrderItem> list = new ArrayList<>();
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String item_no = rs.getString(1);
				String order_no = rs.getString(2);
				String product_no = rs.getString(3);
				int quantity = rs.getInt(4);
				String item_size = rs.getString(5);
				String user_id = rs.getString(6);
				String order_date = rs.getString(7);
				String product_name = rs.getString(8);
				int amount = rs.getInt(9);
				
				OrderItem item = new OrderItem(item_no, order_no, product_no, quantity, item_size, user_id, order_date, product_name, amount);
				
				list.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(con, pst, rs);
		}
		
		return list;
		
	}
	
	public static void main(String[] args) {
		OrderItemDAO dao = new OrderItemDAO();
		ArrayList<OrderItem> list = dao.selectAllByUserId("latest665");
		System.out.println(list);
	}

}
