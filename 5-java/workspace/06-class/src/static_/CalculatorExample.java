package static_;

public class CalculatorExample {

	public static void main(String[] args) {
		// 인스턴스(객체) 생성안하고 바로 사용 가능
		// 주로 자주 쓰는 값이나 기능들을 static으로 정의하여 사용가능
		System.out.println(Calculator.pi);
		System.out.println(Calculator.plus(10, 5));
		System.out.println(Calculator.getAreaCircle(5));

		// static 변수 값은 수정 가능함
		// 수정못하게 지정하고 싶음
//		Calculator.pi = 3.14;

		// 객체를 생성해서 쓴다는 게 큰 의미가 없음
//		Calculator calc = new Calculator();
	}

}
