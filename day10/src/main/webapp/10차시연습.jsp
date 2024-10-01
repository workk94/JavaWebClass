<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL, JSTL</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>

<h2>안녕하세요 출력</h2>
<c:set var="hello" scope="page" value="안녕하세요"></c:set>
<c:out value="${hello}"/>
<h2>1~10까지 출력</h2>
<c:forEach var="su" begin="1" end="10">
${su}
</c:forEach>

<% String str = "안녕하세요"; %>
<% pageContext.setAttribute("str", str); %>
<c:set var="str" value="안녕하살법"></c:set>
<h2>안녕하세요 5번 출력하기</h2>
<ol>
<c:forEach begin="1" end="5">
<li>${str}</li>
</c:forEach>
</ol>

<h2>성적 출력</h2>

<c:set  var="score" value="50"></c:set>
<c:choose>
<c:when test="${score >= 90}">A</c:when>
<c:when test="${score >= 80}">B</c:when>
<c:when test="${score >= 70}">C</c:when>
<c:otherwise>F</c:otherwise>
</c:choose>


<h2>좋아하는것 배열만들고 배열요소 출력하기</h2>
<% 
String[] menu = {"순두부찌개", "김치찌개", "덮밥"};
request.setAttribute("menu", menu);
%>
<ul>
<c:forEach var="dish" items="${menu}">
<li>${dish }</li>
</c:forEach>
</ul>


<h2>책이름 배열 출력</h2>
<% 
String[] bookNames = { "소설", "역사", "인문", "정치", "미술", "종교", "여행", "과학"}; 
pageContext.setAttribute("bookNames", bookNames);
%>
<c:forEach var="book" items="${bookNames}">
${book}
</c:forEach>


<h2>3단 출력</h2>
<c:set var="dan" value="3"></c:set>
<ul>
<c:forEach var="i" begin="1" end="9">
<li>${dan} x ${i } = ${dan * i}</li>
</c:forEach>
</ul>


<h2>전체 구구단</h2>
<c:forEach var="dan" begin="2" end="9">
<ul>
<c:forEach var="i" begin="1" end="9">
<li>${dan} x ${i } = ${dan * i}</li>
</c:forEach>
</ul>
</c:forEach>
</body>
</html>