package string;

public class StringExample {

	public static void main(String[] args) {
		String name1 = "lhj"; // 자바에서는 문자열 쌍따옴표만
		String name2 = "lhj";
		System.out.println(name1 == name2); // String 동치비교에서 이 방법 쓰지 말것
		System.out.println(name1.equals(name2));
//		!! String인 경우 동치비교에 equal 함수 사용

		String name3 = new String("lhj"); // 자바에서는 문자열 쌍따옴표만
		String name4 = new String("lhj");

		// String 동치비교에서 이 방법 쓰지 말것
		System.out.println(name3 == name4);
		System.out.println(name3.equals(name4));
//		!! String인 경우 동치비교에 equal 함수 사용
	}

}
