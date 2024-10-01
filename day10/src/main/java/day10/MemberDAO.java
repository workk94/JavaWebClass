package day10;

import java.sql.*;
import java.util.ArrayList;

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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public ArrayList<Member> selectAll() {
		ArrayList<Member> list = new ArrayList<>();
		String sql = "SELECT * FROM USERTBL";

		try (Connection con = dbcon();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(1);
				String name = rs.getString(1);
				list.add(new Member(id, pw, name));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public Member findMember(String id) {
		Member member = null;
		String sql = "SELECT * FROM USERTBL WHERE id = ?";

		try (Connection con = dbcon(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					String foundId = rs.getString(1);
					String foundPw = rs.getString(2);
					String foundName = rs.getString(3);
					member = new Member(foundId, foundPw, foundName);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;
	}

	public Member findByMemberIdAndPassword(String id, String password) {
		Member member = null;
		String sql = "SELECT * FROM USERTBL WHERE id = ? AND password = ?";

		try (Connection con = dbcon(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, id);
			pst.setString(2, password);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					String foundId = rs.getString(1);
					String foundPw = rs.getString(2);
					String foundName = rs.getString(3);
					member = new Member(foundId, foundPw, foundName);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;
	}
}
