package string;

public class StringExample {

	public static void main(String[] args) {
		String name1 = "lhj"; // �ڹٿ����� ���ڿ� �ֵ���ǥ��
		String name2 = "lhj";
		System.out.println(name1 == name2); // String ��ġ�񱳿��� �� ��� ���� ����
		System.out.println(name1.equals(name2));
//		!! String�� ��� ��ġ�񱳿� equal �Լ� ���

		String name3 = new String("lhj"); // �ڹٿ����� ���ڿ� �ֵ���ǥ��
		String name4 = new String("lhj");

		// String ��ġ�񱳿��� �� ��� ���� ����
		System.out.println(name3 == name4);
		System.out.println(name3.equals(name4));
//		!! String�� ��� ��ġ�񱳿� equal �Լ� ���
	}

}
