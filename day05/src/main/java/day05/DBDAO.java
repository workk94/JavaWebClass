package day05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBDAO {

	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:testdb";
	String user = "scott";
	String password = "tiger";	
	
	
	
	
	public  ArrayList<Acorn>  selectAll(){
		Connection con =null;
		PreparedStatement pst =null;
		ResultSet rs = null;
		ArrayList<Acorn> list  = new ArrayList<>();
		
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url, user, password);
			
			if( con != null) System.out.println(" dbok");
			
			String sql=" select * from  acorntbl" ;			
			
			pst =con.prepareStatement(sql);
			rs  =pst.executeQuery();
			
			
		
			
			while( rs.next()) {  //rs => 한 행(레코드) 데이가 있음 
				String id  = rs.getString(1);
				String pw  = rs.getString(2);
				String name  = rs.getString(3);
				
				Acorn acorn = new Acorn( id, pw, name);
				
				list.add(acorn);				
			} 			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//무조건 수행되는 구문 
			//자원의 정리를 담당 
			
			
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
			if( pst !=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			 
			
			
			 
			if( con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			
		}
		

		
		// ArrayList<Acorn>
		/*
		for( Acorn  acorn : list) {
			System.out.println( acorn);
		} 
		*/
		
		return list;
		
	}
	
	
	
	
	public static void main(String[] args) {
		 
		//acorntbl   => select * from acorntbl;  =>  ArrayList<Acorn>
		// JDBC  -> 인터페이스     => 구현체는 각 데이터베이스회사에서 구현해서 제공한다  (라이브러리, 드라이버)
		
		
		DBDAO  dao   = new DBDAO();
		ArrayList<Acorn> list  =dao.selectAll();
		
		
		for( Acorn  acorn : list) {
			System.out.println( acorn);
		}
		
		
	 
	
		
	}

}
