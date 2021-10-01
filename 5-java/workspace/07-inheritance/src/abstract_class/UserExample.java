package abstract_class;

import override.Member;

public class UserExample {

	public static void main(String[] args) {

		// 사용자-사용자 종류에 대한 구조만 나타내고 실제로 객체를 생성하지는 않음
		// 추상 클래스는 인스턴스를 생성하지 못함 - 말 그대로 실체가 없음
//		User user = new User();
//		user.setId("hong");
//		user.setName("홍길동");
//		user.setPhone("010112345");

		// **자식객체의 기본필드나 메소드들을 정의하고 자식에서 구현할 메소드는 추상메소드로 정의**
		// 관리자
		Admin admin = new Admin();
		// 상속받은 user의 메소드 및 필드를 그대로 사용 가능함
		admin.setId("john");
		admin.setName("존스미스");
		admin.setPhone("01045678978");
		// 추가 필드 및 메소드 사용, 부서번호
		admin.setDeptNo("10000");
		// 구현한 메소드 사용
		admin.printUserInfo();

		// 멤버십 멤버
		Member member = new Member();
		// 상속받은 user의 메소드 및 필드를 그대로 사용 가능함
		member.setId("kim");
		member.setName("김쿠팡");
		member.setPhone("789787878787");
//		member.printUserInfo();
		// 추가 필드 및 메소드 사용, 포인트
		member.setPoint(10000);
	}

}
