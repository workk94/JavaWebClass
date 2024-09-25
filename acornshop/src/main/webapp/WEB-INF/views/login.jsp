<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h2 class="card-title text-center mb-4">로그인</h2>
                        <form action="/acornshop/login" method="post">
                            <div class="mb-3">
                                <label for="id" class="form-label">아이디</label>
                                <input type="text" class="form-control" id="id" name="id" required>
                            </div>
                            <div class="mb-3">
                                <label for="pw" class="form-label">비밀번호</label>
                                <input type="password" class="form-control" id="pw" name="pw" required>
                            </div>
                            <div class="d-grid">
                                <button type="submit" class="btn btn-dark" id="loginBtn">로그인</button>
                            </div>
                        </form>
                        <div class="text-center mt-3">
                            <a href="/acornshop/register" class="link-primary">회원가입</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

    <script>
        const loginBtn = document.querySelector("#loginBtn");
        loginBtn.addEventListener("click", (event) => {
            const id = document.querySelector("#id").value;
            const pw = document.querySelector("#pw").value;
            if (id === "" || pw === "") {
                alert("아이디와 비밀번호를 입력해주세요.");
                event.preventDefault();
            } else {
                alert("로그인 성공");
            }
        });
    </script>
</body>
</html>
