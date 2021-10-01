//인터페이스는 클래스의 특수 형태
// 구현체는 없고 껍데기만 있음, 구조만 있음
// 1. 설계자가 정의함
public interface Calculator {
// 추상메소드 선언
	// 메소드 본체(정의)부분이 없음
	// 계산기 기능에 3가지 기능이 있다고 정의
	int plus(int a, int b);

	int minus(int a, int b);

	double areaCircle(int r);
}
