package exercise;

public class MemberService {

	// login(Member)
	// Member ��ü�� �޼��� �Ķ���ͷ� ����
	// dependency : �������� ����
	// Dependency<<Usage>> : �����̳� ���ó���� �ٸ� Ŭ������ �ʿ���
	boolean login(Member member) {
//		if (member.getId == "hong" && member.getPassword == "12345") {
//			return true;
//		}
		return false;
	}

	// login(String, String)
	// �����ε� : �޼��� �̸��� �����ϰ� �Ű������� Ÿ��, ����, ������ �޶����
	boolean login(String id, String password) {
		if (id == "hong" && password == "12345") {
			return true;
		} else {
			return false;
		}
	}

	void logout(String id) {
		System.out.println("�α׾ƿ��Ǿ����ϴ�");
	}
}
