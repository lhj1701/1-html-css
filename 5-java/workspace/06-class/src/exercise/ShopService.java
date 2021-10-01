package exercise;

public class ShopService {

// singleton 만들기

	// 객체 생성을 못하니까 static 객체 변수 선언
	private static ShopService shopServie;

	// 기본 생성자를 private - 객체 생성 못하게
	private ShopService() {

	}

	// 객체를 반환하는 메서드
	public static ShopService getInstance() {
		// null 일때 (초기상태)일때만
		// 객체를 한 번 생성함
		// 그 다음부터는 이전에 생성된 객체를 반환
		if (shopServie == null) {
			shopServie = new ShopService();
		}

		return shopServie;
	}
}
