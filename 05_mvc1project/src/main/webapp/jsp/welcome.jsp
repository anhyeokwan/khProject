<%@page import="kr.or.iei.member.model.service.MemberService"%>
<%@page import="kr.or.iei.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	// 1.인코딩
    	request.setCharacterEncoding("utf-8");
    
    	// 2. 값추출
    	String memberId = request.getParameter("memberId");
    	String memberPw = request.getParameter("memberpw");
    	String memberName = request.getParameter("memberName");
    	String memberPhone = request.getParameter("memberPhone");
    	String memberAddr = request.getParameter("memberAddr");
    	
    	Member member = new Member();
    	member.setMember_id(memberId);
    	member.setMember_pw(memberPw);
    	member.setMember_name(memberName);
    	member.setMember_phone(memberPhone);
    	member.setMember_addr(memberAddr);
    	
    	// 3. 비즈니스 로직
    	MemberService service = new MemberService();
    	int result = service.insertMember(member);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WelCome!</h1>
	<hr>
	<% if(result > 0){ %>
	<h1>회원가입 성공!</h1>
	<%} else{ %>
	<h1>회원가입 실패</h1>
	<%} %>
</body>
</html>



























