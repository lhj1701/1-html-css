package singleton;

public class CalculatorExample {

	public static void main(String[] args) {
		// 이미 생성되어있는 Calculator 객체를 가져와서 사용
		// 객체를 출력하면 클래스타입@객체의 해시코드
		Calculator calc = Calculator.getInstance();
		System.out.println(calc);
		calc.getAreaCircle(5);
		calc.plus(10, 5);

		Calculator calc1 = Calculator.getInstance();
		System.out.println(calc1);
		calc.getAreaCircle(10);
	}

}
