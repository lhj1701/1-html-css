// 2. 인터페이스 규격에 맞게 목업클래스를 만듦
// 목업클래스는 실제 작동은 아니고 에러 안나게 가짜값만 처리
// implement : 구현하다
// 구현클래스명 implements Calculator
public class CalculatorMock implements Calculator {

	@Override
	public int plus(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int minus(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double areaCircle(int r) {
		// TODO Auto-generated method stub
		return 0.0;
	}

}
