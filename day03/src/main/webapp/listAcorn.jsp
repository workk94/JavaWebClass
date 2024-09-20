<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
header{
 border:1px solid black;
 padding :20px;
 
}
nav{
	
	 border:1px solid black;
	 padding :10px;
}

a{
	text-decoration:none;
	color:black;
}
nav span{
   padding-right: 5px;
}


section {
 height: 500px;
 padding:10px;
}


footer{
  border:1px solid black;
  display: flex;
  padding:10px;
  
}

footer  > div{
 
}


footer > div:nth-child(1) {	 
	 width:20%;
}



footer > div:nth-child(2) {	 
	 width:60%;
}



footer > div:nth-child(3) {
	 
	 width:20%;
}

table{
	 width:400px;
	 border:1px solid black;
	 margin:0 auto;
}

td{
 border:1px solid black;
 text-align: center;
}

</style>
</head>
<body>

<header>
<h2>ACORN ACADEMY  학생 관리 프로그램</h2>
</header>

<nav>
	<span> <a href="listAcorn.jsp"> 에이콘 학생 조회</a></span>
	<span> <a href="에이콘학생등록.jsp"> 에이콘 등록</a></span>
	 
</nav>

<section>
  <h2>  에이콘 학생 조회 </h2>
  <table>
  
  <!--  제목줄 -->
  	<tr>
  	  <td>아이디</td>
  	  <td>비번</td>
 	  <td>이름</td>
  	   	  
  	</tr>  	  	
  	
  	
 <% Connection con=null;
	Statement st = null;
	ResultSet rs = null;
	try{ 
		//데이터베이스 연결정보
		String driver = "oracle.jdbc.driver.OracleDriver" ;
		String url="jdbc:oracle:thin:@localhost:1521:testdb";
		String user="scott";
		String password="tiger";
		
		 //1. 오라클드라이버 로딩
		Class.forName(driver); 
		 //2. 데이터베이스 연결
		con= DriverManager.getConnection(url, user, password);
		 
		if( con == null) {  System.out.println(" 연결실패");} 
		 //3. statement 얻어오기
		st = con.createStatement();
		 //4. 필요한 sql 작성
		String sql =" select  * from  acorntbl"; 
		rs = st.executeQuery( sql) ;
		 //6. 가져온 쿼리 결과를 화면에 출력하기
		while( rs.next() ) { 
		%> 	  	 
	  	 <tr>
	  	  <td><%=rs.getString(1)%></td>	  	 
	  	  <td><%=rs.getString(2)%></td>
	 	  <td><%=rs.getString(3)%></td>	   	  
	  	</tr>  	
  	 <%
  		}
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{ //자원의 반납
		if( rs!= null) rs.close();
		if( st != null) st.close();
		if( con != null) con.close();
	}
%>
  	
  </table>
 
</section>

<footer>
	<div>ACORN</div>
	<div>회사소개인재채용제휴제안이용약관개인정보처리방침청소년보호정책네이버 정책고객센터ⓒ NAVER Corp.</div>
	<div>기업 사이트</div>
</footer>
</body>
</html>