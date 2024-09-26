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

	private void dbclose(AutoCloseable... autoCloseables) {

		for (AutoCloseable a : autoCloseables) {
			if (a != null) {
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
	public ArrayList<Review> selectAllByUserId(String id) {

		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "select * from review_100 r join product_100 p on r.product_no = p.product_no where user_id = ?";

		ArrayList<Review> list = new ArrayList<>();

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();

			while (rs.next()) {
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

	// review_id로 리뷰찾기
	public Review selectOne(String id) {

		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM review_100 WHERE REVIEW_ID = ?";

		Review review = null;

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {
				String review_id = rs.getString(1);
				String user_id = rs.getString(2);
				String product_no = rs.getString(3);
				String item_no = rs.getString(4);
				String content = rs.getString(5);
				String rating = rs.getString(6);

				review = new Review(review_id, user_id, product_no, item_no, content, rating);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(con, pst, rs);
		}

		return review;

	}
	
	
	//리뷰 변경
	public int update(Review review, String newContent, String newRating) {
		int rRow = 0;
		Connection con = dbcon();
		PreparedStatement pst = null;
		String sql = "update review_100 set content=?, rating=? where review_id = ?";

		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, newContent);
			pst.setString(2, newRating);
			pst.setString(3, review.getReview_id());
			rRow = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(pst, con);
		}

		return rRow;
	}
	
	public ArrayList<Review> selectAll(){
		
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "select * from review_100 r join product_100 p on r.product_no = p.product_no";

		ArrayList<Review> list = new ArrayList<>();

		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
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
	
	public int insert(Review review) {
		
		int rRow = 0;
		
		Connection con = dbcon();
		PreparedStatement pst = null;
		
		String sql = "insert into review_100(review_id, user_id, product_no, item_no, content, rating) values(?, ?, ?, ?, ?, ?)";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, review.getReview_id());
			pst.setString(2, review.getUser_id());
			pst.setString(3, review.getProduct_no());
			pst.setString(4, review.getItem_no());
			pst.setString(5, review.getContent());
			pst.setString(6, review.getRating());
			
			rRow = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbclose(con, pst);
		}
		
		return rRow;
		
	}
	
	public static void main(String[] args) {
		ReviewDAO dao = new ReviewDAO();
		ArrayList<Review> list = dao.selectAll();
		System.out.println(list);
	}

}
