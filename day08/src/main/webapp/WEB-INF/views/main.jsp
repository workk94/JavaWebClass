<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 로그인 여부에 따른 내용이 다르게 응답하기 -->

<% 
//세션저장소 얻기(각 클라이언트가 사용하는 세션저장소를 얻어온다)
//세션저장소 저장한 key 얻어오기

String id = (String)session.getAttribute("loginId");

%>


<% if(id == null) { %>
<!-- 로그인 안하면 -->
<a href="/day08/loginex">로그인</a>
<%} else { %>
<!-- 로그인 성공하면 -->
<%=id %>님 반갑습니다^^
<a href="/day08/logoutex">로그아웃</a>
<%} %>

<a href="/day08/orderex">주문하기</a>
</body>
</html>