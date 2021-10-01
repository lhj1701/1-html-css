package polymorphism;

public class UserExample2 {

	public static void main(String[] args) {

		// �Ϲ� �����
		User user = new User();
		user.setId("hong");
		user.setName("ȫ�浿");
		user.setPhone("010112345");
		sendMessage(user);// param : User user <- User user

		// ������
		Admin admin = new Admin();
		// ��ӹ��� user�� �޼ҵ� �� �ʵ带 �״�� ��� ������
		admin.setId("john");
		admin.setName("�����̽�");
		admin.setPhone("01045678978");
		// �߰� �ʵ� �� �޼ҵ� ���, �μ���ȣ
		admin.setDeptNo("10000");
		sendMessage(admin); // param : User user <- Admin admin

		// ����� ���
		Member member = new Member();
		// ��ӹ��� user�� �޼ҵ� �� �ʵ带 �״�� ��� ������
		member.setId("kim");
		member.setName("������");
		member.setPhone("789787878787");
		member.printUserInfo();
		// �߰� �ʵ� �� �޼ҵ� ���, ����Ʈ
		member.setPoint(10000);
		sendMessage(member); // param : User user <- Member member
	}

	// �θ�Ÿ������ �Ű������� ����
	public static void sendMessage(User user) {
		System.out.println("");
		System.out.println(user.getPhone() + ": �������� �޼����� �����ϴ�");
	}

}
