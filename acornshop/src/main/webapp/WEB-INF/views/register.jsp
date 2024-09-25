<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<h2 class="card-title text-center mb-4">에이콘샵 회원가입</h2>
						<form action="/acornshop/register" method="post">
							<%
							String result = (String) request.getAttribute("isUserExist");
							if (result != null)
								out.println("<div class='alert alert-warning'>" + result + "</div>");
							%>
							<div class="mb-3">
								<label for="id" class="form-label">아이디</label> <input
									type="text" class="form-control" id="id" name="id" required>
							</div>
							<div class="mb-3">
								<label for="name" class="form-label">이름</label> <input
									type="text" class="form-control" id="name" name="name" required>
							</div>
							<div class="mb-3">
								<label for="pw" class="form-label">비밀번호</label> <input
									type="password" class="form-control" id="pw" name="pw" required>
							</div>
							<div class="mb-3">
								<label for="phone" class="form-label">전화번호</label> <input
									type="text" class="form-control" id="phone" name="phone"
									required>
							</div>
							<div class="mb-3">
								<label for="addr" class="form-label">주소</label> <input
									type="text" class="form-control" id="addr" name="addr">
							</div>
							<div class="mb-3">
								<label class="form-label">성별</label><br>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="gender"
										id="male" value="M" required> <label
										class="form-check-label" for="male">남자</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="gender"
										id="female" value="F"> <label class="form-check-label"
										for="female">여자</label>
								</div>
							</div>
							<div class="mb-3">
								<label for="height" class="form-label">키</label> <input
									type="text" class="form-control" id="height" name="height">
							</div>
							<div class="mb-3">
								<label for="weight" class="form-label">몸무게</label> <input
									type="text" class="form-control" id="weight" name="weight">
							</div>
							<div class="d-grid">
								<button type="submit" class="btn btn-dark" id="regBtn">회원가입</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
    const regBtn = document.querySelector("#regBtn");
    regBtn.addEventListener("click", (event) => {
        let phone = document.querySelector("#phone").value;
        let height = document.querySelector("#height").value;
        let weight = document.querySelector("#weight").value;
        if(phone == ""){
        	alert("전화번호를 입력해주세요");
        } else if (!validatePhoneNumFormat(phone)) {
            event.preventDefault();
            alert("잘못된 전화번호 형식입니다. 올바른 형식: 010-xxxx-xxxx");
        } else if(height == ""){
        	event.preventDefault();
        	alert("키를 입력해주세요");
        } else if(weight == ""){
        	event.preventDefault();
        	alert("몸무게를 입력해주세요");
        } else if (!(onlyNumber(weight) && onlyNumber(height))) {
            event.preventDefault();
            alert("키와 몸무게는 숫자만 입력 가능합니다.");
        }
    });

    // 숫자만 허용하는 함수 (키, 몸무게 검사)
    function onlyNumber(str) {
        return /^[0-9]*$/.test(str);
    }

    // 핸드폰 번호 형식 검사 (010-xxxx-xxxx 형식)
    function validatePhoneNumFormat(phone) {
        return /^010-[0-9]{4}-[0-9]{4}$/.test(phone);
    }

    </script>

	<!-- Bootstrap JS and Popper.js -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
