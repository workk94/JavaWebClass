<%@page import="day11.Acorn"%>
<%@page import="java.util.ArrayList"%>
<%@page import="day11.PageHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시판 글 목록</h2>
<% ArrayList<Acorn> list = (ArrayList<Acorn>)request.getAttribute("list"); %>

<%for ( Acorn acorn : list){ %>
<div><%=acorn.getId() %> <%=acorn.getPw()%> <%=acorn.getName()%></div>
<%} %>

<h2>페이징 관련 데이터</h2>

<%  PageHandler handler = (PageHandler) request.getAttribute("handler"); %>
<!-- 이전 -->
<% if(handler.getCurrentGrp() > 1) {%>
	<a href="/day11/list?p=<%=handler.getGrpStartPage()-1%>">[이전]</a>
<%} %>


<% for(int i= handler.getGrpStartPage(); i <= handler.getGrpEnpPage(); i++) {%>
	[<a href="/day11/list?p=<%=i%>"><%= i %></a>]
<%} %>

<!-- 다음 -->
<% if(handler.getTotalPage() > handler.getGrpEnpPage()) {%>
	[<a href="/day11/list?p=<%=handler.getGrpEnpPage() +1%>">다음</a>]
<%} %>

</body>
</html>