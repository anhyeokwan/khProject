package kr.or.iei.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(name = "logout", urlPatterns = { "/logout.do" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.getSession(); : 현재 사용중인 세션을 가져온다 (로그인을 안한 경우)
		// -> 현재 존재하는 세션이 없으면 세션을 생성해서 가지고 옴
		// request.getSession(false); : 현재 사용중인 세션을 가져온다. (정보수정, 로그아웃, 정보삭제(?))
		// -> 현재 존재하는 세션이 없으면 null리턴
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate(); // 현재 세션을 파괴하는 메소드
		}
		
		// 메인페이지로 이동
		// 전달할 데이터가 없으므로 redirect로 페이지 이동
		response.sendRedirect("/");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
