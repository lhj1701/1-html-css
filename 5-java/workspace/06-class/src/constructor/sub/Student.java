package constructor.sub;

public class Student {

	// default ���� ������ : �ܺ� ��Ű������ ��� �Ұ�
	// �ʵ�(field) ����, �ʵ�? : Ŭ���� ������ ����, ��ü ���������� �����ͳ� ���� ����Ǵ� �κ�
	String name;
	// protected ���� ������: �ܺ���Ű������ ��� �Ұ��ε� �� Ŭ������ ��ӹ޾Ƽ� ����ϸ� ��� ����
	public int age;
	// public : ��� ��Ű���� Ŭ�������� ��� ����
	protected int semester;
	String major;

	// Overloading : �޼ҵ��� �̸��� �����ϰ� �Ű������� ����, Ÿ��, ���� ���� �ٸ� �޼ҵ带 �����ϴ� ��
	// �޼��� �ñ״�ó: �޼ҵ� �̸� + �Ű�����
	// ��ü���� ���α׷����� ������ ������ ����, �پ��� ���¸� ������.

	// ������ (Constructor)
	// ��ü ������ �ʱ�ȭ ���� ���
	// Ŭ������� ������(�빮�ڷ� �����ϴ�)
	public Student() { // �ʱ�ȭ : �ƹ��͵� ó�� ����(��ü�� ������)
	}

	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// �����ڸ� ���Ƿ� �����, �⺻ �����ڴ� ���ŵ�
	// �̸��� ���̸� �Ű������� �޾Ƽ� ��ü(�ν��Ͻ�)�� �����ϴ� ������ �޼���
	Student(String name, int age, int semester, String major) {
		// this.�ʵ� : ������� ��ü �ʵ忡 ����
		// this = �� �Լ�! �� �޼ҵ�!
		this.name = name;
		this.age = age;

	}

	// method : ��ü�� ��ɿ� �ش��ϴ� �Լ�
	protected void joinCourse() {
		// ������û ó��
	}
}
