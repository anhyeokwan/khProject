<%@page import="kr.or.iei.photo.model.vo.Photo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	int totalCount = (int)request.getAttribute("totalCount");
    	Photo photo = (Photo)request.getAttribute("photo");
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
		<div class="page-title">사진게시판 <%=totalCount %></div>
		
		<%if(member != null){ %>
			<a href="/photoWriterFrm.do" class="btn bc4">글쓰기</a>
		<%} %>
		
		<div class="photoWrapper posting-wrap">
			
		</div>
		<button class="btn bc44 bs4" id="more-btn" totalCount="<%=totalCount%>" currentCount="0" value="1">더보기</button>
		<%-- 
			totalCount : 전체 게시물 수
			currentCount : 실제 jsp에 가지고 온 게시물
			value : 더보기 요청시 다음 게시물 시작번호
		--%>
		
	</div>
	
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<script type="text/javascript">
		$("#more-btn").on("click", function(){
			const amount = 5; // 더보기 클릭시 추가로 가져올 게시물 수
			const start = $(this).val(); // 추가로 가져올 게시물 시작번호
			
			$.ajax({
				url : "/photoMore.do",
				type : "post",
				data : {start : start, amount : amount},
				success : function(data){
					
					for(let i = 0; i < data.length; i++){
						const p = data[i];
						const div = $("<div>");
						div.addClass("posting-item");
						
						const imgDiv = $("<div>");
						imgDiv.addClass("posting-img");
						
						const img = $("<img>");
						img.attr("src", "/upload/photo/" + p.filepath); // 경로를 설정해줌
						
						imgDiv.append(img);
						
						const titleDiv = $("<div>");
						titleDiv.addClass("posting-content");
						
						const title = $("<p>");
						title.append(p.photoTitle);
						
						titleDiv.append(title);
						
						div.append(imgDiv).append(titleDiv);
						
						$(".photoWrapper").append(div);
					}
					// 화면 추가완료 후 다음 더보기를 위한 값 수정
					// value를 증가 -> 기존 value + amount
					$("#more-btn").val(Number(start) + Number(amount));
					// currentCount값도 읽어온 만큼 수정
					const currentCount = Number($("#more-btn").attr("currentCount")) + data.length;
					$("#more-btn").attr("currentCount", currentCount);
					
					const totalCount = $("#more-btn").attr("totalCount");
					if(totalCount == currentCount){
						$("#more-btn").attr("disabled", true);
						$("#more-btn").css("cursor", "not allowed");
					}
				}, 
				error : function(){
					console.log("에러발생");
				}
			})
		});
		
		$("#more-btn").click();
	</script>
</body>
</html>


























