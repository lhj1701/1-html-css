package casting;

import override.Admin;
import override.Member;
import override.User;

public class UserExample {

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
		Admin admin2 = (Admin) user; // Admin <- amdin ������

		// ����� ���
		user = new Member();
		// ��ӹ��� user�� �޼ҵ� �� �ʵ带 �״�� ��� ������
		user.setId("kim");
		user.setName("������");
		user.setPhone("789787878787");
		user.printUserInfo();
		// �ڽ� ��ü�� �޼ҵ�, �ʵ�� ���Ұ�
//		user.setPoint(10000);

		// ������ Ÿ�ӿ����� ������ �߻����� ����
		// ���� Ÿ�ӿ����� ������ �߻��� Admin <- Member
		// instanceof ������ ���� �ش� Ŭ������ ��ü�� �´��� Ȯ��
		// user��ü�� Admin Ÿ���� �ν��Ͻ����� Ȯ��
		if (user instanceof Admin) {
			Admin admin3 = (Admin) user; // (Admin) Ÿ������ ���� ����ȯ
		}

		// ��� Ŭ�������� �ֻ��� �θ� Object Ŭ������
		// extends�� ���� ���� ������ ���������� extends �Ǿ��ִ� ����
		Object obj = new Object();
		obj = user;
		System.out.println(obj);
		// ������ ���� ��ü ���� ��ȯ�Ҷ��� instanceof ���
		if (obj instanceof Admin) {
			Admin admin4 = (Admin) obj;
			System.out.println(admin4);
		}
	}

}
