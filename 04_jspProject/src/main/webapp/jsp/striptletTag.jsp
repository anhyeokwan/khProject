<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>스트립틀릿태그</h1>
	<hr>
	<h3>_jspService 메소드의 수행내용을 작성할 때 사용</h3>
	<%-- 자바코드를 사용하기 위해서 사용 --%>
	<%
		int age = 20;
	%>
	<% if(age > 20){ %>
	<p>성인</p>
	<%} else { %>
		<p>미성년자</p>
		<%} %>
	
</body>
</html>