package override;

public class UserExample2 {

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

		// 멤버십 멤버
		user = new Member();
		// 상속받은 user의 메소드 및 필드를 그대로 사용 가능함
		user.setId("kim");
		user.setName("김쿠팡");
		user.setPhone("789787878787");
		user.printUserInfo();
		// 자식 객체의 메소드, 필드는 사용불가
//		user.setPoint(10000);
	}

}
