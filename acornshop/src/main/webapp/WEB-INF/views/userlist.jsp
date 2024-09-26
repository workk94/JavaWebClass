<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>유저 목록</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<!-- 메뉴바 -->
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="/acornshop/login">Acorn Shop</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="/acornshop/product">Shop</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/acornshop/users">Users</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/acornshop/mypage">My page</a></li>
	                <li class="nav-item">
	                    <a class="nav-link" href="/acornshop/orders">Orders</a>
	                </li>
				</ul>
			</div>
		</div>
	</nav>
	
	<!-- 유저 목록 -->
	<div class="container mt-5">
		<h2 class="text-center mb-4">회원 목록</h2>
		<table class="table table-hover table-bordered">
			<thead class="table-dark">
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>주소</th>
					<th>성별</th>
					<th>키(cm)</th>
					<th>몸무게(kg)</th>
				</tr>
			</thead>
			<tbody>
				<%
				ArrayList<User> list = (ArrayList<User>) request.getAttribute("list");
				for (User user : list) {
				%>
				<tr>
					<td><%=user.getId()%></td>
					<td><%=user.getName()%></td>
					<td><%=user.getPhone()%></td>
					<td><%=user.getAddress()%></td>
					<%if(user.getGender() == null) {%>
						<td><%="" %></td>
					<% } else {%> 
						<td><%=user.getGender().equals("M") ?  "남자" : "여자"%></td>
					<%} %>
					<%
						String height = String.valueOf(user.getHeight());
						String weight = String.valueOf(user.getWeight());
					%>
					<td><%=height.equals("0") ? "" : height%></td>
					<td><%=weight.equals("0") ? "" : weight%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>

	<!-- Bootstrap JS and Popper.js -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
