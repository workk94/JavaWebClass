<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



<link href="/modulePrj/css/header.css"   rel="stylesheet"  type="text/css">
<link href="<%=request.getContextPath()%>/css/footer.css"   rel="stylesheet"  type="text/css">

</head>
<body>

<!--  header -->
<jsp:include page="header.jsp" />
내용입니다.

<jsp:include page="banner.jsp" />

<!-- footer -->
<jsp:include page="footer.jsp" />
</body>
</html>