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
<h2>EL 산술연산자</h2>

${5+3 }
${5-3 }

<h2>EL 관계연산</h2>

${5>2 }
${5<2 }

<% request.setAttribute("data","상품정보"); %>

${empty data }
${not empty data }

<h2>EL 삼항연산</h2>
<% session.setAttribute("id", "acorn1"); %>
${empty id ? "로그인" : "로그아웃"}
</body>
</html>