package condition.ifexpr;

public class IfExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String empty = "";

// java 허용안됨
// if(empty)
		int a = 10;
		if (a > 9) {
			System.out.println(a);
		}
// boolean 값의 연산만 if 문의 조건식으로 올 수 있음
		if (true) {
			System.out.println(a);
		}

	}

}
