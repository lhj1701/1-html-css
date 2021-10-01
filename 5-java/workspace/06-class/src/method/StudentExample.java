package method;

public class StudentExample {
	public static void main(String[] args) {
		// 객체 생성하고 필드값에 대입
		Student s1 = new Student();
		s1.name = "홍길동";
		s1.age = 20;
		s1.semester = 1;
		s1.major = "컴공";
		s1.printPersonInfo();

		// 다른 방법으로 객체 생성
		Student s3 = new Student("boba", 31, 2, "캐워");
		s3.printPersonInfo();
		s3.getMajorInfo();
	}
}
