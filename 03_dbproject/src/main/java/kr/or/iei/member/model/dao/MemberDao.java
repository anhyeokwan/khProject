package kr.or.iei.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.member.model.vo.Member;

public class MemberDao {

	public int insertMember(Connection conn, Member member) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
	     int result = 0;
	      
	      String query = "insert into member_tbl values("+"member_seq.nextval,"+"?,?,?,?,?,3,"+"to_char(sysdate,'yyyy-mm-dd'))";
	      
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, member.getMember_id());
	         pstmt.setString(2, member.getMember_pw());
	         pstmt.setString(3, member.getMember_name());
	         pstmt.setString(4, member.getMember_phone());
	         pstmt.setString(5, member.getMember_addr());
	         result = pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         JDBCTemplate.close(pstmt);
	      }
	      
	      return result;
	}

	public ArrayList<Member> selectAllMember(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>(); // while문 안에 만들경우 값이 진행될때마다 배열이 초기화됨
		
		String query = "select * from member_tbl";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member member = new Member();
				member.setMember_no(rset.getInt("member_no"));
				member.setMember_id(rset.getString("member_id"));
				member.setMember_pw(rset.getString("member_pw"));
				member.setMember_name(rset.getString("member_name"));
				member.setMember_phone(rset.getString("member_phone"));
				member.setMember_addr(rset.getString("member_addr"));
				member.setMember_level(rset.getInt("member_level"));
				member.setEnroll_date(rset.getDate("enroll_date"));
				list.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public Member findMember(Connection conn, String memberId) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Member member = null;
		String query = "select * from member_tbl where member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member();
				member.setMember_no(rset.getInt("member_no"));
				member.setMember_id(rset.getString("member_id"));
				member.setMember_pw(rset.getString("member_pw"));
				member.setMember_name(rset.getString("member_name"));
				member.setMember_phone(rset.getString("member_phone"));
				member.setMember_addr(rset.getString("member_addr"));
				member.setMember_level(rset.getInt("member_level"));
				member.setEnroll_date(rset.getDate("enroll_date"));
	
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return member;
	}

}




















