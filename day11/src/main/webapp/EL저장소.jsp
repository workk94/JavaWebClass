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
<h2>jsp에서 사용할 수 있는 저장소</h2>

<ul>
<li>pageContext</li>
<li>request</li>
<li>session</li>
<li>application</li>
</ul>

<h2>EL문법 : 저장소에 있는 값들을 쉽게 사용할 수 있도록 해줌</h2>

<% pageContext.setAttribute("data", "hello EL"); %>

${data}

<% request.setAttribute("data2", "hello data"); %>

<% String result = (String) request.getAttribute("data2"); %>

<%= result %>

${data2 }

<h2>pageContext -> request -> session -> application</h2>
<% pageContext.setAttribute("userId", "hong pageContext"); %>
<% request.setAttribute("userId", "hong request"); %>
<% session.setAttribute("userId", "hong session"); %>
<% application.setAttribute("userId", "hong application"); %>

<h2> userId 값 확인하기</h2>
${userId }

<h2> 각각의 저장소에서 값 꺼내오기</h2>
${sessionScope.userId }
${requestScope.userId }
${applicationScope.userId }
${pageScope.userId }
</body>
</html>