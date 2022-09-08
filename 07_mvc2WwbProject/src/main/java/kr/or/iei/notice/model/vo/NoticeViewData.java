package kr.or.iei.notice.model.vo;

import java.util.ArrayList;

public class NoticeViewData {
	
	private Notice n;
	private ArrayList<NoticeComment> commenList;
	private ArrayList<NoticeComment> reCommentList;
	
	public NoticeViewData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NoticeViewData(Notice n, ArrayList<NoticeComment> commenList, ArrayList<NoticeComment> reCommentList) {
		super();
		this.n = n;
		this.commenList = commenList;
		this.reCommentList = reCommentList;
	}
	
	public Notice getN() {
		return n;
	}
	public void setN(Notice n) {
		this.n = n;
	}
	public ArrayList<NoticeComment> getCommenList() {
		return commenList;
	}
	public void setCommenList(ArrayList<NoticeComment> commenList) {
		this.commenList = commenList;
	}
	public ArrayList<NoticeComment> getReCommentList() {
		return reCommentList;
	}
	public void setReCommentList(ArrayList<NoticeComment> reCommentList) {
		this.reCommentList = reCommentList;
	}
	
	

}
