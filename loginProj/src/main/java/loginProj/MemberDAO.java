package loginProj;

import java.sql.*;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";	
	
	private Connection dbcon() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if(con != null) System.out.println("db connected");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	public Member selectMember(String id) {
		
		Member member = null;
	    String sql = "SELECT * FROM USERTBL WHERE id = ?";
	    
	    try (Connection con = dbcon();
	         PreparedStatement pst = con.prepareStatement(sql)) {

	        pst.setString(1, id);
	        
	        try (ResultSet rs = pst.executeQuery()) {
	            if(rs.next()) {
	            	String t_id = rs.getString(1);
		            String t_pw = rs.getString(2);
		            String t_nickname = rs.getString(3);
		            member = new Member(t_id, t_pw, t_nickname);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return member;
	}
	
	
	public boolean isUserExist(String id, String pw) {
	    String sql = "SELECT password FROM USERTBL WHERE id = ? ";
	    
	    try (Connection con = dbcon();
	         PreparedStatement pst = con.prepareStatement(sql)) {	        
	        pst.setString(1, id);
	        
	        try (ResultSet rs = pst.executeQuery()) {
	            if (rs.next()) {
	                String dbpw = rs.getString(1); 
	                if (dbpw.equals(pw)) {
	                    return true;
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false; 
	}

	
//	public static void main(String[] args) {
//		MemberDAO dao = new MemberDAO();
//		boolean result = dao.isUserExist("test", "te");
//		System.out.println(result);
//		
//	}
}
