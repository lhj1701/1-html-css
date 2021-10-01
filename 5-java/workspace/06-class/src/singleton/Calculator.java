package singleton;

//static  ����� ����
//static �ʵ�, �޼���

//��ü�� ���� Ŭ������ �ƴ�! �ʵ尪, �޼��带 ������� �������� �����ϴ� Ŭ����
// singleton Ŭ������ ����� �ܺο��� ��ü ������ ���ϰ� ��
// ��ü���� �޼��带 �̿��ؼ� ������ ������ ��ü�� �����ؼ� ����ϰ� ��
// -> ������ ��ü ������ private static Ŭ����Ÿ�� ��ü�� = new ������;
public class Calculator {

	// 2.private static �ʵ�� ��ü�� ������ <- ���α׷��� ����� �� ���� �ʱ�ȭ�� �Ͼ
	// Calculator�� ������� �ʴ��� �޸� ������ �ʱ�ȭ��
//	private static Calculator calc = new Calculator();
	private static Calculator calc;
	private final static double PI = 3.141592;

	// 1.�⺻ �����ڸ� �ܺο��� ���� ���ϰ� ��
	private Calculator() {
	}

	// 3. �ܺο��� private static���� ������ ��ü�� ������ �� �ְ� ��
	public static Calculator getInstance() {
		// Calculator ��ü�� ����� ������ �޸� ������ �ʱ�ȭ��
		if (calc == null) {
			calc = new Calculator();
		}
		return calc;
	}

	public int plus(int a, int b) {
		return a + b;
	}

	public int minus(int a, int b) {
		return a - b;
	}

	public double getAreaCircle(int r) {
		return r * r * this.PI;
	}
	// �̱��� : ���α׷� ���ο� ������ ��ü�� ������ ���� ��ü ���� ����
}
