package polymorphism;

// ����� �� ����� �ִ� ����� (���� �����)
public class Member extends User {

	private int point;

	// �޼ҵ� �������̵� : �޼ҵ带 �������Ѵ�
	// �޼ҵ� �ñ״��� : �޼ҵ�� + �Ű�����(Ÿ��, ����, ����)
	// �θ��� �޼ҵ�� �޼ҵ� �ñ״��Ĵ� �����ؾ���
	// �����ϸ� @Override���ִ°� ����, �׷��� �������Ѱ��� �� �� ����
	@Override
	public void printUserInfo() {
		// ���� ������ �ٸ�
		// 1. ���� ���� ����
//		System.out.println(this.getName() + ", " + this.getPhone() + " - ����Ʈ : " + this.point);

		// 2. �θ� �޼ҵ带 ��Ȱ��
		super.printUserInfo();
		System.out.print(" - ����Ʈ : " + this.point);
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}
