<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String result = (String)request.getAttribute("fail"); %>
<form action="/loginProj/login" method="post">
아이디 : <input type="text" name="id">
비번 : <input type="password" name="pwd">
<button>로그인</button>
</form>
<script>
<% if(result != null){ %>
	let msg = "<%=result%>";
	alert(msg);
<%}%>
</script>
</body>
</html>