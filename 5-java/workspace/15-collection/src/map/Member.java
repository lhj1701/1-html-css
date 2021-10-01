package map;

public class Member {
	private String id;
	private String pw;
	private String name;
	private int age;

// 생성자를 선언
// 이름과 id를 초기화하는 생성자

	public Member(String id, String pw, String name, int age) {
		this.setName(name);
		this.setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
