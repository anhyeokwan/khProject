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
 * Servlet implementation class FindIdServlet
 */
@WebServlet(name = "findId", urlPatterns = "/findId.do")
public class FindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 인코딩하기
		request.setCharacterEncoding("utf-8");
		
		// 2. 값추출하기
		String memberId = request.getParameter("findId");
		
		// 3. 비즈니스 로직 만들기
		MemberService service = new MemberService();
		Member member = service.findMember(memberId);
		
		// 4. 화면에 나타내기
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>회원아이디검색</title></head>");
		out.println("<body>");
		out.println("<h1>회원아이디검색</h1>");
		if(member == null) {
			out.println("<h1>아이디 없음</h1>");
		} else {
			out.println("<ul>");
			out.println("<li>회원번호 : " + member.getMember_no() + "</li>");
			out.println("<li>아이디 : " + member.getMember_id() + "</li>");
			out.println("<li>비밀번호 : " + member.getMember_pw() + "</li>");
			out.println("<li>이름 : " + member.getMember_name() + "</li>");
			out.println("<li>전화번호 : " + member.getMember_phone() + "</li>");
			out.println("<li>주소 : " + member.getMember_addr() + "</li>");
			out.println("<li>등급 : " + member.getMember_level() + "</li>");
			out.println("<li>가입일자 : " + member.getEnroll_date() + "</li>");
			out.println("</ul>");
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














