package casting;

import override.Admin;
import override.Member;
import override.User;

public class UserExample {

	public static void main(String[] args) {
		// 일반 사용자
		User user = new User();
		user.setId("hong");
		user.setName("홍길동");
		user.setPhone("010112345");

		// 부모 클래스 캑체에 자식 클래스 객체를 대입할 수 있음
		// 중요한 것은 부모 클래스의 필드, 메소드만 사용 가능

		// 관리자
		user = new Admin();
		// 상속받은 user의 메소드 및 필드를 그대로 사용 가능함
		user.setId("john");
		user.setName("존스미스");
		user.setPhone("01045678978");
		// 자식 객체의 메소드, 필드는 사용불가
//		user.setDeptNo("10000");
		Admin admin2 = (Admin) user; // Admin <- amdin 가능함

		// 멤버십 멤버
		user = new Member();
		// 상속받은 user의 메소드 및 필드를 그대로 사용 가능함
		user.setId("kim");
		user.setName("김쿠팡");
		user.setPhone("789787878787");
		user.printUserInfo();
		// 자식 객체의 메소드, 필드는 사용불가
//		user.setPoint(10000);

		// 컴파일 타임에서는 오류가 발생하지 않음
		// 실행 타임에서는 오류가 발생함 Admin <- Member
		// instanceof 연산을 통해 해당 클래스의 객체가 맞는지 확인
		// user객체가 Admin 타입의 인스턴스인지 확인
		if (user instanceof Admin) {
			Admin admin3 = (Admin) user; // (Admin) 타입으로 강제 형변환
		}

		// 모든 클래스들의 최상위 부모가 Object 클래스임
		// extends를 쓰고 있지 않지만 내부적으로 extends 되어있는 상태
		Object obj = new Object();
		obj = user;
		System.out.println(obj);
		// 강제로 형식 객체 형식 변환할때는 instanceof 사용
		if (obj instanceof Admin) {
			Admin admin4 = (Admin) obj;
			System.out.println(admin4);
		}
	}

}
