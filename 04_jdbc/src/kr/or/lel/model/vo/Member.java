package kr.or.lel.model.vo;

import java.sql.Date;

public class Member {
	
	private String member_id;
	private String member_pw;
	private String member_name;
	private String member_addr;
	private String member_phone;
	private int member_age;
	private String member_gender;
	private Date enroll_date;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String member_id, String member_pw, String member_name, String member_addr, String member_phone,
			int member_age, String member_gender, Date enroll_date) {
		super();
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_addr = member_addr;
		this.member_phone = member_phone;
		this.member_age = member_age;
		this.member_gender = member_gender;
		this.enroll_date = enroll_date;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_addr() {
		return member_addr;
	}

	public void setMember_addr(String member_addr) {
		this.member_addr = member_addr;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public int getMember_age() {
		return member_age;
	}

	public void setMember_age(int member_age) {
		this.member_age = member_age;
	}

	public String getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}

	public Date getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}
	
	

}
