<%@ page import="day02.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
Movie m = new Movie("베테랑2", "1시간58분", "정해인, 황정민");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
	border: 1px, solid, black;
}
</style>
</head>
<body>
	<table>
		<tr>
			<th>영화이름</th>
			<th>상영시간</th>
			<th>주연배우</th>
		</tr>
		<tr>
			<td><%=m.getName()%></td>
			<td><%=m.getRunningtime()%></td>
			<td><%=m.getActor()%></td>
		</tr>
	</table>
</body>
</html>