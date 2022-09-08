package kr.or.iei.notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.notice.model.vo.Notice;
import kr.or.iei.notice.model.vo.NoticeComment;

public class NoticeDao {

	public ArrayList<Notice> selectNoticeList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Notice> list = new ArrayList<Notice>();
		String query = "select * from(select rownum as rnum, n.* from (select * from notice order by notice_no desc)n)where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Notice notice = new Notice();
				notice.setNotice_no(rset.getInt("notice_no"));
				notice.setNotice_title(rset.getString("notice_title"));
				notice.setNotice_writer(rset.getString("notice_writer"));
				notice.setNotice_content(rset.getString("notice_content"));
				notice.setRead_count(rset.getInt("read_count"));
				notice.setReg_date(rset.getString("reg_date"));
				notice.setFilename(rset.getString("filename"));
				notice.setFilepath(rset.getString("filepath"));
				list.add(notice);
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

	public int selectNoticeCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String qeury  = "select count(*) as cnt from notice";
		
		try {
			pstmt = conn.prepareStatement(qeury);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("cnt"); // 컬럼이름
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return totalCount;
	}

	public int insertNotice(Connection conn, Notice n) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into notice values(notice_seq.nextval, ?, ?, ?, 0,to_char(sysdate,'yyyy-mm-dd'),?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, n.getNotice_title());
			pstmt.setString(2, n.getNotice_writer());
			pstmt.setString(3, n.getNotice_content());
			pstmt.setString(4, n.getFilename());
			pstmt.setString(5, n.getFilepath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Notice selectOneNotice(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice n = null;
		
		String query = "select * from notice where notice_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				n = new Notice();
				n.setFilename(rset.getString("filename"));
				n.setFilepath(rset.getString("filepath"));
				n.setNotice_content(rset.getString("notice_content"));
				n.setNotice_no(rset.getInt("notice_no"));
				n.setNotice_title(rset.getString("notice_title"));
				n.setNotice_writer(rset.getString("notice_writer"));
				n.setRead_count(rset.getInt("read_count"));
				n.setReg_date(rset.getString("reg_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return n;
	}

	public int updateReadCount(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update notice set read_count = read_count+1 where notice_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteNotice(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "delete from notice where notice_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updateNotice(Connection conn, Notice n) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update notice set notice_title = ?, notice_content=?, filename=?, filepath=? where notice_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, n.getNotice_title());
			pstmt.setString(2, n.getNotice_content());
			pstmt.setString(3, n.getFilename());
			pstmt.setString(4, n.getFilepath());
			pstmt.setInt(5, n.getNotice_no());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int insertNoticeComment(Connection conn, NoticeComment nc) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into notice_comment values(nc_seq.nextval, ?, ?, to_char(sysdate,'yyyy-mm-dd'), ?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, nc.getNc_writer());
			pstmt.setString(2, nc.getNc_comment());
			pstmt.setInt(3, nc.getNotice_ref());
			if(nc.getNc_ref() == 0) {
				pstmt.setString(4, null);
			} else {
				pstmt.setInt(4, nc.getNc_ref());
			}
			pstmt.setString(4, (nc.getNc_ref() == 0)? null : String.valueOf(nc.getNc_ref()));
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<NoticeComment> selectNoticeComment(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<NoticeComment> commentList = new ArrayList<NoticeComment>();
		String query = "select * from notice_comment where notice_ref = ? and nc_ref is null order by 1";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				NoticeComment nc = new NoticeComment();
				nc.setNc_comment(rset.getString("nc_comment"));
				nc.setNc_date(rset.getString("nc_date"));
				nc.setNc_no(rset.getInt("nc_no"));
				nc.setNc_ref(rset.getInt("nc_ref"));
				nc.setNc_writer(rset.getString("nc_writer"));
				nc.setNotice_ref(rset.getInt("notice_ref"));
				commentList.add(nc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
			
		}
		
		
		return commentList;
	}

	public ArrayList<NoticeComment> selectNoticeReComment(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<NoticeComment> commentList = new ArrayList<NoticeComment>();
		String query = "select * from notice_comment where notice_ref = ? and nc_ref is not null order by 1";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				NoticeComment nc = new NoticeComment();
				nc.setNc_comment(rset.getString("nc_comment"));
				nc.setNc_date(rset.getString("nc_date"));
				nc.setNc_no(rset.getInt("nc_no"));
				nc.setNc_ref(rset.getInt("nc_ref"));
				nc.setNc_writer(rset.getString("nc_writer"));
				nc.setNotice_ref(rset.getInt("notice_ref"));
				commentList.add(nc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
			
		}
		
		
		return commentList;
	}

	public int updateNoticeComment(Connection conn, NoticeComment nc) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update notice_comment set nc_comment=? where nc_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, nc.getNc_comment());
			pstmt.setInt(2, nc.getNc_no());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int deleteNoticeComment(Connection conn, int ncNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "delete from notice_comment where nc_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ncNo);
			
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


















