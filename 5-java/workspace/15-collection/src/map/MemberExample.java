package map;

import java.util.HashMap;
import java.util.Map;

public class MemberExample {

	public static void main(String[] args) {
		// map 키가 중복이 없음
		// Map<키타입, 값타입>
		// 매개변수로 넣어주는 타입 : 제네릭
		// 키 : Member의 id, 값 : Member 객체
		Map<String, Member> members = new HashMap<String, Member>();

// 1. 객체 추가
// 새로운 객체를 생성하고, map 변수의 put 메소드로 추가
//		Member hong = new Member("hong", "password123", "홍길동", 20);
//		members.put("hong",hong)
		members.put("hong", new Member("hong", "password123", "홍길동", 20));
		members.put("John", new Member("John", "smiiiii", "SMith", 40));

// 같은 키의 값 객체를 넣으면 값 객체가 덮어 씌워짐(수정이 일어남)

// 2.맵에서 1개의 값을 조회
// 맵변수.get(키값)
		Member m = members.get("hong");
		System.out.println("----1건 조회----");
		System.out.println(m.getName() + ", " + m.getAge());

// 3. 맵 목록 조회
// 맵변수.keySet() => 맵의 key 목록을 set형식의 자료구조로 반환
// set : 중복값이 없는 자료구조
		System.out.println("----목록 조회----");
		for (String id : members.keySet()) {
			// {"hong","john"}
			String name = members.get(id).getName();
			int age = members.get(id).getAge();
			System.out.println(id + ": " + name + ", " + age);
		}

		System.out.println("----목록 조회----");
		for (Member member : members.values()) {
			String name = member.getName();
			int age = member.getAge();
			System.out.println(member.getId() + ": " + name + ", " + age);
		}
// 4. 맵의 값 객체의 필드 값을 수정
		// 1건을 가져온 후에 필드 수정
		Member mHong = members.get("hong");
		System.out.println("----1건 조회----");
		System.out.println(mHong.getName() + ", " + mHong.getAge());
		mHong.setAge(25); // 필드값 수정
		System.out.println("----1건에 대하여 필드값 수정 조회----");
		System.out.println(mHong.getName() + ", " + mHong.getAge());

// 5. 맵의 요소 1건을 삭제
		// 맵변수.remove(키)
		members.remove("John");
		System.out.println("삭제 후 목록 조회");
		for (Member member : members.values()) {
			String name = member.getName();
			int age = member.getAge();
			System.out.println(member.getId() + ": " + name + ", " + age);
		}

// 맵변수.clear() // 전체 삭제
		members.clear();
		System.out.println("전체 삭제 후 목록 조회");
		for (Member member : members.values()) {
			String name = member.getName();
			int age = member.getAge();
			System.out.println(member.getId() + ": " + name + ", " + age);
		}
// members.size() // 맵 크기
// members.isEmpty() // 맵 요소가 있는지, true면  요소없음
// 해당 키가 있는지 체크, true면 해당 키가 있음
		members.containsKey(mHong);
	}
}
