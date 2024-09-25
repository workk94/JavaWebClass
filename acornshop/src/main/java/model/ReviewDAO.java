package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewDAO {
	
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
	
	// 유저 id로 리뷰 목록 찾기 (리뷰, 상품 테이블 조인)
	public ArrayList<Review> selectAllByUserId(String id){
		
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String sql = "select * from review_100 r join product_100 p on r.product_no = p.product_no where user_id = ?";
		
		ArrayList<Review> list = new ArrayList<>();
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String review_id = rs.getString(1);
				String user_id = rs.getString(2);
				String product_id = rs.getString(3);
				String product_name = rs.getString(9);
				String item_no = rs.getString(4);
				String content = rs.getString(5);
				String rating = rs.getString(6);
				
				Review review = new Review(review_id, user_id, product_id, product_name, item_no, content, rating);
				
				list.add(review);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(con, pst, rs);
		}
		
		return list;
		
	}
	
	
	//리뷰 변경 - 작업중 
//	public int update(String review_id) {
//		Connection con = null;
//		
//		String sql = "UPDATE REVIEW_100 SET CONTENT = '재질좋음' WHERE REVIEW_ID = 'r001'";
//		con = dbcon();
//		PreparedStatement pst;
//		
//	}
	
	public static void main(String[] args) {
		ReviewDAO dao = new ReviewDAO();
		ArrayList<Review> list = dao.selectAllByUserId("latest665");
		System.out.println(list);
	}

}
