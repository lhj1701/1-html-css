package com.git.controller.contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
	private SortedMap<Long, Contact> contacts = Collections
			.synchronizedSortedMap(new TreeMap<Long, Contact>(Collections.reverseOrder()));
	public AtomicLong maxId = new AtomicLong(); // id�� ������ ����� ����

	// GET/contacts - �����ȸ
	@GetMapping(value = "/contacts")
	public List<Contact> getContacts() {
		return new ArrayList<Contact>(contacts.values());
	}

	// POST/contacts- 1�� �߰�
	@PostMapping(value = "/contacts")
	public Contact addContact(@RequestBody Contact contact, HttpServletResponse res) {
		// ������ ���� ����
		// if ((contact.getName() == null || contact.getName().isEmpty())
		// || (contact.getPhone() == null || contact.getPhone().isEmpty())
		// || (contact.getEmail() == null || contact.getEmail().isEmpty())) -> �̸�, ��ȭ��ȣ,
		// ���ϰ��� �� �� �ϳ��� ������ ����ó��

		if ((contact.getName() == null || contact.getName().isEmpty())
				|| (contact.getPhone() == null || contact.getPhone().isEmpty())) { // -> �̸� ��ȭ��ȣ �� �� �ϳ��� ������ ���� ó��
			// Ŭ���̾�Ʈ���� �޸� ���� �����ų� ������ ������
			// Ŭ���̾�Ʈ ���� 4XX���� - ��û���� �߸������� -> Bad Request(400)
			// res.setStatus(400)

			// dispatcherServlet�� ������ ���䰴ü�� status�ڵ带 �־���
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}

		// id���� ����
		Long currentId = maxId.incrementAndGet();
		// �Է¹��� �����ͷ� contacts��ü ����
		// id���� �����Ͻô� �������� ������ ������ ó����
		Contact contactItem = Contact.builder().id(currentId)
				// html �±װ� ������ ��������(script �±׿��� ������ �߻���)
				.name(contact.getName()).phone(contact.getPhone()).email(contact.getEmail())
				.createdTime(new Date().getTime()).build();

		// contacts ��ϰ�ü �߰�
		contacts.put(currentId, contactItem);
		// ���ҽ� ������
		// res.setStatus(201);
		res.setStatus(HttpServletResponse.SC_CREATED);
		// �߰��� ��ü�� ��ȯ
		return contactItem;

	}

	// DELETE /contacts/1 -> id�� 1�� �׸��� ����
	// id ���� path variable��
	@DeleteMapping(value = "/contacts/{id}")
	public boolean removeContact(@PathVariable long id, HttpServletResponse res) {
		Contact contact = contacts.get(Long.valueOf(id));
		// �ش� id�� �����Ͱ� ������
		if (contact == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return false;
		}
		// ���� ����
		contacts.remove(Long.valueOf(id));
		return false;
	}

	// PUT/contacts/1 => 1�� ����
	// id ���� path variable��
	@PutMapping(value = "/contacts/{id}")
	public Contact modifyContact(@PathVariable long id, @RequestBody Contact contact, HttpServletResponse res) {
		Contact findItem = contacts.get(Long.valueOf(id));
		// �ش� id�� �����Ͱ� ������
		if (findItem == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}

		// ������ ���� ����

		// �̸�, ��ȣ, ���� ���� �� �� �ϳ��� ������ ����ó��
		// if ((contact.getName() == null || contact.getName().isEmpty())
		// || (contact.getPhone() == null || contact.getPhone().isEmpty())
		// || (contact.getEmail() == null || contact.getEmail().isEmpty()))

		// �̸�, ����ȣ �Է°��� �� �� �ϳ��� ������ ����ó����
		if ((contact.getName() == null || contact.getName().isEmpty())
				|| (contact.getPhone() == null || contact.getPhone().isEmpty())) {
			// Ŭ���̾�Ʈ���� �̸����� ���� �����ų� ������ ���� ��, Dispatcher Servlet�� ������ ���䰴ü�� status�ڵ带 �־���
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}

		String name = getPlainText(contact.getName());
		if (name.isEmpty()) {
			res.setStatus(400);
			return null;
		}

		// ������ ����
		findItem.setName(getPlainText(contact.getName()));
		findItem.setPhone(getPlainText(contact.getPhone()));
		findItem.setEmail(getPlainText(contact.getEmail()));
		return findItem;

	}

	// html �±׸� �����ϴ� �޼ҵ�
	private String getPlainText(String text) {
		return text.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
	}
}
