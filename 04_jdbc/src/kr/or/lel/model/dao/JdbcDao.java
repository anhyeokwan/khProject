package kr.or.lel.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.lel.model.vo.Member;

public class JdbcDao {

	public ArrayList<Member> printAllmember(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Member> memberList = new ArrayList<Member>();
		String query = "select * from member_tbl";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			while(rset.next()) {
				Member m = new Member();
				m.setMember_id(rset.getString("member_id"));
				m.setMember_pw(rset.getString("member_pw"));
				m.setMember_name(rset.getString("member_name"));
				m.setMember_addr(rset.getString("member_addr"));
				m.setMember_phone(rset.getString("member_phone"));
				m.setMember_age(rset.getInt("member_age"));
				m.setMember_gender(rset.getString("member_gender"));
				m.setEnroll_date(rset.getDate("enroll_date"));
				memberList.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return memberList;
	}

	public Member printOneMember(Connection conn, String memberId) {
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
				member.setMember_id(rset.getString("member_id"));
				member.setMember_pw(rset.getString("member_pw"));
				member.setMember_name(rset.getString("member_name"));
				member.setMember_addr(rset.getString("member_addr"));
				member.setMember_phone(rset.getString("member_phone"));
				member.setMember_age(rset.getInt("member_age"));
				member.setMember_gender(rset.getString("member_gender"));
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















