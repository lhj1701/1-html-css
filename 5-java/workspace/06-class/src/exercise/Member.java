package exercise;

import constructor.sub.Student;

// Member Ŭ���� ����
public class Member extends Student {
//
//	public static void main(String[] args) {
//
//	}

	// �ڹٿ��� �⺻������ field�� �� private ���������ڷ� ����Ǿ�����
	// �ڹٿ��� �ʵ带 public, protected ������ �Ⱦ�
	String name;
	// getter, setter�� �ܺο� ������ �ʵ带 property��� ��
	String id;
	String password;
	int age;

	// �ʵ带 �����ϰ� ���ִ� �޼ҵ带 �ۼ�
	// get�ʵ�� : �ʵ��� ���� �������� �޼ҵ�
	// getter
	// public �ʵ�Ÿ�� get�ʵ��(){
	// return this.�ʵ�� }
	public String getName() {
		return this.name;
	}

	// set�ʵ�� : �ʵ��� ���� �����ϴ� �޼ҵ�
	// setter
	// public void set�ʵ��(�ʵ�Ÿ�� ������){
	// this.�ʵ�� = ������ }
	public void setAge(int age) {
		this.age = age;
	}

// �����ڸ� ����
// �̸��� id�� �ʱ�ȭ�ϴ� ������

	Member(String name, String id) {
		this.name = name;
		this.id = id;
		// ��ӹ޾ұ� ������ ��� ����
		this.semester = 1; // protected�� ������ �ʵ�
		this.joinCourse(); // protected�� ������ �޼ҵ�
	}
}
