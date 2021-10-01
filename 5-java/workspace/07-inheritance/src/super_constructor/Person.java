package super_constructor;

public class Person {
	public String name;
	public String phone;

	// 기본 생성자가 없음
	// 자식 클래스의 생성자에서 super();

	public Person(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

}
