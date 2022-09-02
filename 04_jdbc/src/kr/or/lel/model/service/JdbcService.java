package kr.or.lel.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.lel.model.dao.JdbcDao;
import kr.or.lel.model.vo.Member;

public class JdbcService {
	
	private JdbcDao dao;

	public JdbcService() {
		super();
		// TODO Auto-generated constructor stub
		dao = new JdbcDao();
	}

	public ArrayList<Member> printAllmember() {
		// TODO Auto-generated method stub
		Connection conn = null;
		ArrayList<Member> member = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");
			member = dao.printAllmember(conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return member;
	}

	public Member printOneMember(String memberId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Member member = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "1234");
			member = dao.printOneMember(conn, memberId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return member;
	}

}

















