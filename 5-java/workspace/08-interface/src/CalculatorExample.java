
public class CalculatorExample {
	public static void main(String[] args) {
		// ���ͤ��̽��� ��ü�� ������ �� ��� ����
//	Calculator c = new Calculator();

//		Calculator c = new CalculatorMock(); // ���Ŭ������ �ϴ� ���
//		Calculator c = new CalculatorImplV1();// Ŭ���� ������ �Ϸ�� -> ������ �ɷ� ���Ƴ�
		Calculator c = new CalculatorImplV2();// Ŭ���� ������ �Ϸ�� -> ���ο� �������� ���Ƴ�

		System.out.println(c.plus(5, 10));
		System.out.println(c.minus(5, 10));
		System.out.println(c.areaCircle(5));
	}
}
