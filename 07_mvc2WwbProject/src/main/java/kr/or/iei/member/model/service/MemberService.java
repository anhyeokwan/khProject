package kr.or.iei.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

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

	public Member SelectOneMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = dao.SelectOneMember(conn, member);
		JDBCTemplate.close(conn);
		return m;
	}

	//회원가입시 아이디중복체크
	   public Member selectOneMember(String memberId) {
	      Connection conn = JDBCTemplate.getConnection();
	      Member m = dao.selectOneMember(conn, memberId);
	      JDBCTemplate.close(conn);
	      return m;
	   }

	 //회원가입
	   public int insertMember(Member m) {
	      Connection conn = JDBCTemplate.getConnection();
	      int result = dao.insertMember(conn,m);
	      if(result>0) { //데이터의 변화가 발생한것이라서 커밋, 롤백후 close
	         JDBCTemplate.commit(conn);
	      }else {
	         JDBCTemplate.rollback(conn);
	      }
	      JDBCTemplate.close(conn);
	      
	      return result;
	   }

	public int updateMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateMember(conn, member);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.deleteMember(conn, memberId);
		
		if(result > 0) {
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

	public int changeLevel(int memberNo, int memberLevel) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.changeLevel(conn, memberNo, memberLevel);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public boolean checkedChangeMember(String num, String level) {
		Connection conn = JDBCTemplate.getConnection();
		//  예시 num : 4 / 7 / 21
		//      level : 1 / 2 / 3
		StringTokenizer sT1 = new StringTokenizer(num, "/"); // /를 기준으로 나눔
		StringTokenizer sT2 = new StringTokenizer(level, "/");
		boolean result = true;
		while(sT1.hasMoreTokens()) {
			int memberNo = Integer.parseInt(sT1.nextToken());
			int memberLevel = Integer.parseInt(sT2.nextToken());
			int changeResult = dao.changeLevel(conn, memberNo, memberLevel);
			
			if(changeResult == 0) {
				result = false;
				break;
			}
		}
		if(result) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	

}






















