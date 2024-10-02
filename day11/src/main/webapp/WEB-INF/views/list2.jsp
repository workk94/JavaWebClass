<%@ page import="day11.Acorn"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="day11.PageHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시판 글 목록</h2>

<div></div>

<h2>페이징 관련 데이터</h2>

<!-- 이전 -->
<c:if test="${handler.currentGrp > 1}">
    [<a href="/day11/list?p=${handler.grpStartPage - 1}">이전</a>]
</c:if>

<!-- 페이지 번호 링크 -->
<c:forEach var="i" begin="${handler.grpStartPage}" end="${handler.grpEnpPage}">
    [<a href="/day11/list?p=${i}">${i}</a>]
</c:forEach>

<!-- 다음 -->
<c:if test="${handler.totalPage > handler.grpEnpPage + 1}">
    [<a href="/day11/list?p=${handler.grpEnpPage + 1}">다음</a>]
</c:if>

</body>
</html>
