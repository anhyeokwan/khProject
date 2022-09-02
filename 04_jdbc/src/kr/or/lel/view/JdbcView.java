package kr.or.lel.view;

import java.util.ArrayList;
import java.util.Scanner;

import kr.or.lel.model.vo.Member;

public class JdbcView {
	
	private Scanner sc;
	
	public JdbcView() {
		super();
		// TODO Auto-generated constructor stub
		sc = new Scanner(System.in);
	}

	public int showMenu() {
		
		System.out.println("====== jdbc 회원관리 프로그램 ======");
		System.out.println("1. 전체 회원 정보 조회");
		System.out.println("2. 단일 회원 정보 조회");
		System.out.println("3. 회원 정보 등록");
		System.out.println("4. 회원 정보 수정");
		System.out.println("5. 회원 정보 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 > ");
		int sel = sc.nextInt();
		
		return sel;
	}

	public void printAllMember(ArrayList<Member> members) {
		// TODO Auto-generated method stub
		System.out.println("====== 전체 회원 정보 조회 ======");
		System.out.println("아이디\t비밀번호\t이름\t주소\t전화번호\t\t나이\t성별\t가입일자");
		for(int i = 0; i < members.size(); i++) {
			Member m = members.get(i);
			System.out.println(m.getMember_id() + "\t" + m.getMember_pw() + "\t" +
					m.getMember_name() + "\t" + m.getMember_addr() + "\t" + m.getMember_phone()
					+ "\t" + m.getMember_age() + "\t" + m.getMember_gender() + "\t" + m.getEnroll_date());;
		}
	}
	

	public void printOneMember(Member member) {
		// TODO Auto-generated method stub
		System.out.println("====== 단일 회원 정보 조회 ======");
		System.out.println("회원 아이디 : " + member.getMember_id());
		System.out.println("회원 비밀번호 : " + member.getMember_pw());
		System.out.println("회원 이름 : " + member.getMember_name());
		System.out.println("회원 주소 : " + member.getMember_addr());
		System.out.println("회원 전화번호 : " + member.getMember_phone());
		System.out.println("회원 나이 : " + member.getMember_age());
		System.out.println("회원 성별 : " + member.getMember_gender());
		System.out.println("가입일자 : " + member.getEnroll_date());
	}

	public String getId() {
		// TODO Auto-generated method stub
		System.out.println("====== 단일 회원 정보 조회 ======");
		System.out.print("회원 아이디 입력 : ");
		String memberId = sc.next();
		return memberId;
	}

	public Member insertMember() {
		
		Member member = new Member();
		
		System.out.println("====== 회원 등록 ======");
		System.out.print("회원 아이디 입력 : ");
		member.setMember_id(sc.next());
		
		System.out.print("회원 비밀번호 입력 : ");
		member.setMember_pw(sc.next());
		
		System.out.print("회원 이름 입력 : ");
		member.setMember_name(sc.next());
		
		System.out.print("회원 주소 입력 : ");
		member.setMember_addr(sc.nextLine());
		
		System.out.print("회원 전화번호 입력 : ");
		member.setMember_age(sc.nextInt());
		
		return null;
	}
	
	

}






















