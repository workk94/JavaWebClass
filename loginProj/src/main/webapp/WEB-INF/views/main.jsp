<%@page import="loginProj.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
Member member =(Member)session.getAttribute("loginMember");
%>

<% if (member != null) { %>
<%=member.getNickname() %>님 반갑습니다
<a href="/loginProj/logout">로그아웃</a>
<% } else { 
	out.println("접근불가");
}
%>
</body>
</html>