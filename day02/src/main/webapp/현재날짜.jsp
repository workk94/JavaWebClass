<%@ page import="java.util.Date" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Date d = new Date();
	out.println(d);
	%>
	<h1>오늘의 날짜!!!</h1>

	<table>
		<tr>
			<td><%=d%></td>
		</tr>
	</table>
</body>
</html>