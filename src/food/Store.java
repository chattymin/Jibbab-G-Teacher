package food;

import mgr.Factory;
import mgr.Manageable;
import mgr.Manager;

public class Store extends Manager implements Factory {
	public Store() {
		readAll(this, "Foods.txt");
		System.out.println("==음식 목록==");
		printAll();
		search();
	}
	
	@Override
	public Manageable create(int inherit) {
		/*
		 * 각각 상속 받는 클래스 만드시는 분께서
		 * 그 클래스에 대해 new 하도록 고쳐서 작성해주시면 될 것 같습니다.
		 * 예시)한식클래스 만드는 경우 case 1 : return new 한식();
		*/
		switch(inherit) { 
			case 0 : return new Food();
			case 1 : return new KorFood();  // 1번 수정 완료
			case 2 : return new Western();
		}
		return null;
	}

	public static void main(String[] args) {
		new Store();
	}
}
