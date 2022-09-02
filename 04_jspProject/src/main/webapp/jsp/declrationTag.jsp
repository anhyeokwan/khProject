<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>선언식 태그</h1>
	<hr>
	<h3>jsp로 생성되는 클래스의 전역변수 및 추가메소드를 생성하는 태그</h3>
	<%!
		private int count = 10;
		public String addCount(){
			count++;
			return "카운트 증가 완료";
		}
	%>
	
	<h3><%=count %></h3>
	<h3><%=addCount() %></h3>
	<h3><%=count %></h3>
</body>
</html>