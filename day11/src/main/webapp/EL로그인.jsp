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
로그인 로그아웃 

<h2> 세션처리</h2>

<% session.setAttribute("uesrId", "acorn1"); %>

<% String id = (String)session.getAttribute("userId"); 
	if(id == null){
%>
<a href="#">로그인</a>
<% } else {%>
<a href="#">로그아웃</a>
<% }%>

<h2>EL JSTL</h2>

<c:if test="${empty userId }"> <a href="#">로그인</a> </c:if>
<c:if test="${not empty userId }"> <a href="#">로그아웃</a> </c:if>

<c:choose>
	<c:when test="${empty userId }"><a href="#">로그인</a></c:when>
	<c:otherwise><a href="#">로그아웃</a></c:otherwise>
</c:choose>
</body>
</html>