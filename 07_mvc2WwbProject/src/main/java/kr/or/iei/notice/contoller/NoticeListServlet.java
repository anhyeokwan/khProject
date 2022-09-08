package kr.or.iei.notice.contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.notice.model.service.NoticeService;
import kr.or.iei.notice.model.vo.Notice;
import kr.or.iei.notice.model.vo.NoticePageData;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet(name="NoticeListServlet", urlPatterns = {"/noticeList.do"})
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 2. 값추출
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		// 3. 비즈니스 로직
		NoticeService service = new NoticeService();
		NoticePageData npd = service.selectNoticeList(reqPage); //1.처음에 int 타입 -> NoticeService에서 2개의 값을 넘겨줘야해서 새로 데이터를 생성함 (list, pageNavi)를 리턴해줌
	     //ㄴ게시글이 여러개 있으니까 arraylist 타입 

		// 4. 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/noticeList.jsp");
	    request.setAttribute("list", npd.getList());
	    request.setAttribute("pageNavi", npd.getPageNavi());
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
