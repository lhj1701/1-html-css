package singleton;

public class CalculatorExample {

	public static void main(String[] args) {
		// �̹� �����Ǿ��ִ� Calculator ��ü�� �����ͼ� ���
		// ��ü�� ����ϸ� Ŭ����Ÿ��@��ü�� �ؽ��ڵ�
		Calculator calc = Calculator.getInstance();
		System.out.println(calc);
		calc.getAreaCircle(5);
		calc.plus(10, 5);

		Calculator calc1 = Calculator.getInstance();
		System.out.println(calc1);
		calc.getAreaCircle(10);
	}

}
