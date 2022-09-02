<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>아이디로 회원 조회</h1>
	<hr>
	<form action="/jsp/searchId.jsp" method="get">
		<input type="text" name="memberId">
		<input type="submit" value="조회">
	</form>
</body>
</html>