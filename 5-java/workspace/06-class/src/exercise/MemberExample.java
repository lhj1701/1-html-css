package exercise;

// 1. 클래스를 import하고
import constructor.sub.Student;
// import constructor.Student // 다른 패키지의 같은 클래스명을 가진 클래스는 import불가

public class MemberExample {

	public static void main(String[] args) {
		// 이름, id를 매개변수로 받아서 생성
		// 해당하는 생성자를선언

		Member member1 = new Member("홍길동", "hong");
		Member member2 = new Member("보바", "babo");
		member1.setAge(20);

		// 2. class를 사용
		Student student = new Student();
		System.out.println(student.age);
		// 2. 클래스를 사용 - 패키지명까지 작성
		// 패키지명1.패키지명2...Student
		constructor.sub.Student student1 = new constructor.sub.Student();
		System.out.println(member1.name + " " + member1.id);
		System.out.println(member2.name + " " + member2.id);
	}

}
