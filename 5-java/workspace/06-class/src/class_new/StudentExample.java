package class_new;

public class StudentExample {

	public static void main(String[] args) {
		// new Ŭ������() : �ν��Ͻ�(instance == ��ü(object))�� ���� (Ŭ���� ������ �޸� ������ ����)
		// Student s1 = ������ �ν��Ͻ�
		// �����ڴ� Ŭ������� ������ �̸��� �޼���(�Լ�)
		// �ַ� ��ü�� ������ �� �ʱ�ȭ�� ó��
		// Ŭ������() : �Ű������� ���� ������ (�⺻������-default constructor : �⺻�����ڴ� �������� �ʾƵ� Ŭ������ �����)
		// new ������ �޼��� : ������ �޼��带 �����Ͽ� ��ü�� ������

		// Student()��� ������ �޼ҵ带 �����ؼ� Student Ŭ���� ������ new ��ü�� ����� StudentŬ���� ������ s1������
		// �����ض�

		// �ڹٿ����� ���� ���� �ʴ� ���
		Student s1 = new Student(); // ������ �ν��Ͻ�, ȫ�浿�̶�� �л��� ���� ����
		// �ʵ� : ȫ�浿�̶�� �л��� ������
		// �ʵ忡 ���� : �ν��Ͻ� ������.�ʵ��
		s1.name = "ȫ�浿";
		s1.age = 20;
		s1.semester = 2;
		s1.major = "��ǻ�Ͱ���";
		// method : ȫ�浿�̶�� �л��� ������û ���
		// �޼��忡 ���� : �ν��Ͻ� ������.�޼ҵ��
		s1.joinCourse();
		System.out.println(s1.name + " " + s1.age);

		// �ڹٿ��� ��ü�� �����ϴ� �Ѱ��� ���
		// �����ڷ� �ʵ带 �ʱ�ȭ�Ͽ� ����
		Student s2 = new Student();
		System.out.println(s2.name + " " + s2.age);

		Student s3 = new Student("�ٺ���", 28, 3, "�ڹ���");
	}

}
