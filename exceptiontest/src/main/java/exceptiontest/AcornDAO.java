package exceptiontest;

import java.sql.Connection;
 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 

public class AcornDAO {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="1234";
	
	public Connection dbcon() {		 
		Connection con = null;
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url, user, password);
			if( con != null) System.out.println( "ok");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;		 	
	}
	
	 
	 
	 
	public void insert(  )     {
		
		
		Connection con = dbcon();
		String sql =" insert into  acorntbl( pw ,name)  values( '1234', '홍길동')";
		
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
		 
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
			//예외 되던지, 예외 다시 일으킨다
			//throw e;			
			
		 	throw new  RuntimeException("데이터베이스 오류");
			 
		}
		
	}
	 
	 
	public void close( AutoCloseable ...a) {
		for( AutoCloseable  item : a) {
		   try {
			item.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
		
	}
 
	  
	public static void main(String[] args) {
		 
		 
		
	}

}
