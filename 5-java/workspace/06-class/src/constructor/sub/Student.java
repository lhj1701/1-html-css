package constructor.sub;

public class Student {

	// default 접근 제한자 : 외부 패키지에선 사용 불가
	// 필드(field) 선언, 필드? : 클래스 내부의 변수, 객체 관점에서는 데이터나 값이 저장되는 부분
	String name;
	// protected 접근 제한자: 외부패키지에서 사용 불가인데 이 클래스를 상속받아서 사용하면 사용 가능
	public int age;
	// public : 모든 패키지의 클래스에서 사용 가능
	protected int semester;
	String major;

	// Overloading : 메소드의 이름은 동일하고 매개변수의 개수, 타입, 순서 등이 다른 메소드를 선언하는 것
	// 메서드 시그니처: 메소드 이름 + 매개변수
	// 객체지향 프로그래밍의 다형성 원리를 적용, 다양한 형태를 가진다.

	// 생성자 (Constructor)
	// 객체 생성시 초기화 역할 담당
	// 클래스명과 동일한(대문자로 시작하는)
	public Student() { // 초기화 : 아무것도 처리 안함(객체만 생성됨)
	}

	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// 생성자를 임의로 만들면, 기본 생성자는 제거됨
	// 이름과 나이를 매개변수로 받아서 객체(인스턴스)를 생성하는 생성자 메서드
	Student(String name, int age, int semester, String major) {
		// this.필드 : 만들어질 객체 필드에 접근
		// this = 이 함수! 이 메소드!
		this.name = name;
		this.age = age;

	}

	// method : 객체의 기능에 해당하는 함수
	protected void joinCourse() {
		// 수강신청 처리
	}
}
