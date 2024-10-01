<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table {
	border: 1px solid black;
	border-collapse: collapse;
}

td {
	border: 1px solid black;
}

tr:nth-child(1){
	background-color: gray;
}

</style>
</head>
<body>
<h2>커피정보</h2>
<table>
<tr>
<td>이름</td>
<td>가격</td>
<td>사이즈</td>
</tr>
<c:forEach var="coffee" items="${requestScope.coffeelist}">
<tr>
<td>${coffee.name}</td>
<td>${coffee.price}</td>
<td>${coffee.size}</td>
</tr>
</c:forEach>
</table>
</body>
</html>