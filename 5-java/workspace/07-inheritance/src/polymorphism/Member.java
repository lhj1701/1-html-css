package polymorphism;

// 사용자 중 멤버십 있는 사용자 (쿠팡 멤버쉽)
public class Member extends User {

	private int point;

	// 메소드 오버라이딩 : 메소드를 재정의한다
	// 메소드 시그니쳐 : 메소드명 + 매개변수(타입, 순서, 개수)
	// 부모의 메소드와 메소드 시그니쳐는 동일해야함
	// 웬만하면 @Override써주는게 좋음, 그래야 재정의한건지 알 수 있음
	@Override
	public void printUserInfo() {
		// 구현 내용은 다름
		// 1. 직접 새로 구현
//		System.out.println(this.getName() + ", " + this.getPhone() + " - 포인트 : " + this.point);

		// 2. 부모 메소드를 재활용
		super.printUserInfo();
		System.out.print(" - 포인트 : " + this.point);
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}
