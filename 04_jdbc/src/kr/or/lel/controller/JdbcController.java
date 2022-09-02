package kr.or.lel.controller;

import java.util.ArrayList;

import kr.or.lel.model.dao.JdbcDao;
import kr.or.lel.model.service.JdbcService;
import kr.or.lel.model.vo.Member;
import kr.or.lel.view.JdbcView;

public class JdbcController {
	
	private JdbcDao dao;
	private JdbcView view;
	private JdbcService service;
	
	public JdbcController() {
		super();
		// TODO Auto-generated constructor stub
		dao = new JdbcDao();
		view = new JdbcView();
		service = new JdbcService();
	}
	
	public void main() {
		int sel = view.showMenu();
		
		switch(sel) {
		case 1:
			printAllMember();
			break;
			
		case 2:
			printOneMember();
			break;
			
		case 3:
			insertMember();
			break;
			
		case 4:
			break;
			
		case 5:
			break;
			
		case 0:
			break;
			
		default:
			break;
		}
		
	}

	private void insertMember() {
		// TODO Auto-generated method stub
		Member newMember = view.insertMember();
	}

	private void printOneMember() {
		// TODO Auto-generated method stub
		String memberId = view.getId();
		
		Member member = service.printOneMember(memberId);
		
		view.printOneMember(member);
		
	}

	private void printAllMember() {
		// TODO Auto-generated method stub
		ArrayList<Member> members = service.printAllmember();
		
		view.printAllMember(members);
		
	}
	
	

}




















