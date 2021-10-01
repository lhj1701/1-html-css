package static_;

// ��� Ŭ���� ����
public class Member {
	// static �ʵ�
	// ��� Ŭ���� ��ü���� ��� ����� �� �ִ� ���� ��
	// �������� �� -> ���������� snake-case:�빮�ڷ� ��
	final static String serviceName = "����� ����";
	// ���� ��
	static int memeberCount = 0; // ȸ�� ��
	String name;
	String id;
	String pw;
	int age;

// ������ ����
// �̸��� id�� �ʱ�ȭ�ϴ� ������
	Member(String name, String id) {
		this.id = id;
		this.name = name;
		memeberCount++;// ��� ��ü ���� �� ȸ�� ���� ������Ŵ
	}

// static �޼���
// ��ü �������� ȣ���ؼ� ����� �� �ִ� �޼���
	static void printServiceName() {
		// static �������� this ��� �Ұ� ? this�� ������ ��ü�� ����Ŵ
		// System.out.println(this.serviceName); // static ������ ��ü������ �ƴ� Ŭ��������(�޼��� ����)
		System.out.println(serviceName);
		// ������ ��
	}

	// static �޼ҵ忡���� non-static�ʵ带 ���� �� ���� -> this.name X
	// �Ű������� ���� �޾� ó���ؾ���
	static void printNameWithServiceName(String name) {
		System.out.println(serviceName + ": " + name);
	}
}
