package com.git.myworkspace.photo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// photo ���̺� �����ϴ� ��ü
// PhotoRepository -> JpaRepository -> PagingAndSortingRepository -> CrudRepository
// JpaRepository���� ������ ó���� ���� �⺻���� �޼ҵ���� ����Ǿ�����
// JpaRepository<Photo, Long>
// JpaRepository<��ƼƼŸ��, idŸ��>
// ��ƼƼ(SE(����Ʈ�����Ͼ),�����Ͱ�ü)==���̺�(DB,�����Ͱ�ü)

// photo ���̺� ������ �� �ִ� �⺻���� �޼ҵ���� ����� �� ����
@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

}
