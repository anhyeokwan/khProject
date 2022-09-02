<%@page import="kr.or.iei.member.model.vo.Member"%>
<%@page import="kr.or.iei.member.model.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	// 1. 인코딩
    	request.setCharacterEncoding("utf-8");
    	
    	// 2. 값추출
    	String memberId = request.getParameter("memberId");
    	
    	// 3. 비즈니스 로직
    	MemberService service = new MemberService();
    	Member member = service.findMember(memberId);
    	
    	// 4. 결과처리
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(member == null){ %>
		<h1>조회하는 회원이 없습니다.</h1>
	<%} else{ %>
		<ul>
        <li>회원번호 : <%= member.getMember_no() %></li>
        <li>아이디 : <%=member.getMember_id() %></li>
        <li>비밀번호 : <%=member.getMember_pw() %></li>
        <li>이름 : <%=member.getMember_name() %></li>
        <li>전화번호 : <%=member.getMember_phone() %></li>
        <li>주소 : <%=member.getMember_addr() %></li>
        <li>가입일자 : <%= member.getEnroll_date() %></li>
    </ul>
	<%} %>
</body>
</html>