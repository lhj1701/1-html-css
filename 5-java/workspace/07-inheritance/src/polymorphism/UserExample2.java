package polymorphism;

public class UserExample2 {

	public static void main(String[] args) {

		// 일반 사용자
		User user = new User();
		user.setId("hong");
		user.setName("홍길동");
		user.setPhone("010112345");
		sendMessage(user);// param : User user <- User user

		// 관리자
		Admin admin = new Admin();
		// 상속받은 user의 메소드 및 필드를 그대로 사용 가능함
		admin.setId("john");
		admin.setName("존스미스");
		admin.setPhone("01045678978");
		// 추가 필드 및 메소드 사용, 부서번호
		admin.setDeptNo("10000");
		sendMessage(admin); // param : User user <- Admin admin

		// 멤버십 멤버
		Member member = new Member();
		// 상속받은 user의 메소드 및 필드를 그대로 사용 가능함
		member.setId("kim");
		member.setName("김쿠팡");
		member.setPhone("789787878787");
		member.printUserInfo();
		// 추가 필드 및 메소드 사용, 포인트
		member.setPoint(10000);
		sendMessage(member); // param : User user <- Member member
	}

	// 부모타입으로 매개변수를 선언
	public static void sendMessage(User user) {
		System.out.println("");
		System.out.println(user.getPhone() + ": 공지사항 메세지를 보냅니다");
	}

}
