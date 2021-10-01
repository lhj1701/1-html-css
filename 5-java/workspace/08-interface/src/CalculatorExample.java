
public class CalculatorExample {
	public static void main(String[] args) {
		// 인터ㅔ이스는 객체를 생성할 수 없어서 에러
//	Calculator c = new Calculator();

//		Calculator c = new CalculatorMock(); // 목업클래스로 일단 사용
//		Calculator c = new CalculatorImplV1();// 클래스 구현이 완료됨 -> 구현된 걸로 갈아낌
		Calculator c = new CalculatorImplV2();// 클래스 구현이 완료됨 -> 새로운 버전으로 갈아낌

		System.out.println(c.plus(5, 10));
		System.out.println(c.minus(5, 10));
		System.out.println(c.areaCircle(5));
	}
}
