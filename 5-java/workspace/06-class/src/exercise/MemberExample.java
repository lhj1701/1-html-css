package exercise;

// 1. Ŭ������ import�ϰ�
import constructor.sub.Student;
// import constructor.Student // �ٸ� ��Ű���� ���� Ŭ�������� ���� Ŭ������ import�Ұ�

public class MemberExample {

	public static void main(String[] args) {
		// �̸�, id�� �Ű������� �޾Ƽ� ����
		// �ش��ϴ� �����ڸ�����

		Member member1 = new Member("ȫ�浿", "hong");
		Member member2 = new Member("����", "babo");
		member1.setAge(20);

		// 2. class�� ���
		Student student = new Student();
		System.out.println(student.age);
		// 2. Ŭ������ ��� - ��Ű������� �ۼ�
		// ��Ű����1.��Ű����2...Student
		constructor.sub.Student student1 = new constructor.sub.Student();
		System.out.println(member1.name + " " + member1.id);
		System.out.println(member2.name + " " + member2.id);
	}

}
