package kr.or.iei.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.JsonObject;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class AjaxTest4Servlet
 */
@WebServlet(name="/ajaxTest4.do", urlPatterns = {"/ajaxTest4.do"})
public class AjaxTest4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTest4Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String memberId = request.getParameter("mId");
		
		MemberService service = new MemberService();
		Member member = service.selectOneMember(memberId);
		
		// js가 인식할 수 있게 객체로 변환하는 작업
		JSONObject result = null;
		
		if(member != null) {
			result = new JSONObject();
			result.put("memberNo", member.getMember_no());
			result.put("memberId", member.getMember_id());
			result.put("memberPw", member.getMember_pw());
			result.put("memberName", member.getMember_name());
			result.put("memberPhone", member.getMember_phone());
			result.put("memberAddr", member.getMember_addr());
			result.put("memberLevel", member.getMember_level());
			result.put("enrollDate", member.getEnroll_date());
		}
		// 첫번째 방식
//		response.setContentType("application/json"); 객체타입으로 변환
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
