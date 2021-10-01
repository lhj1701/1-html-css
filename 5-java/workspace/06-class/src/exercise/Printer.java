package exercise;

public class Printer {
	public void println(int i) {
		System.out.println(i);
	}

	public void println(boolean b) {
		System.out.println(b);
	}

	public void println(double d) {
		System.out.println(d);
	}

	public void println(String s) {
		System.out.println(s);
	}

	public void println(String s, int i) {
		System.out.println(i + " " + s);
	}

	// postFix : ���ʿ� �ٴ� ����
	// prefix : ���ʿ� �ٴ� ����
	public void println(String s, int i, String postFix) {
		System.out.println(i + " " + s + postFix);
	}
}
