<%@page import="model.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>리뷰 수정하기</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4">리뷰 작성</h2>
        <form>
            <% Review review = (Review) request.getAttribute("review"); %>
            <div class="mb-3">
                <label for="content" class="form-label">리뷰 내용</label>
                <select name="rating" required>
                	<option value="1.0">1.0</option>
                	<option value="1.5">1.5</option>
                	<option value="2.0">2.0</option>
                	<option value="2.5">2.5</option>
                	<option value="3.0">3.0</option>
                	<option value="3.5">3.5</option>
                	<option value="4.0">4.0</option>
                	<option value="4.5">4.5</option>
                	<option value="5.0">5.0</option>
                </select>
                <textarea id="content" name="content" class="form-control" rows="8"></textarea>
            </div>
            <button type="button" class="btn btn-dark" onclick="createReview('<%= review.getReview_id() %>', '<%= review.getUser_id() %>', '<%= review.getProduct_no() %>', '<%= review.getProduct_name() %>', '<%= review.getItem_no() %>')">등록</button>
        </form>
    </div>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

    <script>
    function createReview(reviewId, userId, productNo, productName, itemNo) {
        let content = document.getElementById('content').value;
        let rating = document.querySelector('select[name="rating"]').value;
        location.href = '/acornshop/review/create?reviewid=' + reviewId + '&content=' + encodeURIComponent(content) + '&rating=' + rating + '&userid=' + userId + '&productno=' + productNo + '&productname=' + productName + '&itemno=' + itemNo;
    }
    </script>
</body>
</html>
