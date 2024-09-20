package pracdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBTEST2 {
	
	public static void main(String[] args) {
		
		//데이터베이스 에이콘학생정보 -> ArrayList<Acorn>
		
		
		//ArrayList<Acorn> list = new ArrayList<>();
		
		
		/*
		list.add(new Acorn("a01", "1234", "test1"));
		list.add(new Acorn("a02", "1234", "test2"));
		list.add(new Acorn("a03", "1234", "test3"));
		
		for(Acorn acorn : list) {
			System.out.println(acorn);
		}
		*/
		
		
		
		// 라이브러리 ojdbc8.jar => WEB-INF/lib
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String user = "scott";
		String password = "tiger";
		
		
		ArrayList<Acorn> list = new ArrayList<>();
		
		try {
			//1.
			Class.forName(driver);
			//반환 타입이 Connection임 
			Connection con = DriverManager.getConnection(url, user, password);
			String sql = "select * from acorntbl";
			PreparedStatement pst = con.prepareStatement(sql);			
			
			//등록, 변경, 삭제 => executeUpdate()
			//조회 => executeQuery
			ResultSet rs = pst.executeQuery(); // 매개변수 비어둔다
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				
				//Acorn 객체 생성
				Acorn acorn = new Acorn(id, pw, name);
				list.add(acorn);
			}
			
			rs.close();
			pst.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//학생정보(ArrayList에 있는)
		for(int i = 0; i < list.size(); i++) {
			Acorn a = list.get(i);
			System.out.println(a);
		}
	}
	
}
