package kr.or.iei.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet(name = "join", urlPatterns = {"/join.do"})
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public JoinServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		// 2. 값추출
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
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
		// 4. 결과처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>회원가입결과</title></head>");
		out.println("<body>");
		out.println("<h1>회원가입결과</h1>");
		out.println("<hr>");
		if(result>0) {//회원가입 성공
	         out.println("<h3>회원가입성공</h3>");
	         out.println("<a href = '/html/loginFrm.html'>로그인하러가기</a>");
	      }else { //회원가입실패
	         out.println("<h3>회원가입실패</h3>");
	         out.println("<a href = '/'>메인페이지로이동</a>");
	      }
		
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
