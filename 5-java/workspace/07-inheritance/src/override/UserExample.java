package override;

public class UserExample {

	public static void main(String[] args) {

		// �Ϲ� �����
		User user = new User();
		user.setId("hong");
		user.setName("ȫ�浿");
		user.setPhone("010112345");

		// ������
		Admin admin = new Admin();
		// ��ӹ��� user�� �޼ҵ� �� �ʵ带 �״�� ��� ������
		admin.setId("john");
		admin.setName("�����̽�");
		admin.setPhone("01045678978");
		// �߰� �ʵ� �� �޼ҵ� ���, �μ���ȣ
		admin.setDeptNo("10000");

		// ����� ���
		Member member = new Member();
		// ��ӹ��� user�� �޼ҵ� �� �ʵ带 �״�� ��� ������
		member.setId("kim");
		member.setName("������");
		member.setPhone("789787878787");
		member.printUserInfo();
		// �߰� �ʵ� �� �޼ҵ� ���, ����Ʈ
		member.setPoint(10000);
	}

}
