package exercise;

public class PrinterExample {

	public static void main(String[] args) {
		Printer printer = new Printer();
		printer.println(10);
		printer.println(true);
		printer.println(5.7);
		printer.println("ȫ�浿");

		// ����Ҷ� �տ� ���ڷ����͸� �߰��ؼ� ���
		// println("ȫ�浿", 1)
		// 1 �޽����Դϴ�
		printer.println("�޽����Դϴ�", 1);

		// ����Ҷ� �տ� ���ڷ����͸� �߰��ؼ� ���
		// println("ȫ�浿",":", "--")
		// 1 �˸� �޼����Դϴ� !!
		printer.println("�˸��޽����Դϴ�", 1, "!!");
		// ����� �� �տ� ���ڷ����͸� �߰��ؼ� ��� => 1ȫ�浿
	}

}
