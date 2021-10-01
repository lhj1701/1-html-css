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

	// postFix : 뒤쪽에 붙는 글자
	// prefix : 앞쪽에 붙는 글자
	public void println(String s, int i, String postFix) {
		System.out.println(i + " " + s + postFix);
	}
}
