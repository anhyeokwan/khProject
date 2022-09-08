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
 * Servlet implementation class SignInServlet
 */
@WebServlet(name = "SignIn", urlPatterns = {"/signin.do"})
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignInServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 2. 값추출
		String memberId = request.getParameter("signId");
		String memberPw = request.getParameter("signPw");
		Member member = new Member();
		member.setMember_id(memberId);
		member.setMember_pw(memberPw);
		
		// 3. 비즈니스 로직
		MemberService service = new MemberService();
		Member m = service.SelectOneMember(member);
		
		// 4. 결과처리
		// 4-1. 결과처리할 페이지를 지정
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(m != null) {
			
			// 로그인 성공한 경우
			// 회원등급확인해서 준회원이면 로그인 불가능
			// 정회원 또는 관리자면 로그인 처리
			if(member.getMember_level() == 3) {
				// 준회원 로그인 x
				request.setAttribute("title", "로그인 권한없음");
				request.setAttribute("msg", "로그인 권한이 없습니다. 관리자에게 문의하세요.");
				request.setAttribute("icon", "warning");
				request.setAttribute("loc", "/");
			} else {
				// 로그인 성공한 경우 -> 성공메세지 후 alert한 후 메인페이지 이동
				request.setAttribute("title", "로그인성공");
				request.setAttribute("msg", "환영합니다!");
				request.setAttribute("icon", "success");
				request.setAttribute("loc", "/");
				// 로그인을 성공하면 세션에 저장(브라우저가 닫기전까지 정보가 유지되게 하는것)
				HttpSession session = request.getSession();
				session.setAttribute("m", m);
			}
		} else {
			// 로그인 실패한 경우 -> 실패메세지 후 alert한 후 메인메세지 이동
			request.setAttribute("title", "로그인실패");
			request.setAttribute("msg", "아이디 또는 비밀번호를 확인하세요!!");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/");
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
