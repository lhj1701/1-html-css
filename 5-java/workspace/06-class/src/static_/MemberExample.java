package static_;

public class MemberExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member member1 = new Member("홍길동", "Hong");
		Member member2 = new Member("보바", "babo");

		// static 변수에 접근하는 방법은 클래스명.변수명
		System.out.println(Member.serviceName + ", 이름 :" + member1.name + ", id:" + member1.id);
		System.out.println(Member.serviceName + ", 이름 :" + member1.name + ", id:" + member2.id);

		Member.printNameWithServiceName(member1.name);
		Member.printNameWithServiceName(member2.name);

		System.out.println("회원수: " + Member.memeberCount);
		singleton.Calculator calc = singleton.Calculator.getInstance();
		calc.getAreaCircle(25);

	}
}
