package exercise;

public class MemberService {

	// login(Member)
	// Member 객체를 메서드 파라미터로 받음
	// dependency : 의존성이 있음
	// Dependency<<Usage>> : 구현이나 기능처리에 다른 클래스가 필요함
	boolean login(Member member) {
//		if (member.getId == "hong" && member.getPassword == "12345") {
//			return true;
//		}
		return false;
	}

	// login(String, String)
	// 오버로딩 : 메서드 이름은 동일하고 매개변수의 타입, 개수, 순서가 달라야함
	boolean login(String id, String password) {
		if (id == "hong" && password == "12345") {
			return true;
		} else {
			return false;
		}
	}

	void logout(String id) {
		System.out.println("로그아웃되었습니다");
	}
}
