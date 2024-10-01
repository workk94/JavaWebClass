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
<form action="/day10/login" method="post">

<div>
<label for="id">아이디</label>
<input type="text" name="id" />
</div>
<div>
<label for="password">패스워드</label>
<input type="password" name="password" />
</div>
<div>
<button>로그인</button>
</div>
</form>
</body>
</html>