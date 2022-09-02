<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>표현식 태그</h1>
	<hr>
	<h3>자바의 데이터를 HTML 컨텐츠로 표현하기 위해 사용하는 태그</h3>
	<% int age = 20;
		ArrayList<String> list = new ArrayList<String>();
		list.add("안형관1");
		list.add("안형관2");
		list.add("안형관3");
		list.add("안형관4");
		list.add("안형관5");
	%>
	<% if(age > 19){ %>
		<h3><%=age %>살은 성인</h3>
	<% } else { %>
		<h3<%=age %>>살은 미성년자</h3>
	<% } %>
	<hr>
	<% for(int i = 0; i < list.size(); i++){ %>
		<h3><%=i %>_<%=list.get(i) %></h3>
	<%} %>
</body>
</html>