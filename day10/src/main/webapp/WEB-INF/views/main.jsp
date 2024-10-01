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
<c:choose>
<c:when test="${loginMember != null}">
${loginMember.name} 님 환영합니다
<a href="/day10/logout">로그아웃</a>
</c:when>
<c:otherwise>
<a href="/day10/login">로그인</a>
</c:otherwise>
</c:choose>
</body>
</html>