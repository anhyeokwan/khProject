<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form action="/jsp/welcome.jsp" method="post">
		<fieldset>
			<legend>회원가입</legend>
			<label for="memberId">아이디</label>
			<input type="text" name="memberId" id="memberId"><br>
			
			<label for="memberpw">비밀번호</label>
			<input type="password" name="memberpw" id="memberpw"><br>
			
			<label for="memberName">이름</label>
			<input type="text" name="memberName" id="memberName"><br>
			
			<label for="memberPhone">전화번호</label>
			<input type="text" name="memberPhone" id="memberPhone"><br>
			
			<label for="memberAddr">주소</label>
			<input type="text" name="memberAddr" id="memberAddr"><br>
			
			<input type="submit" value="회원가입">
		</fieldset>
	</form>
</body>
</html>