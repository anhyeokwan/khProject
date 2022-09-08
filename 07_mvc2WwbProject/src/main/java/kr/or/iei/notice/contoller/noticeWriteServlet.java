package kr.or.iei.notice.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.iei.notice.model.service.NoticeService;
import kr.or.iei.notice.model.vo.Notice;

/**
 * Servlet implementation class noticeWriteServlet
 */
@WebServlet(name="noticeWriteServlet", urlPatterns = {"/noticeWrite.do"})
public class noticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public noticeWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 값추출
		// multipart/form-data(파일업로드)형식이면 데이터를 꺼낸 후 추출
		// -> cos.jar 라이브러리 사용해서 처리
		// 2-1. 파일이 업로드 될 경로를 지정
		String root = getServletContext().getRealPath("/"); // webapp의 절대경로를 가져옴
		String saveDirectory = root + "upload/notice";
		// 2-2. 파일 업로드 최대용량 설정 (일반적인 웹은 최대 용량 10MB)
		int maxSize = 10 * 1024 * 1024;
		// 2-3. multipart/form-data에서 데이터를 꺼내기 위한 객체
		// request -> MultipartRequest객체 변환(cos.jar)
		// 매개변수 5개를 전달하면서 객체 생성
		// 1) request, 2)파일저장경로, 3) 파일최대크기, 4) 인코딩타입, 5) 파일명중복처리객체(자동으로 처리를 해주는게 있음)
		// MultipartRequest 객체가 생성되는 시점에 파일이 업로드 완료
		// new DefaultFileRenamePolicy() 같은 파일명을 올렸을 때 넘버링이 됨
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "utf-8", new DefaultFileRenamePolicy());
		// request로 추출하면 null로 나옴
		String noticeTitle = mRequest.getParameter("noticeTitle");
		String noticeWrier = mRequest.getParameter("noticeWriter");
		String noticeContent = mRequest.getParameter("noticeContent");
		// 실제로 화면에서 첨부한 원본파일이름
		String filename = mRequest.getOriginalFileName("upfile");
		// 실제 서버에 업로드된 파일이름(중복처리 후 이름)
		String filepath = mRequest.getFilesystemName("upfile");
		Notice n = new Notice();
		n.setNotice_title(noticeTitle);
		n.setNotice_writer(noticeWrier);
		n.setNotice_content(noticeContent);
		n.setFilename(filename);
		n.setFilepath(filepath);
		
		// 비즈니스 로직
		NoticeService service = new NoticeService();
		int result = service.insertNotice(n);
		
		// 결과추출
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		if(result > 0) {
			request.setAttribute("title", "성공");
			request.setAttribute("msg", "공지사항이 등록되었습니다.");
			request.setAttribute("icon", "success");
		} else {
			request.setAttribute("title", "실패");
			request.setAttribute("msg", "공지사항이 등록 중 문제가 발생하였습니다");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/noticeList.do?reqPage=1");
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
