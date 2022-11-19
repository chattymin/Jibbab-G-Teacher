package food;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import mgr.Factory;
import mgr.Manager;

public class Store extends Manager {
	public Manager<Food> foodMgr = new Manager<>();
	public Manager<User> userMgr = new Manager<>();
	
	Scanner scan = new Scanner(System.in);

	public Store() {
		// 음식 매니저
		foodMgr.readAll("Foods.txt", new Factory<Food>() {
			@Override
			public Food create() {
				return new Food();
			}
		});


		// 사용자 매니저
		userMgr.readAll("User.txt", new Factory<User>() {
			@Override
			public User create() {
				return new User();
				}
		});
		
		// 음식 목록 정렬 후 출력
		System.out.println("==음식 목록==");
		while (true){
			//우선 스위치문으로 구분해두었습니다.
			System.out.print("(1)이름순 (2)가격 낮은 순 (3)가격 높은 순 (4)좋아요순 (5)종료: ");
			int n = scan.nextInt();
			if (n < 1 || n > 4) break;
			switch (n){
				case 1://이름순
					Collections.sort(foodMgr.getList());
					foodMgr.printAll();
					break;
				case 2://가격 낮은 순
					Collections.sort(foodMgr.getList(), new Comparator<Food>() {
						@Override
						public int compare(Food o1, Food o2) {
							if (o1.price > o2.price)
								return 1;
							if (o1.price < o2.price)
								return -1;
							return 0;
						}
					});
					foodMgr.printAll();
					break;
				case 3://가격 높은 순
					Collections.sort(foodMgr.getList(), new Comparator<Food>() {
						@Override
						public int compare(Food o1, Food o2) {
							if (o1.price < o2.price)
								return 1;
							if (o1.price > o2.price)
								return -1;
							return 0;
						}
					});
					foodMgr.printAll();
					break;
				default:
					break;
			}
		}

		System.out.println("==사용자 정보==");
		userMgr.printAll();

		searchMenu();
	}

	// 검색이 두종류로 나뉨에 따라 searchMenu생성
	public void searchMenu() {
		int sort = 0;
		boolean bool = true;
		while (bool) {
			System.out.print("(1)종합 검색 (2)보유 재료로 검색 (그 외)종료: ");
			sort = scan.nextInt();
			switch (sort){
				case 1:
					foodMgr.search();
					break;
				case 2:
					userMgr.getList().get(0).fridgeSearch(foodMgr);
					break;
				default:
					bool = false;
			}
		}
	}

	public static void main(String[] args) {
		new Store();
	}
}