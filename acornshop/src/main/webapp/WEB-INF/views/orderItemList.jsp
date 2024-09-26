<%@page import="model.OrderItem"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>주문 목록</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- 메뉴바 -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/acornshop/login">Acorn Shop</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/acornshop/product">Shop</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/acornshop/users">Users</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/acornshop/mypage">My Page</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/acornshop/orders">Orders</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

	<div class="container mt-5">
	    <h2 class="text-center mb-4">주문 목록</h2>
	    <table class="table table-hover table-bordered">
	        <thead class="table-dark">
	            <tr>
	                <th>주문번호</th>
	                <th>주문자</th>
	                <th>상품명</th>
	                <th>수량</th>
	                <th>사이즈</th>
	                <th>주문일자</th>
	                <th>가격</th>
	                <th>리뷰 작성</th>
	            </tr>
	        </thead>
			<tbody>
				<%
				ArrayList<OrderItem> list = (ArrayList<OrderItem>)request.getAttribute("list");
				for (OrderItem item : list) {
				%>
				<tr>
					<td><%= item.getOrder_id() %></td>
					<td><%= item.getUser_id() %></td>
					<td><%= item.getProduct_name() %></td>
					<td><%= item.getQuantity() %></td>
					<td><%= item.getItem_size() %></td>
					<td><%= item.getOrder_date() %></td>
					<td><%= item.getAmount() %></td>
					<td><button class="btn btn-primary" type="button" onclick="location.href = '/acornshop/newReview?userid=<%= item.getUser_id() %>&productno=<%= item.getProduct_no() %>&productname=<%= item.getProduct_name() %>&itemno=<%= item.getItem_no() %>'">작성</button></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	
	<!-- Bootstrap JS and Popper.js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>