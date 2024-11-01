<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	padding: 0px;
	margin: 0px;
}

.wrap {
	max-width: 500px;
	width: 100%;
	margin: 0 auto;
	box-sizing: border-box;
	padding: 20px;
	border: 1px solid black;
}

header {
	padding: 20px;
	border-radius: 5px;
	background-color: gainsboro;
	text-align: center;
	margin-bottom: 30px;
}

.todoEditWrap {
	display: flex;
	border: 1px solid gainsboro;
	margin-bottom: 50px;
	margin-top: 10px;
}

.todoEditWrap .todo_col {
	width: 80%;
}

.todoEditWrap .reg_col {
	width: 20%;
}

.todoEditWrap button {
	width: 100%;
	height: 60px;
	border: none;
}

.todoEditWrap  input {
	margin-top: 20px;
	padding-left: 20px;
	height: 30px;
	width: 100%;
	border: none;
	outline: none
}

.search {
	margin-top: 20px;
}

.search input {
	width: 100%;
	height: 40px;
}

.todoItemWrap {
	margin-top: 30px;
	border-top: 1px solid black;
	padding: 10px;
}

.todoItem {
	display: flex;
}

.title_col {
	width: 80%;
}

.btn_col  button {
	width: 80px;
	border-radius: 10px;
	height: 30px;
	border: none;
}
</style>
</head>
<body>
	<div class="wrap">

		<!-- header-->
		<header>
			<h2>오늘은 😊</h2>
			<div>Mon jan 02</div>
		</header>

		<!-- todo 작성 영역 -->
		<div class="todoEdit">
			<h4>새로운 todo 작성하기🖊</h4>
			<div class="todoEditWrap">
				<div class="todo_col">
					<input type="text" placeholder="일정추가">
				</div>
				<div class="reg_col">
					<button>등록</button>
				</div>
			</div>
		</div>

		<!-- todo list-->
		<div class="todoList">
			<h4>Todo List</h4>
			<!-- 검색영역-->
			<div class="search">
				<input type="text" placeholder="검색어를 입력하세요">
			</div>

			<!-- 일정 item 영역-->
			<div class="todoItemWrap">
				<!--item -->
				<div class="todoItem">
					<div class="checkbox_col">
						<input type="checkbox" />
					</div>
					<div class="title_col"></div>
					<div class="date_col"></div>
					<div class="btn_col">
						<button>삭제</button>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>