package kr.or.iei.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.member.model.vo.Member;

public class MemberDao {

	public Member SelectOneMember(Connection conn, Member member) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		
		String query = "select * from member_tbl where member_id = ? and member_pw = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMember_id());
			pstmt.setString(2, member.getMember_pw());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				m.setMember_no(rset.getInt("member_no"));
				m.setMember_id(rset.getString("member_id"));
				m.setMember_pw(rset.getString("member_pw"));
				m.setMember_name(rset.getString("member_name"));
				m.setMember_phone(rset.getString("member_phone"));
				m.setMember_addr(rset.getString("member_addr"));
				m.setMember_level(rset.getInt("member_level"));
				m.setEnroll_date(rset.getString("enroll_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return m;
	}

	//회원가입시 아이디 중복체크 
	   public Member selectOneMember(Connection conn, String memberId) {
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      Member m = null;
	      String query = "select * from member_tbl where member_id=?";
	      
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, memberId);
	         rset = pstmt.executeQuery();
	         if(rset.next()) {
	            m = new Member();
	            m.setMember_no(rset.getInt("member_no"));
	            m.setMember_id(rset.getString("member_id"));
	            m.setMember_pw(rset.getString("member_pw"));
	            m.setMember_name(rset.getString("member_name"));
	            m.setMember_phone(rset.getString("member_phone"));
	            m.setMember_addr(rset.getString("member_addr"));
	            m.setMember_level(rset.getInt("member_level"));
	            m.setEnroll_date(rset.getString("enroll_date"));            
	         }
	      
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         JDBCTemplate.close(pstmt);
	         JDBCTemplate.close(rset);
	      }
	      return m;
	   }
	   
	 //회원가입
	   public int insertMember(Connection conn, Member m) {
	      PreparedStatement pstmt = null;
	      int result = 0;
	      
	      String query =  "insert into member_tbl values("+"member_seq.nextval,"+"?,?,?,?,?,3,"+"to_char(sysdate,'yyyy-mm-dd'))";
	      
	      try {
	         pstmt = conn.prepareStatement(query); //커넥션에 쿼리문 검사
	         pstmt.setString(1, m.getMember_id()); //위치홀더 넣어주기
	         pstmt.setString(2, m.getMember_pw());
	         pstmt.setString(3, m.getMember_name());
	         pstmt.setString(4, m.getMember_phone());
	         pstmt.setString(5, m.getMember_addr());
	         result = pstmt.executeUpdate(); //쿼리문실행
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally { //자원반환
	         JDBCTemplate.close(pstmt);  //pstmt 닫기
	      }
	      return result;
	   }

	public int updateMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update member_tbl set member_pw=?, member_phone=?, member_addr=? where member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMember_pw());
			pstmt.setString(2, member.getMember_phone());
			pstmt.setString(3, member.getMember_addr());
			pstmt.setString(4, member.getMember_id());
			
			result = pstmt.executeUpdate();
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "delete from member_tbl where member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Member> selectAllMember(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		String query = "select * from member_tbl order by 1"; // 가입순서대로
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member member = new Member();
				member.setMember_no(rset.getInt("member_no"));
				member.setMember_id(rset.getString("member_id"));
				member.setMember_name(rset.getString("member_name"));
				member.setMember_phone(rset.getString("member_phone"));
				member.setMember_addr(rset.getString("member_addr"));
				member.setMember_level(rset.getInt("member_level"));
				member.setEnroll_date(rset.getString("enroll_date"));
				list.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

	public int changeLevel(Connection conn, int memberNo, int memberLevel) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update member_tbl set member_level = ? where member_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberLevel);
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}



}













