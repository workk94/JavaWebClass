<%@page import="ex.UserDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
border: 1px solid black;
}
td, th {
border: 1px solid black;
}
</style>
</head>
<body>
<% ArrayList<UserDTO> list = (ArrayList<UserDTO>)request.getAttribute("list"); %>

<table>
<tr>
<th>아이디</th>
<th>이름</th>
<th>전화번호</th>
<th>주소</th>
<th>성별</th>
<th>몸무게</th>
<th>키</th>

</tr>
<% for(UserDTO user : list){ %>
<tr>
<td><%=user.getId() %></td>
<td><%=user.getName() %></td>
<td><%=user.getPhone() %></td>
<td><%=user.getAddress() %></td>
<td><%=user.getGender() %></td>
<td><%=user.getHeight() %></td>
<td><%=user.getWeight()%></td>
</tr>
<%} %>

</table>



</body>
</html>