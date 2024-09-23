<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}

.container {
	width: 500px;
	border: 1px solid black;
	margin: 0 auto;
}

.container_title {
	border: 1px solid black;
	text-align: center;
}

.container ul {
	padding: 0;
	margin: 0;
}

.container li {
	list-style: none;
}

.container_item {
	width: 400px;
	margin: 10px auto;
	padding: 20px;
	border: 1px solid black;
	display: flex;
	justify-content: space-between;
}
</style>
</head>
<body>

	<div class="container">
		<div class="container_title">
			<h2>todoList</h2>
		</div>
		<%
		ArrayList<String> result = (ArrayList<String>) request.getAttribute("list");
		%>

		<ul>

			<%
			for (String s : result) {
			%>
			<li><div class="container_item">
					<%
					out.println(s);
					%><button class="delBtn">삭제</button>
				</div></li>
			<%
			}
			%>
		
	</div>

	</ul>

	<script>
let delBtns = document.querySelectorAll('.delBtn');
delBtns.forEach((btn, index) => {
    btn.addEventListener('click', () => {
        let item = btn.closest('.container_item');
        item.style.display = 'none';
    });
});
</script>
</body>
</html>