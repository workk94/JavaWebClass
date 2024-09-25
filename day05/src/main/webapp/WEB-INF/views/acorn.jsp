<%@page import="day05.Acorn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Acorn acorn = (Acorn)request.getAttribute("acorn"); %>
<h2>회원정보</h2>
<form name="frm" action="/day05/update" method="post">
<table>
<tr>
<td>아이디</td>
<td><input type="text" name="id" value="<%=acorn.getId()%>"> </td>
</tr>
<tr>
<td>비번</td>
<td><input type="text" name="pw" value="<%=acorn.getPw()%>"></td>
</tr>
<tr>
<td>이름</td>
<td><input type="text" name="name" value="<%=acorn.getName()%>"> </td>
</tr>
<tr>
<td colspan="2"><button>변경</button></td>
</tr>
</table>
</form>
<a href="/day05/acornList">뒤로가기</a>
</body>
</html>