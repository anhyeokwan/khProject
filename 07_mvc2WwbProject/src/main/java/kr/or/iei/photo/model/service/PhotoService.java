package kr.or.iei.photo.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.photo.model.dao.PhotoDao;
import kr.or.iei.photo.model.vo.Photo;

public class PhotoService {
	
	private PhotoDao dao;

	public PhotoService() {
		super();
		// TODO Auto-generated constructor stub
		dao = new PhotoDao();
	}

	public int totalCount() {

		Connection conn = JDBCTemplate.getConnection();
		int totalCount = dao.totalCount(conn);
		
		JDBCTemplate.close(conn);
		
		return totalCount;
	}

	public int insertPhoto(Photo photo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertPhoto(conn, photo);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public ArrayList<Photo> photoMore(int start, int amount) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int end = start + amount - 1;
		ArrayList<Photo> list = dao.photoMore(conn, start, end);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	

}
























