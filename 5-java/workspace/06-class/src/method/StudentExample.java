package method;

public class StudentExample {
	public static void main(String[] args) {
		// ��ü �����ϰ� �ʵ尪�� ����
		Student s1 = new Student();
		s1.name = "ȫ�浿";
		s1.age = 20;
		s1.semester = 1;
		s1.major = "�İ�";
		s1.printPersonInfo();

		// �ٸ� ������� ��ü ����
		Student s3 = new Student("boba", 31, 2, "ĳ��");
		s3.printPersonInfo();
		s3.getMajorInfo();
	}
}
