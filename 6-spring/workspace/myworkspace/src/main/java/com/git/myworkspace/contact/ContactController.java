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

	// ex) 한 페이지 2개. 1번째 페이지 GET /contacts/paging?page=0&size=2
	@GetMapping("/contacts/paging")
	public Page<Contact> getContactsPaging(@RequestParam int page, @RequestParam int size) {
		// findAll(Pageable page) 객체 생성하기
		// findAll(PageRequest.of(page, size, sort)) -> 생성방법
		return repo.findAll(PageRequest.of(page, size, Sort.by("id").descending()));
	}

	// POST/contacts- 1건 추가
	@PostMapping(value = "/contacts")
	public Contact addContact(@RequestBody Contact contact, HttpServletResponse res) throws InterruptedException {

		// if ((contact.getName() == null || contact.getName().isEmpty())
		// || (contact.getPhone() == null || contact.getPhone().isEmpty())
		// || (contact.getEmail() == null || contact.getEmail().isEmpty())) -> 이름, 전화번호,
		// 메일값이 셋 중 하나라도 없으면 에러처리

		if ((contact.getName() == null || contact.getName().isEmpty())
				|| (contact.getPhone() == null || contact.getPhone().isEmpty())) { // -> 이름 전화번호 둘 중 하나라도 없으면 에러 처리
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		Contact contactItem = Contact.builder().name(contact.getName()).phone(contact.getPhone())
				.email(contact.getEmail()).memo(contact.getMemo()).createdTime(new Date().getTime()).build();

		Contact contactSaved = repo.save(contactItem);
		// 리소스 생성됨
		res.setStatus(HttpServletResponse.SC_CREATED);
		// 추가된 객체를 반환
		return contactSaved;

	}

	@DeleteMapping(value = "/contacts/{id}")
	public boolean removeContact(@PathVariable long id, HttpServletResponse res) {

		Optional<Contact> contact = repo.findById(Long.valueOf(id));
		if (contact.isEmpty()) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return false;
		}
		// 삭제 수행
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
		// || (contact.getEmail() == null || contact.getEmail().isEmpty())) -> 이름, 전화번호,
		// 메일값이 셋 중 하나라도 없으면 에러처리

		// 이름, 폰번호 입력값이 둘 중 하나라도 없으면 에러처리함
		if ((contact.getName() == null || contact.getName().isEmpty())
				|| (contact.getPhone() == null || contact.getPhone().isEmpty())) {
			// 클라이언트에서 이름값이 없이 보내거나 빈값으로 보낸 것, Dispatcher Servlet이 생성한 응답객체에 status코드를 넣어줌
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}

		Contact contactToSave = contactItem.get();

		// 데이터 변경
		contactToSave.setName(contact.getName());
		contactToSave.setPhone(contact.getPhone());
		contactToSave.setEmail(contact.getEmail());
		contactToSave.setMemo(contact.getMemo());

		Contact contactSaved = repo.save(contactToSave);
		return contactSaved;
	}

//	// html 태그를 제거하는 메소드
//	private String getPlainText(String text) {
//		return text.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
//	}
}
