package com.example.testlombok;

import lombok.Data;

// �Һ� �÷������� java�ڵ带 �������� ��(������ ��) �Һ� ������̼ǵ�(��)-@Data)�� �ִ� Ŭ����/�������̽�, �ʵ�, �޼ҵ���� Ž��
// getter, setter, equals/hashcode, toString �޼ҵ带 �����ϵǴ� class ���Ͽ� �߰�����
@Data
public class Member {
private int id;
private String name;
}
