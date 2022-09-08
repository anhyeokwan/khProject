<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<style>
   .input-wrap{
      padding: 15px;
   }
   .input-wrap>label{
      font-size : 1.1em;
      margin-bottom : 10px;
      display: block;
   }
   .submit-btn{
      padding:15px;
      margin: 20px 0px;
   }
   .input-wrap>.id-wrap{
      display:flex;
   }
   .input-wrap>.id-wrap>#memberId{
      width:80%;
   }
   .input-wrap>.id-wrap>#idChkBtn{
      width:20%
   }
</style>

</head>
<body>
   <%@include file="/WEB-INF/views/common/header.jsp" %>
      <div class="page-content">
         <div class="page-title">회원가입</div>
         <form name="checkIdFrm" action="/checkId.do">
            <input type="hidden" name="checkId">
         </form>
         <form action="/signup.do" method="post">
            <div class="input-wrap">
               <label for="memberId">아이디<span id="ajaxCheckId"></span></label>
               <div class="id-wrap">
                  <input type="text" name="memberId" id="memberId" class="input-form">
                  <button type="button" id="idChkBtn" class="btn bc2">중복체크</button>
               </div>   
            </div>
            <div class="input-wrap">
               <label for = "memberPw">비밀번호</label>
               <input type="password" name="memberPw" id="memberPw" class="input-form">
            </div>
            <div class="input-wrap">
               <label for="memberName">이름</label>
               <input type="text" name="memberName" id="memberName" class="input-form">
            </div>
               <div class="input-wrap">
               <label for="memberPhone">전화번호</label>
               <input type="text" name="memberPhone" id="memberPhone" class="input-form">
            </div>
               <div class="input-wrap">
               <label for="memberAddr">주소</label>
               <input type="text" name="memberAddr" id="memberAddr" class="input-form">
            </div>
            <div class="submit-btn">
               <button type="submit" class="btn bc66 bs4">회원가입</button>
            </div>
         </form>
      </div>
      <script>
         $("#idChkBtn").on("click",function(){
            const memberId=$(this).prev().val(); // 버튼의 이전요소의 input 밸류값
            if(memberId == ""){ //아이디 입력하지 않고 중복체크 버튼 눌렀을때 
               alert("아이디를 입력하세요");
               return;
            }
            $("[name=checkId]").val(memberId); //위에 읽어온 id를 val에다가 넣어줌. 히든으로 숨겨놓음 
            const popup =  window.open("","checkId","left=700px, top=300px, width=300px, height=200px,menubar=no,scrollbars=yes");
                                 //빈, checkId는 창의 이름, 새로나온 창에 대한 속성 
            //새창에서 form을 전송하기 위한 연결작업
            $("[name=checkIdFrm]").attr("target","checkId");
            $("[name=checkIdFrm]").submit();
         });
      
      	$("[name=memberId]").on("change", function(){
      		const memberId = $(this).val();
      		// 유효성겁사먼저수행
      		// 유효성검사 통과하면 중복체크
      		$.ajax({
      			url : "/ajaxCheckId.do",
      			type : "get",
      			data : {memberId : memberId},
      			success : function(data){
      				if(data == "1"){
      					$("#ajaxCheckId").text("이미 사용중인 아이디입니다.");
      					$("#ajaxCheckId").css("color", "red");
      				} else if(data == "0"){
      					$("#ajaxCheckId").text("사용가능한 아이디입니다.");
      					$("#ajaxCheckId").css("color", "blue");
      				}
      			}
      		})
      	});
      </script>
      
   <%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>