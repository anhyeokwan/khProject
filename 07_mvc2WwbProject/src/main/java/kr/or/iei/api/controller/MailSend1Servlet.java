package kr.or.iei.api.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MailSend1Servlet
 */
@WebServlet(name = "MailSend1", urlPatterns = { "/mailSend1.do" })
public class MailSend1Servlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailSend1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //1.인코딩
      request.setCharacterEncoding("utf-8");
      //2.값추출
      String mailTitle = request.getParameter("mailTitle");
      String receiver = request.getParameter("receiver");
      String mailContent = request.getParameter("mailContent");
      System.out.println(mailTitle);
      System.out.println(receiver);
      System.out.println(mailContent);
      //3.비즈니스로직
      MailSender sender = new MailSender();
      boolean result = sender.sendMail1(mailTitle,receiver,mailContent);
      //ㄴ db작업을 안하고 메일만 보내려고 하니까 이렇게 
      //화면처리
      RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
      if(result) {
         request.setAttribute("title", "메일전송성공");
         request.setAttribute("msg", "메일전송성공");
         request.setAttribute("icon", "success");
      }else {
         request.setAttribute("title", "메일전송실패");
         request.setAttribute("msg", "메일전송실패");
         request.setAttribute("icon", "error");
      }
      request.setAttribute("loc", "/");
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