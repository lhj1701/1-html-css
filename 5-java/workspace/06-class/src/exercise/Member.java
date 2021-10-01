package exercise;

import constructor.sub.Student;

// Member 클래스 선언
public class Member extends Student {
//
//	public static void main(String[] args) {
//
//	}

	// 자바에서 기본적으로 field는 다 private 접근제한자로 선언되어있음
	// 자바에서 필드를 public, protected 같은거 안씀
	String name;
	// getter, setter로 외부에 공개된 필드를 property라고 함
	String id;
	String password;
	int age;

	// 필드를 접근하게 해주는 메소드를 작성
	// get필드명 : 필드의 값을 가져오는 메소드
	// getter
	// public 필드타입 get필드명(){
	// return this.필드명 }
	public String getName() {
		return this.name;
	}

	// set필드명 : 필드의 값을 설정하는 메소드
	// setter
	// public void set필드명(필드타입 변수명){
	// this.필드명 = 변수명 }
	public void setAge(int age) {
		this.age = age;
	}

// 생성자를 선언
// 이름과 id를 초기화하는 생성자

	Member(String name, String id) {
		this.name = name;
		this.id = id;
		// 상속받았기 때문에 사용 가능
		this.semester = 1; // protected로 제한한 필드
		this.joinCourse(); // protected로 제한한 메소드
	}
}
