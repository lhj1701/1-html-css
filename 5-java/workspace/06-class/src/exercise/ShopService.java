package exercise;

public class ShopService {

// singleton �����

	// ��ü ������ ���ϴϱ� static ��ü ���� ����
	private static ShopService shopServie;

	// �⺻ �����ڸ� private - ��ü ���� ���ϰ�
	private ShopService() {

	}

	// ��ü�� ��ȯ�ϴ� �޼���
	public static ShopService getInstance() {
		// null �϶� (�ʱ����)�϶���
		// ��ü�� �� �� ������
		// �� �������ʹ� ������ ������ ��ü�� ��ȯ
		if (shopServie == null) {
			shopServie = new ShopService();
		}

		return shopServie;
	}
}
