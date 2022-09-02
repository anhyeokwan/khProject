package kr.or.iei.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class AllMemberServlet
 */
@WebServlet(urlPatterns = {"/allMember.do"})
public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 2. 갑추출(넘어감)
		// 전송값이 없으므로 생략
		
		// 3. 비즈니스로직
		MemberService service = new MemberService();
		ArrayList<Member> list = service.selectAllMember(); 
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>전체 조회결과</title></head>");
		out.println("<body>");
		out.println("<h1>전체조회결과</h1>");
		out.println("<table border=\"1\">");
		out.println("<tr>");
		out.println("<th>회원번호</th>");
		out.println("<th>아이디</th>");
		out.println("<th>비밀번호</th>");
		out.println("<th>이름</th>");
		out.println("<th>전화번호</th>");
		out.println("<th>주소</th>");
		out.println("<th>등급</th>");
		out.println("<th>가입일자</th>");
		out.println("</tr>");
		for(Member m : list) {
			out.println("<tr>");
			out.println("<td>" + m.getMember_no() + "</td>");
			out.println("<td>" + m.getMember_id() + "</td>");
			out.println("<td>" + m.getMember_pw() + "</td>");
			out.println("<td>" + m.getMember_name() + "</td>");
			out.println("<td>" + m.getMember_phone() + "</td>");
			out.println("<td>" + m.getMember_addr() + "</td>");
			out.println("<td>" + m.getMember_level() + "</td>");
			out.println("<td>" + m.getEnroll_date() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
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


















