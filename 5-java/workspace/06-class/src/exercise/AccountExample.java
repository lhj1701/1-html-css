package exercise;

public class AccountExample {

	public static void main(String[] args) {

		// test case-> 코드로 짜면 -> 테스트코드 -> 단위 테스트에서 수행 -> 대상 코드의 메소드를 테스트
		// test case 내용(event-flow) : 잔고액(balance)에 잔고값을 대입
		// expected result : 0~100만 사이의 값을 대입했을 때는 잔고액에 변화가 없어야함, 그 외의 값을 대입 시에는 잔고액이 변경

		// given - 테스트환경 준비 (테스트용 데이터, 테스트용 객체)
		Account account = new Account(); // 테스트용 객체
		int[] testValues = { 10000, -100, 2000000, 300000 };

		// when - 테스트 데이터로 테스트 케이스 실행
		account.setBalance(testValues[0]);

		// 예상 결과값 - 대입한 값
		int expectedResult = testValues[0];
		int actualResult = account.getBalance();

		if (actualResult == expectedResult) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		// 예상결과 : 10000
		// then - expected result 예상결과와 actual result 실제 결과를 비교
		System.out.println("현재 잔고: " + account.getBalance());

		// 대상 코드의 메서드를 모두 수행한 경우에는 test coverage가 100%

		// 예상 결과값 : 이 경우에는 이전 값
		expectedResult = account.getBalance();
		account.setBalance(testValues[1]);
		if (actualResult == expectedResult) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}

		// 0, 1백만, -1, 1.. 등 경계값으로 테스트해봐야함

		expectedResult = account.getBalance();
		account.setBalance(testValues[2]);
		if (actualResult == expectedResult) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}

		expectedResult = account.getBalance();
		account.setBalance(testValues[3]);
		if (actualResult == expectedResult) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
	}

}
