package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {
	
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
	
	public ArrayList<Product> selectAll(){
		
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String sql = "SELECT p.NAME, b.NAME, p.CATEGORY, p.PRICE, p.img_url FROM PRODUCT_100 p JOIN BRAND_100 b ON p.BRAND_NO = b.BRAND_NO";
		
		ArrayList<Product> list = new ArrayList<>();
		
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String product_name = rs.getString(1);
				String brand_name = rs.getString(2);
				String category = rs.getString(3);
				String price_ = rs.getString(4);
				int price = Integer.parseInt(price_);
				String img_url = rs.getString(5);
				
				Product product = new Product(product_name, brand_name, category, price, img_url);
				
				list.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(con, pst, rs);
		}
		
		return list;
		
	}

}
