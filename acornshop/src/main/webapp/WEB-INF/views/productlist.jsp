<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상품 목록</title>
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
	
	<!-- 상품 목록 -->
	<div class="container mt-5">
		<h2 class="text-center mb-4">상품 목록</h2>
		<table class="table table-hover table-bordered">
			<thead class="table-dark">
				<tr>
					<th>브랜드</th>
					<th>이름</th>
					<th>카테고리</th>
					<th>가격</th>
					<th>제품이미지</th>
				</tr>
			</thead>
			<tbody>
				<%
				ArrayList<Product> productList = (ArrayList<Product>) request.getAttribute("productList");
				for (Product product : productList) {
					String value = String.format("%,d", product.getPrice());
				%>
				<tr>
					<td><%=product.getBrand_name()%></td>
					<td><%=product.getProduct_name()%></td>
					<td><%=product.getCategory()%></td>
					<td><%=value + "원"%></td>
					<td><img src="<%=product.getImg_url()%>" alt="제품 이미지"
						class="img-fluid" style="max-width: 100px;"></td>
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
