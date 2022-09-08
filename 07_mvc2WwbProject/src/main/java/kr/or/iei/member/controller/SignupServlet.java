package kr.or.iei.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet(name = "Signup", urlPatterns = { "/signup.do" })
public class SignupServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //1.인코딩
      request.setCharacterEncoding("utf-8");
      //2.값추출
      String memberId = request.getParameter("memberId");
      String memberPw = request.getParameter("memberPw");
      String memberName = request.getParameter("memberName");
      String memberPhone = request.getParameter("memberPhone");
      String memberAddr = request.getParameter("memberAddr");
      Member m = new Member();
      m.setMember_id(memberId);
      m.setMember_pw(memberPw);
      m.setMember_name(memberName);
      m.setMember_phone(memberPhone);
      m.setMember_addr(memberAddr);
      //3. 비즈니스로직
      MemberService service = new MemberService();
      int result = service.insertMember(m); 
      //4. 결과처리
      RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
      if(result>0) { //성공 
         request.setAttribute("title", "회원가입성공");
         request.setAttribute("msg", "WELCOME!");
         request.setAttribute("icon", "success");
      }else { //실패 
         request.setAttribute("title", "회원가입실패");
         request.setAttribute("msg", "관리자에게 문의하세용가리");
         request.setAttribute("icon", "error");
      }
      request.setAttribute("loc","/"); // 둘다 실행하고 나면 메인화면으로 
      view.forward(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}