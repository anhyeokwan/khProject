package kr.or.iei.notice.model.vo;

public class NoticeComment {
	
	private int nc_no;
	private String nc_writer;
	private String nc_comment;
	private String nc_date;
	private int notice_ref;
	private int nc_ref;
	
	public NoticeComment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoticeComment(int nc_no, String nc_writer, String nc_comment, String nc_date, int notice_ref, int nc_ref) {
		super();
		this.nc_no = nc_no;
		this.nc_writer = nc_writer;
		this.nc_comment = nc_comment;
		this.nc_date = nc_date;
		this.notice_ref = notice_ref;
		this.nc_ref = nc_ref;
	}

	public int getNc_no() {
		return nc_no;
	}

	public void setNc_no(int nc_no) {
		this.nc_no = nc_no;
	}

	public String getNc_writer() {
		return nc_writer;
	}

	public void setNc_writer(String nc_writer) {
		this.nc_writer = nc_writer;
	}

	public String getNc_comment() {
		return nc_comment;
	}

	public void setNc_comment(String nc_comment) {
		this.nc_comment = nc_comment;
	}

	public String getNc_date() {
		return nc_date;
	}

	public void setNc_date(String nc_date) {
		this.nc_date = nc_date;
	}

	public int getNotice_ref() {
		return notice_ref;
	}

	public void setNotice_ref(int notice_ref) {
		this.notice_ref = notice_ref;
	}

	public int getNc_ref() {
		return nc_ref;
	}

	public void setNc_ref(int nc_ref) {
		this.nc_ref = nc_ref;
	}
	
	

}
