package static_;

public class MemberExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member member1 = new Member("ȫ�浿", "Hong");
		Member member2 = new Member("����", "babo");

		// static ������ �����ϴ� ����� Ŭ������.������
		System.out.println(Member.serviceName + ", �̸� :" + member1.name + ", id:" + member1.id);
		System.out.println(Member.serviceName + ", �̸� :" + member1.name + ", id:" + member2.id);

		Member.printNameWithServiceName(member1.name);
		Member.printNameWithServiceName(member2.name);

		System.out.println("ȸ����: " + Member.memeberCount);
		singleton.Calculator calc = singleton.Calculator.getInstance();
		calc.getAreaCircle(25);

	}
}
