package method;

public class Student {
	String name;
	int age;
	int semester;
	String major;

	// �����ڴ� ��ȯ������ ����
	// Ŭ���� �̸��� ���� (�빮�ڷ� ����)
	Student() {
		// �ʱ�ȭ
	}

	// �̸�, ����, �б�, �а� �ް� �ʵ� �ʱ�ȭ �� ��ü ����
	Student(String name, int age, int semester, String major) {
		this.name = name;
		this.age = age;
		this.semester = semester;
		this.major = major;
	}

	// void : ��ȯ������ ����
	// ��ȯ���� �޼����() {...}
	void printPersonInfo() {
		System.out.println(this.name + " " + this.age);
	}

	void getMajorInfo() {
		System.out.println(this.major + " " + this.semester);
	}
}
