package pracdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTEST {
	public static void main(String[] args) {
		
		
		//DB 연결정보
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String user = "scott";
		String password = "tiger";
		
		try {
			//1.드라이버 로드 (클래스 정보를 로드해서 객체를 생성)	
			Class.forName(driver);
			
			//2.데이터베이스 연결
			Connection con = DriverManager.getConnection(url, user, password);
			
			//3.문장 얻어오기(필요한 sql을 실행하고 결과를 얻어옴)
			Statement st = con.createStatement();
			
			//4.필요한 sql 작성하기
			String sql = "select * from acorntbl";
			
			ResultSet rs = st.executeQuery(sql);
			
			// sql select 결과집합 가져오기  
			while(rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
