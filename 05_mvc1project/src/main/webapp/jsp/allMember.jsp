<%@page import="kr.or.iei.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.iei.member.model.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	// 1. 인코딩
    	request.setCharacterEncoding("utf-8");
    	
    	// 2. 값추출
    	
    	// 3. 비즈니스 로직
    	MemberService service = new MemberService();
    	ArrayList<Member> list = service.selectAllMember();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체 회원 조회</h1>
	<hr>
	<% if(list.isEmpty()){ %>
		<h3>회원 정보가 없습니다.</h3>
		<a href="/">메인페이지로 이동</a>
	<%} else { %>
		<table border="1">
        <tr>
            <th>회원번호</th>
            <th>아이디</th>
            <th>비밀번호</th>
            <th>이름</th>
            <th>전화번호</th>
            <th>주소</th>
            <th>등급</th>
            <th>가입날짜</th>
        </tr>
        <% for(Member m : list){ %>
        	<tr>
        		<td><%= m.getMember_no() %></td>
        		<td><%= m.getMember_id() %></td>
        		<td><%= m.getMember_pw() %></td>
        		<td><%= m.getMember_name() %></td>
        		<td><%= m.getMember_phone() %></td>
        		<td><%= m.getMember_addr() %></td>
        		<td><%= m.getMember_level() %></td>
        		<td><%= m.getEnroll_date() %></td>
        	</tr>
        <%} %>
    </table>
	<%} %>
</body>
</html>
















