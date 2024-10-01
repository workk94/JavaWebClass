<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>아이디</td>
<td>비번</td>
<td>이름</td>
</tr>

<c:forEach var="item" items="${list}">
<tr>
<td> ${item.id  }</td>
<td>${item.pw  } </td>
<td> ${item.name  }</td>
</tr>
</c:forEach>
</table>
</body>
</html>