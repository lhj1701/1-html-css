package com.git.myworkspace.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JpaRepository���� ������ ó���� ���� �⺻���� �޼������ ����Ǿ�����
//JpaRepository<��ƼƼŸ��, idŸ��>
//��ƼƼ(SE, �����Ͱ�ü) == ���̺�(DB, �����Ͱ�ü)

//contact ���̺� ������ �� �ִ� �⺻���� �޼������ ����� �� ����

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
