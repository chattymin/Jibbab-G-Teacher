package food;

import java.util.ArrayList;
import java.util.Scanner;

import mgr.Factory;
import mgr.Manager;

public class Store extends Manager {
	public Manager<KorFood> korFoodMgr = new Manager<>();
	public Manager<DessertFood> dessertFoodMgr = new Manager<>();
	public Manager<WesternFood> westernFoodMgr = new Manager<>();
	ArrayList<Manager> totalList = new ArrayList<>();// 각 foodMgr를 전부 담아놓는 리스트

	Scanner scan = new Scanner(System.in);

	public Store() {
		System.out.println("==음식 목록==");

		// 각각 음식들 매니저 분리
		korFoodMgr.readAll("KorFood.txt", new Factory<KorFood>() {
			@Override
			public KorFood create() {
				return new KorFood();
			}
		});
		westernFoodMgr.readAll("WesternFood.txt", new Factory<WesternFood>() {
			@Override
			public WesternFood create() {
				return new WesternFood();
			}
		});
		dessertFoodMgr.readAll("DessertFood.txt", new Factory<DessertFood>() {
			@Override
			public DessertFood create() {
				return new DessertFood();
			}
		});
		// 각 음식 매니저 출력
		korFoodMgr.printAll();
		westernFoodMgr.printAll();
		dessertFoodMgr.printAll();

		// 각 음식들 전부 totalList에 추가
		totalList.add(korFoodMgr);
		totalList.add(dessertFoodMgr);
		totalList.add(westernFoodMgr);

		totalSearch();

	}

	// 종합검색: 나라별 검색, 재료 검색 가리지 않고 모든 음식들 중 kwd에 해당하는 내용 출력
	void totalSearch() {
		String kwd = null;
		while (true) {
			System.out.print("\n종합 검색(end입력시 종료) : ");
			kwd = scan.next();
			if (kwd.contentEquals("end"))
				break;
			System.out.println("====검색 결과====");
			for (Manager m : totalList) {
				m.search(m.getList(), kwd);
			}
		}
	}

	public static void main(String[] args) {
		new Store();
	}
}