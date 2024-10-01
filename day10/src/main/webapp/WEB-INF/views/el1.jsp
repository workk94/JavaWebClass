<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>자바 코드로 작성</h2>
<% String data = (String) request.getAttribute("data"); %>
<%= data %>

<h2>EL사용하기</h2>
${data}

<h2>EL 사용못하는 경우 : 저장소에 있는 것만 EL사용가능</h2>

<% String str = "나도 EL쓰고 싶어"; %>
<%=str %>


<h2>EL 사용시도 : 출력되지 않음 <h2>
${str }



<h2>EL 사용시도 : 저장소 이용</h2>
<h2>저장소 알아보기</h2>
<ul>
<li>pageContext</li>
<li>request</li>
<li>session</li>
<li>application</li>
</ul>

<% pageContext.setAttribute("str", str) ;%>

${str}
</body>
</html>