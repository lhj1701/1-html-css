package map;

import java.util.HashMap;
import java.util.Map;

public class MemberExample2 {

	public static void main(String[] args) {
		// Map<키타입, 값타입>
		// Generic : 제너릭
		// 타입으로 들어가는 매개변수
		// 키가 Integer, String이던 상관없이 키가 같은지 비교할 때는 hashcode메서드와 equals메소드 호출
		Map<Integer, Member> members = new HashMap<Integer, Member>();

//		IntergerMap
//		StringMap
//		
//		Map<Member, Contact>
//		// Member : id, name, age
//		// Contact : home, company, mobile
//		// 직접 생성한 class는 hashcode하고 equals 기본적으로 메모리 주소만 비교
//		
//		
//		String name = "hong";
//		System.out.println(name.hashCode());
////		
	}
}
