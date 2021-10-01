package class_new;

// 클래스의 이름은 Pascal Case, 대문자 단어로 시작
// 클래스는 하나의 단위 프로그램(전체 프로그램의 일부)
public class Student {

	// 필드(field) 선언, 필드? : 클래스 내부의 변수, 객체 관점에서는 데이터나 값이 저장되는 부분
	String name;
	int age;
	int semester;
	String major;

	// Overloading : 메소드의 이름은 동일하고 매개변수의 개수, 타입, 순서 등이 다른 메소드를 선언하는 것
	// 메서드 시그닟: 메소드 이름 + 매개변수
	// 객체지향 프로그래밍의 다형성 원리를 적용, 다양한 형태를 가진다.

	// 생성자 (Constructor)
	// 객체 생성시 초기화 역할 담당
	// 클래스명과 동일한(대소문자로 생성하는)
	Student() {
		// 초기화
	} // 아무것도 처리 안함(객체만 생성됨)

	// 생성자를 임의로 만들면, 기본 생성자는 제거됨
	// 이름과 나이를 매개변수로 받아서 객체(인스턴스)를 생성하는 생성자 메서드
	Student(String name, int age, int semester, String major) {
		// this.필드
		// 만들어질 객체 필드에 접근
		this.name = name;
		this.age = age;

	}

	// method : 객체의 기능에 해당하는 함수
	void joinCourse() {
		// 수강신청 처리
	}
}
