package com.git.controller;

//���� �������� ���ϴ� static �޼���
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.git.controller.contact.Contact;
import com.git.controller.contact.ContactController;

@SpringBootTest
public class TestContactController {

	@Test
	void addContact() {
		// given : �׽�Ʈ ������ �� ��ü �غ�

		ContactController controller = new ContactController();
		Contact expected = Contact.builder().id(1).name("naaaame").phone("01012345678").email("qq@ww").createdTime(1)
				.build();
		// when : ���� �׽�Ʈ���̽� ����
		// ServletResponse ��ü�� ��¥(mock�� �־���)
		controller.addContact(expected, new MockHttpServletResponse());
		// then : �������� ���� ����� ��
		// ��ü ��Ͽ��� �߰��� �ָ� ������
		List<Contact> contacts = controller.getContacts();
		Contact actual = contacts.get(0);
		// ������ �����Ϳ� ���� �����͸� ����
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getPhone(), actual.getPhone());
		assertEquals(expected.getEmail(), actual.getEmail());

	}

	@Test
	void removeContact() {
		// given - �׽�Ʈ ������ �� ��ü �غ� : ���� ������ �ִٸ� ���� ������ �غ��ϴ� �ܰ�
		// 1�� �߰��� �Ǿ��־����
		ContactController controller = new ContactController();
		Contact testItem = Contact.builder().name("naaaame").phone("01012345678").email("qq@ww").createdTime(1).build();

		controller.addContact(testItem, new MockHttpServletResponse());
		List<Contact> beforeContacts = controller.getContacts();
		assertEquals(1, beforeContacts.size()); // ���� ������ ��� ũ�Ⱑ 1�̾����

		// when : ���� �׽�Ʈ���̽� event flow����
		controller.removeContact(1, new MockHttpServletResponse()); // id�� 1�� contact 1���� ����

		// then : �������� ���� ����� ��
		// ����� ��ȸ���� �� ����� ũ�Ⱑ 0�̾����
		List<Contact> afterContacts = controller.getContacts();
		assertEquals(0, afterContacts.size());
	}

	@Test
	void modifyContact() {
		ContactController controller = new ContactController();
		Contact testItem = Contact.builder().name("naaaame").phone("01012345678").email("qq@ww").createdTime(1).build();
		controller.addContact(testItem, new MockHttpServletResponse());

		String expectedResult = "modify test memo";

		Contact modifyData = Contact.builder().name(expectedResult).phone(expectedResult).email(expectedResult).build();
		controller.modifyContact(1, modifyData, new MockHttpServletResponse());

		List<Contact> contacts = controller.getContacts();
		assertEquals(expectedResult, contacts.get(0));

	}
}
