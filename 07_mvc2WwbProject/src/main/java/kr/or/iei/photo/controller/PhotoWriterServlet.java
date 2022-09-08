package kr.or.iei.photo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.iei.photo.model.service.PhotoService;
import kr.or.iei.photo.model.vo.Photo;

/**
 * Servlet implementation class PhotoWriterServlet
 */
@WebServlet(name="/PhotoWriterServlet", urlPatterns = {"/photoWriter.do"})
public class PhotoWriterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoWriterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String root = getServletContext().getRealPath("/"); // web-app의 절대경로
		String saveDirectory = root + "upload/photo";
		
		// 파일의 최대크기 지정
		int maxSize = 10 * 1024 * 1024;
		
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		String photoTitle = mRequest.getParameter("photoTitle");
		String photoContent = mRequest.getParameter("photoContent");
		String imageFile = mRequest.getFilesystemName("imageFile");
		String photoWrtier = mRequest.getParameter("photoWrtier");
		
		Photo photo = new Photo();
		photo.setPhotoTitle(photoTitle);
		photo.setPhotoContent(photoContent);
		photo.setFilepath(imageFile);
		photo.setPhotoWriter(photoWrtier);
		
		System.out.println(photoWrtier);
		
		PhotoService service = new PhotoService();
		int result = service.insertPhoto(photo);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			request.setAttribute("title", "성공");
			request.setAttribute("msg", "사진이 등록되었습니다.");
			request.setAttribute("icon", "success");
		}
		else {
			request.setAttribute("title", "실패");
			request.setAttribute("msg", "사진 등록 중 문제가 발생하였습니다.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/photoList.do");
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
