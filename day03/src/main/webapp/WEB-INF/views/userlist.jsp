<%@page import="ex.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, td { border: 1px solid black }
</style>
</head>
<body>
<h2>고객정보</h2>
<table>
<tr>
<td>아이디</td>
<td>이름</td>
<td>전화번호</td>
<td>주소</td>
</tr>
<% 
ArrayList<User> list = (ArrayList<User>)request.getAttribute("list"); 
%>

<% for (User user : list) {%>
<tr>
<td><%=user.getId() %></td>
<td><%=user.getName() %></td>
<td><%=user.getPhone() %></td>
<td><%=user.getAddress() %></td>
</tr>

<%}%>
</table>
</body>
</html>