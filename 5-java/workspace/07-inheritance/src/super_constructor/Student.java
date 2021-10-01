package super_constructor;

public class Student extends Person {

	private int studentNo;

	// quick fix�� �ϰԵǸ�, �θ�����ڿ� �´� �����ڸ� �������
	// Person(String name, String phone) : �θ������
	// -> Student(String name, String phone)
	// �ٸ� �ʵ带 ���� �ʱ�ȭ�ؾ��ϸ� �Ű����� �� �ʱ�ȭ ���� �߰�
	public Student(String name, String phone) {
		super(name, phone);
	}

	// �⺻ �����ڰ� ����������
	// public Student(){
	// super(); ���ؼ� ���� �߻� -> ��������� �����ڸ� ��������
	// }

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

}
