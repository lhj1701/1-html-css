package super_constructor;

public class Child extends Parent {
	public String name;

	// 호출 1번
	public Child() {
		// super(); // 암시적(자동)으로 호출이됨
		this("홍길동"); // Child("홍길동") 호출
		// 출력4
		System.out.println("Parent()call");
	}

	// 호출 4번
	public Child(String name) {

		this.name = name;
		// 출력 3번
		System.out.println("Child(String name) call");
	}
}
