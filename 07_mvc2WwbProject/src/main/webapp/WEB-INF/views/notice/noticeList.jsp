<%@page import="kr.or.iei.notice.model.vo.NoticePageData"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.iei.notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
    String pageNavi = (String)request.getAttribute("pageNavi");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	
	<div class="page-content">
		<div class="page-title">공지사항</div>
		<%if(member != null && member.getMember_level() == 1) {%>
			<a class="btn bc4 writenBTn" href="/noticeWriterFrm.do">글쓰기</a>
		<%} %>
		<table class="tbl tbl-hover notice-tbl">
			<tr class="tr-2">
				<td style="width:10%">번호</td>
				<td style="width:45%">제목</td>
				<td style="width:15%">작성자</td>
				<td style="width:20%">작성일</td>
				<td style="width:10%">조회수</td>
			</tr>
			<%for(Notice n : list) {%>
			<tr class="tr-1">
				<td><%=n.getNotice_no() %></td>
				<td>
					<a href="/noticeView.do?noticeNo=<%=n.getNotice_no() %>"><%=n.getNotice_title() %></a> <%-- 번호를 이용해서 notice상세페이지 들어가기 --%>
				</td>
				<td><%=n.getNotice_writer() %></td>
				<td><%=n.getReg_date() %></td>
				<td><%=n.getRead_count() %>
			</tr>
			
			<%} %>
		</table>
		<div class="pageNavi"><%=pageNavi %></div>
	</div>
	
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>