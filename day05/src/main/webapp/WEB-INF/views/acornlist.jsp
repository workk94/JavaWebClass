<%@page import="day05.Acorn"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table, td{
border: 1px solid black;
}
</style>
</head>
<body>


<table>
<tr>
<td>아이디</td>
<td>비번</td>
<td>이름</td>
<td>변경/삭제</td>
</tr>
<% ArrayList<Acorn> list = (ArrayList<Acorn>) request.getAttribute("list"); %>
<% for(Acorn acorn : list){ %>
<tr>
<td><%=acorn.getId() %></td>
<td><%=acorn.getPw()%></td>
<td><%=acorn.getName()%></td>
<td>
	<a href="/day05/acorn?id=<%= acorn.getId() %>">변경</a>
	<a href="/day05/deleteAcorn?id=<%= acorn.getId() %>">삭제</a>
</td>

</tr>
<% } %>
</table>
</body>
</html>