package static_;

// 멤버 클래스 선언
public class Member {
	// static 필드
	// 멤버 클래스 객체에서 모두 사용할 수 있는 변수 값
	// 고정적인 값 -> 관례적으로 snake-case:대문자로 씀
	final static String serviceName = "배달의 민족";
	// 변동 값
	static int memeberCount = 0; // 회원 수
	String name;
	String id;
	String pw;
	int age;

// 생성자 선언
// 이름과 id를 초기화하는 생성자
	Member(String name, String id) {
		this.id = id;
		this.name = name;
		memeberCount++;// 멤버 객체 생성 시 회원 수를 증가시킴
	}

// static 메서드
// 객체 생성없이 호출해서 사용할 수 있는 메서드
	static void printServiceName() {
		// static 변수에는 this 사용 불가 ? this는 생성된 객체를 가르킴
		// System.out.println(this.serviceName); // static 변수는 객체공간이 아닌 클래스공간(메서드 공간)
		System.out.println(serviceName);
		// 생성이 됨
	}

	// static 메소드에서는 non-static필드를 읽을 수 없음 -> this.name X
	// 매개변수로 값을 받아 처리해야함
	static void printNameWithServiceName(String name) {
		System.out.println(serviceName + ": " + name);
	}
}
