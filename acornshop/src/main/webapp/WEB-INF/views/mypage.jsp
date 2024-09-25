<%@page import="model.Review"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>나의 리뷰</title>
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
            </ul>
        </div>
    </div>
</nav>

<!-- 리뷰 테이블 -->
<div class="container mt-5">
    <h2 class="text-center mb-4">마이 페이지</h2>
    <table class="table table-hover table-bordered">
        <thead class="table-dark">
            <tr>
                <th>주문 아이디</th>
                <th>주문 품목</th>
                <th>리뷰</th>
                <th>별점</th>
                <th>리뷰 수정</th>
            </tr>
        </thead>
        <tbody>
            <% ArrayList<Review> list = (ArrayList<Review>)request.getAttribute("list");
               for (Review review : list) { %>
            <tr>
                <td><%= review.getReview_id() %></td>
                <td><%= review.getProduct_name() %></td>
                <td><%= review.getContent() %></td>
                <td><%= review.getRating() %> / 5</td>
                <td>
					<button class="btn btn-primary" type="submit">수정</button>
				</td>
            </tr>
            <% } %>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS and Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
