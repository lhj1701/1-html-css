package method;

public class Student {
	String name;
	int age;
	int semester;
	String major;

	// 생성자는 반환형식이 없음
	// 클래스 이름과 동일 (대문자로 시작)
	Student() {
		// 초기화
	}

	// 이름, 나이, 학기, 학과 받고 필드 초기화 및 객체 생성
	Student(String name, int age, int semester, String major) {
		this.name = name;
		this.age = age;
		this.semester = semester;
		this.major = major;
	}

	// void : 반환형식이 없음
	// 반환형식 메서드명() {...}
	void printPersonInfo() {
		System.out.println(this.name + " " + this.age);
	}

	void getMajorInfo() {
		System.out.println(this.major + " " + this.semester);
	}
}
