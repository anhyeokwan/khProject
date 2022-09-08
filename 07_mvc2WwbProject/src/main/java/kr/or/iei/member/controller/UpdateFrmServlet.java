package kr.or.iei.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class UpdateFrmServlet
 */
@WebServlet(name="updateFrm", urlPatterns = {"/updateMember.do"})
public class UpdateFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFrmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 2. 값추출
		String memberPw = request.getParameter("memberPw");
		String memberPhone = request.getParameter("memberPhone");
		String memberAddr = request.getParameter("memberAddr");
		// 정보수정을 위한 조건절 작성을 위해 memberNo가 필요
		// 로그인 세션에서 회원 정보를 가져옴
		HttpSession session = request.getSession(false);
		Member m = (Member)session.getAttribute("m");
		String memberId = m.getMember_id();
		Member member = new Member();
		member.setMember_pw(memberPw);
		member.setMember_phone(memberPhone);
		member.setMember_addr(memberAddr);
		member.setMember_id(memberId);
		
		// 3. 비즈니스 로직
		MemberService service = new MemberService();
		int result = service.updateMember(member);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			// 수정 성공 시 세션의 정보를 변경데이터로 업데이트
			m.setMember_pw(memberPw);
			m.setMember_phone(memberPhone);
			m.setMember_addr(memberAddr);
			request.setAttribute("title", "정보수정성공");
	        request.setAttribute("msg", "Fresh!");
	        request.setAttribute("icon", "success");
	        
		} else {
			request.setAttribute("title", "정보수정실패");
	        request.setAttribute("msg", "hey!");
	        request.setAttribute("icon", "fail");
		}
		request.setAttribute("loc", "/mypage2.do?memberId=" + m.getMember_id()); // ?는 파라미터 구분자
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
