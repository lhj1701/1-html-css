package com.git.controller;

//값이 같은지를 비교하는 static 메서드
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
		// given : 테스트 데이터 및 객체 준비

		ContactController controller = new ContactController();
		Contact expected = Contact.builder().id(1).name("naaaame").phone("01012345678").email("qq@ww").createdTime(1)
				.build();
		// when : 실제 테스트케이스 수헹
		// ServletResponse 객체는 가짜(mock을 넣어줌)
		controller.addContact(expected, new MockHttpServletResponse());
		// then : 예상결과와 실제 결과를 비교
		// 전체 목록에서 추가한 애를 가져옴
		List<Contact> contacts = controller.getContacts();
		Contact actual = contacts.get(0);
		// 예상결과 데이터와 실제 데이터를 비교함
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getPhone(), actual.getPhone());
		assertEquals(expected.getEmail(), actual.getEmail());

	}

	@Test
	void removeContact() {
		// given - 테스트 데이터 및 객체 준비 : 사전 조건이 있다면 사전 조건을 준비하는 단계
		// 1건 추가가 되어있어야함
		ContactController controller = new ContactController();
		Contact testItem = Contact.builder().name("naaaame").phone("01012345678").email("qq@ww").createdTime(1).build();

		controller.addContact(testItem, new MockHttpServletResponse());
		List<Contact> beforeContacts = controller.getContacts();
		assertEquals(1, beforeContacts.size()); // 삭제 전에는 목록 크기가 1이어야함

		// when : 실제 테스트케이스 event flow수헹
		controller.removeContact(1, new MockHttpServletResponse()); // id가 1인 contact 1건을 삭제

		// then : 예상결과와 실제 결과를 비교
		// 목록을 조회했을 때 목록의 크기가 0이어야함
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
