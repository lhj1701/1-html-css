package com.git.myworkspace.contact;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
	private ContactRepository repo;

	@Autowired
	public ContactController(ContactRepository repo) {
		this.repo = repo;
	}

	@GetMapping(value = "/contacts")
	public List<Contact> getContacts() throws InterruptedException {
		return repo.findAll(Sort.by("id").descending());
	}

	// ex) �� ������ 2��. 1��° ������ GET /contacts/paging?page=0&size=2
	@GetMapping("/contacts/paging")
	public Page<Contact> getContactsPaging(@RequestParam int page, @RequestParam int size) {
		// findAll(Pageable page) ��ü �����ϱ�
		// findAll(PageRequest.of(page, size, sort)) -> �������
		return repo.findAll(PageRequest.of(page, size, Sort.by("id").descending()));
	}

	// POST/contacts- 1�� �߰�
	@PostMapping(value = "/contacts")
	public Contact addContact(@RequestBody Contact contact, HttpServletResponse res) throws InterruptedException {

		// if ((contact.getName() == null || contact.getName().isEmpty())
		// || (contact.getPhone() == null || contact.getPhone().isEmpty())
		// || (contact.getEmail() == null || contact.getEmail().isEmpty())) -> �̸�, ��ȭ��ȣ,
		// ���ϰ��� �� �� �ϳ��� ������ ����ó��

		if ((contact.getName() == null || contact.getName().isEmpty())
				|| (contact.getPhone() == null || contact.getPhone().isEmpty())) { // -> �̸� ��ȭ��ȣ �� �� �ϳ��� ������ ���� ó��
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		Contact contactItem = Contact.builder().name(contact.getName()).phone(contact.getPhone())
				.email(contact.getEmail()).memo(contact.getMemo()).createdTime(new Date().getTime()).build();

		Contact contactSaved = repo.save(contactItem);
		// ���ҽ� ������
		res.setStatus(HttpServletResponse.SC_CREATED);
		// �߰��� ��ü�� ��ȯ
		return contactSaved;

	}

	@DeleteMapping(value = "/contacts/{id}")
	public boolean removeContact(@PathVariable long id, HttpServletResponse res) {

		Optional<Contact> contact = repo.findById(Long.valueOf(id));
		if (contact.isEmpty()) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return false;
		}
		// ���� ����
		repo.deleteById(id);
		return true;
	}

	@PutMapping(value = "/contacts/{id}")
	public Contact modifyContact(@PathVariable long id, @RequestBody Contact contact, HttpServletResponse res) {
		Optional<Contact> contactItem = repo.findById(Long.valueOf(id));
		if (contactItem.isEmpty()) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		// if ((contact.getName() == null || contact.getName().isEmpty())
		// || (contact.getPhone() == null || contact.getPhone().isEmpty())
		// || (contact.getEmail() == null || contact.getEmail().isEmpty())) -> �̸�, ��ȭ��ȣ,
		// ���ϰ��� �� �� �ϳ��� ������ ����ó��

		// �̸�, ����ȣ �Է°��� �� �� �ϳ��� ������ ����ó����
		if ((contact.getName() == null || contact.getName().isEmpty())
				|| (contact.getPhone() == null || contact.getPhone().isEmpty())) {
			// Ŭ���̾�Ʈ���� �̸����� ���� �����ų� ������ ���� ��, Dispatcher Servlet�� ������ ���䰴ü�� status�ڵ带 �־���
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}

		Contact contactToSave = contactItem.get();

		// ������ ����
		contactToSave.setName(contact.getName());
		contactToSave.setPhone(contact.getPhone());
		contactToSave.setEmail(contact.getEmail());
		contactToSave.setMemo(contact.getMemo());

		Contact contactSaved = repo.save(contactToSave);
		return contactSaved;
	}

//	// html �±׸� �����ϴ� �޼ҵ�
//	private String getPlainText(String text) {
//		return text.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
//	}
}
