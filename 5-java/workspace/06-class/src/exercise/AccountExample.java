package exercise;

public class AccountExample {

	public static void main(String[] args) {

		// test case-> �ڵ�� ¥�� -> �׽�Ʈ�ڵ� -> ���� �׽�Ʈ���� ���� -> ��� �ڵ��� �޼ҵ带 �׽�Ʈ
		// test case ����(event-flow) : �ܰ��(balance)�� �ܰ��� ����
		// expected result : 0~100�� ������ ���� �������� ���� �ܰ�׿� ��ȭ�� �������, �� ���� ���� ���� �ÿ��� �ܰ���� ����

		// given - �׽�Ʈȯ�� �غ� (�׽�Ʈ�� ������, �׽�Ʈ�� ��ü)
		Account account = new Account(); // �׽�Ʈ�� ��ü
		int[] testValues = { 10000, -100, 2000000, 300000 };

		// when - �׽�Ʈ �����ͷ� �׽�Ʈ ���̽� ����
		account.setBalance(testValues[0]);

		// ���� ����� - ������ ��
		int expectedResult = testValues[0];
		int actualResult = account.getBalance();

		if (actualResult == expectedResult) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		// ������ : 10000
		// then - expected result �������� actual result ���� ����� ��
		System.out.println("���� �ܰ�: " + account.getBalance());

		// ��� �ڵ��� �޼��带 ��� ������ ��쿡�� test coverage�� 100%

		// ���� ����� : �� ��쿡�� ���� ��
		expectedResult = account.getBalance();
		account.setBalance(testValues[1]);
		if (actualResult == expectedResult) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}

		// 0, 1�鸸, -1, 1.. �� ��谪���� �׽�Ʈ�غ�����

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
