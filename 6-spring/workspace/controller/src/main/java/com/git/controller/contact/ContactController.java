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
	public AtomicLong maxId = new AtomicLong(); // id값 생성에 사용할 변수

	// GET/contacts - 목록조회
	@GetMapping(value = "/contacts")
	public List<Contact> getContacts() {
		return new ArrayList<Contact>(contacts.values());
	}

	// POST/contacts- 1건 추가
	@PostMapping(value = "/contacts")
	public Contact addContact(@RequestBody Contact contact, HttpServletResponse res) {
		// 데이터 검증 로직
		// if ((contact.getName() == null || contact.getName().isEmpty())
		// || (contact.getPhone() == null || contact.getPhone().isEmpty())
		// || (contact.getEmail() == null || contact.getEmail().isEmpty())) -> 이름, 전화번호,
		// 메일값이 셋 중 하나라도 없으면 에러처리

		if ((contact.getName() == null || contact.getName().isEmpty())
				|| (contact.getPhone() == null || contact.getPhone().isEmpty())) { // -> 이름 전화번호 둘 중 하나라도 없으면 에러 처리
			// 클라이언트에서 메모값 없이 보내거나 빈값으로 보낸것
			// 클라이언트 오류 4XX오류 - 요청값을 잘못보낸거 -> Bad Request(400)
			// res.setStatus(400)

			// dispatcherServlet이 생성한 응답객체에 status코드를 넣어줌
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}

		// id값을 생성
		Long currentId = maxId.incrementAndGet();
		// 입력받은 데이터로 contacts객체 생성
		// id값과 생성일시는 서버에서 생성한 것으로 처리함
		Contact contactItem = Contact.builder().id(currentId)
				// html 태그가 있으면 날려버림(script 태그에서 문제가 발생함)
				.name(contact.getName()).phone(contact.getPhone()).email(contact.getEmail())
				.createdTime(new Date().getTime()).build();

		// contacts 목록객체 추가
		contacts.put(currentId, contactItem);
		// 리소스 생성됨
		// res.setStatus(201);
		res.setStatus(HttpServletResponse.SC_CREATED);
		// 추가된 객체를 반환
		return contactItem;

	}

	// DELETE /contacts/1 -> id가 1인 항목을 삭제
	// id 값이 path variable로
	@DeleteMapping(value = "/contacts/{id}")
	public boolean removeContact(@PathVariable long id, HttpServletResponse res) {
		Contact contact = contacts.get(Long.valueOf(id));
		// 해당 id의 데이터가 없으면
		if (contact == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return false;
		}
		// 삭제 수행
		contacts.remove(Long.valueOf(id));
		return false;
	}

	// PUT/contacts/1 => 1건 수정
	// id 값이 path variable로
	@PutMapping(value = "/contacts/{id}")
	public Contact modifyContact(@PathVariable long id, @RequestBody Contact contact, HttpServletResponse res) {
		Contact findItem = contacts.get(Long.valueOf(id));
		// 해당 id의 데이터가 없으면
		if (findItem == null) {
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}

		// 데이터 검증 로직

		// 이름, 번호, 메일 포함 셋 중 하나라도 없으면 에러처리
		// if ((contact.getName() == null || contact.getName().isEmpty())
		// || (contact.getPhone() == null || contact.getPhone().isEmpty())
		// || (contact.getEmail() == null || contact.getEmail().isEmpty()))

		// 이름, 폰번호 입력값이 둘 중 하나라도 없으면 에러처리함
		if ((contact.getName() == null || contact.getName().isEmpty())
				|| (contact.getPhone() == null || contact.getPhone().isEmpty())) {
			// 클라이언트에서 이름값이 없이 보내거나 빈값으로 보낸 것, Dispatcher Servlet이 생성한 응답객체에 status코드를 넣어줌
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}

		String name = getPlainText(contact.getName());
		if (name.isEmpty()) {
			res.setStatus(400);
			return null;
		}

		// 데이터 변경
		findItem.setName(getPlainText(contact.getName()));
		findItem.setPhone(getPlainText(contact.getPhone()));
		findItem.setEmail(getPlainText(contact.getEmail()));
		return findItem;

	}

	// html 태그를 제거하는 메소드
	private String getPlainText(String text) {
		return text.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
	}
}
