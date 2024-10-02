package day11;

import java.sql.*;
import java.util.ArrayList;

public class AcornDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";
	Connection con = null;

	private Connection dbCon() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if (con != null) {
				System.out.println("db ok");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	
	// 페이징 리스트 구하기 ArrayList
	
	public ArrayList<Acorn> selectListPaging(int currentPage, int pageSize){ // 1, 10 
		Connection con = dbCon();
		ResultSet rs = null;
		PreparedStatement pst =null;
		
		String sql = "SELECT * "
				+ "FROM "
				+ "(SELECT rownum num, id, pw, name FROM ACORNTBL)"
				+ "WHERE num BETWEEN ? AND ?"; // 페이징 쿼리 작성 
		System.out.println(sql);
		
		
		int start = 11;
		int end = 20;
		
		start = (currentPage -1 )* pageSize +1;
		end = currentPage * pageSize; // 1 => 1~10 2 => 11~20
		
		ArrayList<Acorn> list = new ArrayList<>();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, start);
			pst.setInt(2, end);
			
			rs = pst.executeQuery();
			
			
			
			while(rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				Acorn acorn = new Acorn(id, pw, name);
				list.add(acorn);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pst != null) pst.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
		
	
	//전체 레코드 수 구하기 
	
	public int selectTotalCnt() {
		Connection con = dbCon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String sql = "select count(*) from acorntbl"; // 전체 레코드 수
		
		int rowTotalCnt = 0;
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery(sql);
			
			if(rs.next()) {
				rowTotalCnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pst != null) pst.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return rowTotalCnt;
	}
	
	
	public static void main(String[] args) {
		AcornDAO dao = new AcornDAO();
		int result = dao.selectTotalCnt();
		System.out.println(result);
		
		ArrayList<Acorn> list = dao.selectListPaging(1, 10);
		System.out.println(list);
	}
}
