<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 2. 값 추출
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		
		// 3. 비즈니스 로직
		
		
		// 4. 결과처리
	%>
	
	<h2><%=data1 %></h2>
	<h2><%=data2 %></h2>
</body>
</html>