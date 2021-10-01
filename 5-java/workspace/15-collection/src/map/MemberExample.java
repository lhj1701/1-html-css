package map;

import java.util.HashMap;
import java.util.Map;

public class MemberExample {

	public static void main(String[] args) {
		// map Ű�� �ߺ��� ����
		// Map<ŰŸ��, ��Ÿ��>
		// �Ű������� �־��ִ� Ÿ�� : ���׸�
		// Ű : Member�� id, �� : Member ��ü
		Map<String, Member> members = new HashMap<String, Member>();

// 1. ��ü �߰�
// ���ο� ��ü�� �����ϰ�, map ������ put �޼ҵ�� �߰�
//		Member hong = new Member("hong", "password123", "ȫ�浿", 20);
//		members.put("hong",hong)
		members.put("hong", new Member("hong", "password123", "ȫ�浿", 20));
		members.put("John", new Member("John", "smiiiii", "SMith", 40));

// ���� Ű�� �� ��ü�� ������ �� ��ü�� ���� ������(������ �Ͼ)

// 2.�ʿ��� 1���� ���� ��ȸ
// �ʺ���.get(Ű��)
		Member m = members.get("hong");
		System.out.println("----1�� ��ȸ----");
		System.out.println(m.getName() + ", " + m.getAge());

// 3. �� ��� ��ȸ
// �ʺ���.keySet() => ���� key ����� set������ �ڷᱸ���� ��ȯ
// set : �ߺ����� ���� �ڷᱸ��
		System.out.println("----��� ��ȸ----");
		for (String id : members.keySet()) {
			// {"hong","john"}
			String name = members.get(id).getName();
			int age = members.get(id).getAge();
			System.out.println(id + ": " + name + ", " + age);
		}

		System.out.println("----��� ��ȸ----");
		for (Member member : members.values()) {
			String name = member.getName();
			int age = member.getAge();
			System.out.println(member.getId() + ": " + name + ", " + age);
		}
// 4. ���� �� ��ü�� �ʵ� ���� ����
		// 1���� ������ �Ŀ� �ʵ� ����
		Member mHong = members.get("hong");
		System.out.println("----1�� ��ȸ----");
		System.out.println(mHong.getName() + ", " + mHong.getAge());
		mHong.setAge(25); // �ʵ尪 ����
		System.out.println("----1�ǿ� ���Ͽ� �ʵ尪 ���� ��ȸ----");
		System.out.println(mHong.getName() + ", " + mHong.getAge());

// 5. ���� ��� 1���� ����
		// �ʺ���.remove(Ű)
		members.remove("John");
		System.out.println("���� �� ��� ��ȸ");
		for (Member member : members.values()) {
			String name = member.getName();
			int age = member.getAge();
			System.out.println(member.getId() + ": " + name + ", " + age);
		}

// �ʺ���.clear() // ��ü ����
		members.clear();
		System.out.println("��ü ���� �� ��� ��ȸ");
		for (Member member : members.values()) {
			String name = member.getName();
			int age = member.getAge();
			System.out.println(member.getId() + ": " + name + ", " + age);
		}
// members.size() // �� ũ��
// members.isEmpty() // �� ��Ұ� �ִ���, true��  ��Ҿ���
// �ش� Ű�� �ִ��� üũ, true�� �ش� Ű�� ����
		members.containsKey(mHong);
	}
}
