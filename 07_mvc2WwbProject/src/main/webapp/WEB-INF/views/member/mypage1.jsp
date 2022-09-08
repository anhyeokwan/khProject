<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.input-wrap{
		padding : 15px;
	}
	
	.input-wrap>label{
		font-size:1.1em;
		margin-bottom : 10px;
		display : block;
	}
	
	[name=updateFrm] .btn{
		text-align: center;
		margin-top: 30px;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	
	<div class="page-content">
		<div class="page-title">회원가입</div>
		
		<form action="/updateMember.do" method="post" name="updateFrm">
			
			<input type="hidden" name="memberNo" value="<%=member.getMember_no() %>">
			
			<div class="input-wrap">
				<label for="memberId">아이디</label>
				<input type="text" name="memberId" id="memberId" class="input-from" value="<%=member.getMember_id() %>" readonly>
			</div>
			
			<div class="input-wrap">
				<label for="memberPw">비밀번호</label>
				<input type="password" name="memberPw" id="memberPw" class="input-from" value="<%=member.getMember_pw() %>">
			</div>
			
			<div class="input-wrap">
				<label for="memberName">이름</label>
				<input type="text" name="memberName" id="memberName" class="input-from" value="<%=member.getMember_name() %>" readonly>
			</div>
			
			<div class="input-wrap">
				<label for="memberPhone">전화번호</label>
				<input type="text" name="memberPhone" id="memberPhone" class="input-from" value="<%=member.getMember_phone() %>">
			</div>
			
			<div class="input-wrap">
				<label for="memberAddr">주소</label>
				<input type="text" name="memberAddr" id="memberAddr" class="input-from" value="<%=member.getMember_addr() %>">
			</div>
			
			<div class="input-wrap">
				<label for="memberLevel">등급</label>
				<% if(member.getMember_level() == 1){ %>
					<input type="text" name="memberLevel" id="memberLevel1" class="input-from" value="관리자" readonly>
				<%} else if(member.getMember_level() == 2){ %>
					<input type="text" name="memberLevel" id="memberLevel2" class="input-from" value="정회원" readonly>
				<% }else if(member.getMember_level() == 3) {%>
					<input type="text" name="memberLevel" id="memberLevel3" class="input-from" value="준회원" readonly>
				<%} %>
				
			</div>
			
			<div class="input-wrap">
				<label for="enrollDate">가입일자</label>
				<input type="text" name="enrollDate" id="enrollDate" class="input-from" value="<%=member.getEnroll_date() %>" readonly>
			</div>
			
			<div class="btn-box">
				<button type="submit" class="btn">정보수정</button>
			</div>
		</form>
	</div>
	
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>


















