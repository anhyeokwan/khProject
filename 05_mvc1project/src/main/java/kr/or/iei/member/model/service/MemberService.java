package kr.or.iei.member.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.member.model.dao.MemberDao;
import kr.or.iei.member.model.vo.Member;

public class MemberService {
	
	private MemberDao dao;

	public MemberService() {
		super();
		// TODO Auto-generated constructor stub
		dao = new MemberDao();
	}

	public int insertMember(Member member) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertMember(conn, member);
		
		if(result >0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public ArrayList<Member> selectAllMember() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = dao.selectAllMember(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public Member findMember(String memberId) {
		// TODO Auto-generated method stub
		
		Connection conn = JDBCTemplate.getConnection();
		Member member = dao.findMember(conn, memberId);
		JDBCTemplate.close(conn);
		
		return member;
	}
	

}




















