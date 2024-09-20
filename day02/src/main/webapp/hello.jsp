<!-- page 지시자 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, td {
		border: 1px, solid black;
	}
</style>
</head>
<body>
<!-- 스크립트 -->
<% // 자바코드 작성
	//requset, response, out 내장객체 
	int sum = 0;
	
	for(int i = 0; i <= 10; i++){
		sum += i;
	}
	out.println(sum);
%>

<!-- 표현식 -->
<%= sum %>

<table>
<tr>
<td><%= sum %></td>
</tr>
</table>

</body>
</html>