<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#noticeWrite td, #noticeWrite th{
		border : 1px solid #ccc;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<script src="/summernote/summernote-lite.js"></script>
   	<script src="/summernote/lang/summernote-ko-KR.js"></script>
   	<link rel="stylesheet" href="/summernote/summernote-lite.css">
	
	
	<div class="page-content">
		<div class="page-title">에디터 작성</div>
		<form action="/noticeWrite.do" method="post" enctype="multipart/form-data"> <%-- method="post" enctype="multipart/form-data" : 첨부파일 필수! --%>
			<table class="tbl" id="noticeWrite">
				<tr class="tr-1">
					<th class="td-3">제목</th>
					<td colspan="3">
						<input type="text" name="noticeTitle" class="input-form">
					</td>
				</tr>
				
				<tr class="tr-1">
					<th class="td-3">작성자</th>
					<td>
					<%=member.getMember_id() %>
					<input type="hidden" name="noticeWriter" value="<%=member.getMember_id() %>">
					</td>
					
					<th class="td-3">첨부파일</th>
					<td>
						<input type="file" name="upfile">
					</td>
				</tr>
				
				<tr class="tr-1">
					<td colspan="4" style="text-align:left;">
						<textarea id="noticeContent" name="noticeContent" class="input-form"></textarea>
					</td>
				</tr>
				
				<tr>
					<td colspan="4">
						<button type="submit" class="btn bc1 bs4">공지사항 작성</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	<script>
      $("#noticeContent").summernote({
         height: 400,
         lang: "ko-KR",
         callbacks :{
        	 onImageUpload : function(files){
        		 uploadImage(files[0], this);
        	 }
         }
      });
      
      function uploadImage(files, editor){
    	  // ajax통해서 서버에 이미지를 업로드
    	  // 업로드된 이미지의 경롤르 받아오는 역할
    	  // <form>태그와 동일한 효과를 발생시킬 수 있는 객체
    	  const form = new FormData();
    	  form.append("file", files);
    	  $.ajax({
    		  url : "/uploadImage.do",
    		  type : "post",
    		  data : form,
    		  processData : false,
    		  contentType : false,
    		  success : function(data){
    			  $(editor).summernote("insertImage", data);
    			  console.log(data);
    		  }
    	  });
    	  // processData : 전송하는 데이터를 문자열로 전송하게 기본값이 설정되어있음
    	  					// ->파일전송을 위해 기본값 제거하는 작업
    	  // contentType : enctype="alpplication/x-www-form-urlencode;charset=UTF-8";
      }
   </script>
	
</body>
</html>




















