package override;

public class UserExample2 {

	public static void main(String[] args) {

		// �Ϲ� �����
		User user = new User();
		user.setId("hong");
		user.setName("ȫ�浿");
		user.setPhone("010112345");

		// �θ� Ŭ���� Ĵü�� �ڽ� Ŭ���� ��ü�� ������ �� ����
		// �߿��� ���� �θ� Ŭ������ �ʵ�, �޼ҵ常 ��� ����

		// ������
		user = new Admin();
		// ��ӹ��� user�� �޼ҵ� �� �ʵ带 �״�� ��� ������
		user.setId("john");
		user.setName("�����̽�");
		user.setPhone("01045678978");
		// �ڽ� ��ü�� �޼ҵ�, �ʵ�� ���Ұ�
//		user.setDeptNo("10000");

		// ����� ���
		user = new Member();
		// ��ӹ��� user�� �޼ҵ� �� �ʵ带 �״�� ��� ������
		user.setId("kim");
		user.setName("������");
		user.setPhone("789787878787");
		user.printUserInfo();
		// �ڽ� ��ü�� �޼ҵ�, �ʵ�� ���Ұ�
//		user.setPoint(10000);
	}

}
