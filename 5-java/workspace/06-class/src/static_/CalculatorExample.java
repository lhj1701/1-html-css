package static_;

public class CalculatorExample {

	public static void main(String[] args) {
		// �ν��Ͻ�(��ü) �������ϰ� �ٷ� ��� ����
		// �ַ� ���� ���� ���̳� ��ɵ��� static���� �����Ͽ� ��밡��
		System.out.println(Calculator.pi);
		System.out.println(Calculator.plus(10, 5));
		System.out.println(Calculator.getAreaCircle(5));

		// static ���� ���� ���� ������
		// �������ϰ� �����ϰ� ����
//		Calculator.pi = 3.14;

		// ��ü�� �����ؼ� ���ٴ� �� ū �ǹ̰� ����
//		Calculator calc = new Calculator();
	}

}
