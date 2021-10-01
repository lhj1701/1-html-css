package exercise;

public class MemberServiceExample {

	public static void main(String[] args) {

		MemberService memberService = new MemberService();
		// 로그인 성공케이스
		// 테스트 데이터 생성
		Member member = new Member("홍길동", "hong");
		member.password = "12345";

		// 로그인 테스트 케이스 실행
		boolean result = memberService.login(member);
		// 로그인 실패케이스
		if (result) {
			System.out.println("로그인되었습니다");
		} else {
			System.out.println("로그인 실패했습니다");
		}
	}

}
