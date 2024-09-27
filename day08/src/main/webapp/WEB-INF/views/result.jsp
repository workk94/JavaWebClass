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
// 세션에 저장한 데이터 꺼내오기

String s1 = (String) session.getAttribute("survey1");
String s2 = (String) session.getAttribute("survey2");
%>

<h2>설문결과</h2>
<p>당신이 좋아하는 꽃 : <%=s1 %></p>
<p>당신이 좋아하는 동물 : <%=s2 %> </p>
</body>
</html>