<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- 해당 클래스에서 사용하고싶은 클래스를 import할때 지시자태그 사용 --%>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>지시자태그</h1>
	<hr>
	<h3>JSP페이지 전체에 영향을 미치는 정보를 기술할 때 사용하는 태그</h3>
	<%-- 작성된 jsp파일을 해당 페이지로 포함시키는 기능 --%>
	<%-- 파일을 끼워넣는 용도로 많이 사용됨 --%>
	<%@ include file = "/jsp/test.jsp" %>
	<h3>테스트</h3>
	<button onclick="func1();">클릭</button>
</body>
</html>