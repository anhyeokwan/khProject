package kr.or.iei.api.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

   public boolean sendMail1(String mailTitle, String receiver, String mailContent) {
      //기본적으로 실패로 두고 성공하면 ture로 바꿀것 
      boolean result = false;
      
      //지금부터 쓰는 코드는 이메일라이브러리를 쓰기 위함 -> lib>mail-1.4.7.jar
      
      //이메일 통신설정
      Properties prop = System.getProperties();
      prop.put("mail.smtp.host","smtp.gmail.com");
      prop.put("mail.smtp.port", 465); //포트설정
      prop.put("mail.smtp.auth", "true");
      prop.put("mail.smtp.ssl.enable", "true");
      prop.put("mail.smtp.ssl.trust","smtp.gmail.com");
      //인증정보설정(로그인) javax.mail-Session
      Session session =Session.getDefaultInstance(prop, 
            new Authenticator() {
               protected PasswordAuthentication getPasswordAuthentication() { //구글 아이디 패스워드
                  PasswordAuthentication pa = new PasswordAuthentication("ifuleavee","xhbgnozhpjkuscgx");
                  return pa;//여기까지가 구글에서 로그인 한 시점
            }
         }   
      );
      //이메일을 작성해서 전송하는 객체 
      MimeMessage msg = new MimeMessage(session);      
      try {
         //이메일작성
         msg.setSentDate(new Date());
         //보내는 사람 정보
         msg.setFrom(new InternetAddress("ifuleavee@gmail.com","KH 당산 A클래스"));
         //받는 사람정보 
         InternetAddress to = new InternetAddress(receiver);
         msg.setRecipient(Message.RecipientType.TO, to);
         // 이ㅣ메일 제목설정
         msg.setSubject(mailTitle,"UTF-8");
         //이메일 본문설정
         msg.setContent(mailContent,"text/html;charset=utf-8");
         //이메일전송
         Transport.send(msg);
         result = true;
      }catch(MessagingException e) {
         e.printStackTrace();
      }catch(UnsupportedEncodingException e) {
         e.printStackTrace();
         
      }
      return result; 
   }

	public String sendmail2(String email) {
		//기본적으로 실패로 두고 성공하면 ture로 바꿀것 
	      boolean result = false;
	      // 인증용 랜덤코드 생성
	      Random r = new Random();
	      StringBuilder sb = new StringBuilder(); // 배열
	      for(int i = 0; i < 8; i++) {
	    	  // 숫자, 영어소문자, 영어대문자 섞어서 8개 조합
	    	  // 0 : 0~9, 1: A~Z, 2 : a~z
	    	  int flag = r.nextInt(3);
	    	  if(flag == 0) {
	    		  // 0~9
	    		  int randomNum = r.nextInt(10);
	    		  sb.append(randomNum);
	    	  }else if(flag == 1) {
	    		  // A~Z
	    		  char randomChar = (char)(r.nextInt(26)+65);
	    		  sb.append(randomChar);
	    	  }else if(flag == 2) {
	    		  char randomChar = (char)(r.nextInt(26)+97);
	    		  sb.append(randomChar);
	    	  }
	      }
	      
	      //지금부터 쓰는 코드는 이메일라이브러리를 쓰기 위함 -> lib>mail-1.4.7.jar
	      
	      //이메일 통신설정
	      Properties prop = System.getProperties();
	      prop.put("mail.smtp.host","smtp.gmail.com");
	      prop.put("mail.smtp.port", 465); //포트설정
	      prop.put("mail.smtp.auth", "true");
	      prop.put("mail.smtp.ssl.enable", "true");
	      prop.put("mail.smtp.ssl.trust","smtp.gmail.com");
	      //인증정보설정(로그인) javax.mail-Session
	      Session session =Session.getDefaultInstance(prop, 
	            new Authenticator() {
	               protected PasswordAuthentication getPasswordAuthentication() { //구글 아이디 패스워드
	                  PasswordAuthentication pa = new PasswordAuthentication("ifuleavee","xhbgnozhpjkuscgx");
	                  return pa;//여기까지가 구글에서 로그인 한 시점
	            }
	         }   
	      );
	      //이메일을 작성해서 전송하는 객체 
	      MimeMessage msg = new MimeMessage(session);      
	      try {
	         //이메일작성
	         msg.setSentDate(new Date());
	         //보내는 사람 정보
	         msg.setFrom(new InternetAddress("bomKh123@gmail.com","KH 당산 A클래스"));
	         //받는 사람정보 
	         InternetAddress to = new InternetAddress(email);
	         msg.setRecipient(Message.RecipientType.TO, to);
	         // 이ㅣ메일 제목설정
	         msg.setSubject("안형관 홈페이지 인증메일입니다.","UTF-8"); // 인증메일 확인 구문
	         //이메일 본문설정
	         msg.setContent("<h1>안녕하세요. 안형관 홈페이지입니다.</h1>"
	        		 + "<h3>인증번호는 [<span style='color:red'>" + sb.toString() + "</span>] 입니다.","text/html;charset=utf-8");
	         //이메일전송
	         Transport.send(msg);
	         result = true;
	      }catch(MessagingException e) {
	         e.printStackTrace();
	      }catch(UnsupportedEncodingException e) {
	         e.printStackTrace();
	         
	      }
	      if(result) {
	    	  return sb.toString();
	      }else {
	    	  return null;
	      }
	}

}



















