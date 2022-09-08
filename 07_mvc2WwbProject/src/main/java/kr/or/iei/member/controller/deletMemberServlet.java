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
 * Servlet implementation class deletMemberServlet
 */
@WebServlet(name="deleteMember", urlPatterns = {"/deletMember.do"})
public class deletMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		// 현재세션을 가져오지만 현재세션에 존재하는 값이 없으면 null(무조건 실패했다고 뜸)
		HttpSession session = request.getSession(false);
		Member member = (Member)session.getAttribute("m");
		
		String memberId = member.getMember_id();
		
		MemberService service = new MemberService();
		int result = service.deleteMember(memberId);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		if(result > 0) {
//			session.invalidate();
			request.setAttribute("title", "회원탈퇴성공");
	        request.setAttribute("msg", "quit!");
	        request.setAttribute("icon", "success");
	        request.setAttribute("loc", "/logout.do");
		} else {
			request.setAttribute("title", "회원탈퇴실패");
	        request.setAttribute("msg", "again");
	        request.setAttribute("icon", "fail");
	        request.setAttribute("loc", "/mypage2.do?=" + memberId);
		}
		
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
