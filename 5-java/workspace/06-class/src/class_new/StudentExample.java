package class_new;

public class StudentExample {

	public static void main(String[] args) {
		// new 클래스명() : 인스턴스(instance == 객체(object))를 생성 (클래스 구조의 메모리 공간을 생성)
		// Student s1 = 생성된 인스턴스
		// 생성자는 클래스명과 동일한 이름의 메서드(함수)
		// 주로 객체를 생성할 때 초기화를 처리
		// 클래스명() : 매개변수가 없는 생성자 (기본생성자-default constructor : 기본생성자는 선언하지 않아도 클래스에 내장됨)
		// new 생성자 메서드 : 생성자 메서드를 실행하여 객체를 만들어라

		// Student()라는 생성자 메소드를 실행해서 Student 클래스 구조의 new 객체를 만들고 Student클래스 형식의 s1변수에
		// 대입해라

		// 자바에서는 거의 쓰지 않는 방법
		Student s1 = new Student(); // 생성된 인스턴스, 홍길동이라는 학생에 대한 정보
		// 필드 : 홍길동이라는 학생의 데이터
		// 필드에 접근 : 인스턴스 변수명.필드명
		s1.name = "홍길동";
		s1.age = 20;
		s1.semester = 2;
		s1.major = "컴퓨터공학";
		// method : 홍길동이라는 학생의 수강신청 기능
		// 메서드에 접근 : 인스턴스 변수명.메소드명
		s1.joinCourse();
		System.out.println(s1.name + " " + s1.age);

		// 자바에서 객체를 생성하는 한가지 방법
		// 생성자로 필드를 초기화하여 생성
		Student s2 = new Student();
		System.out.println(s2.name + " " + s2.age);

		Student s3 = new Student("바보얌", 28, 3, "자바웹");
	}

}
