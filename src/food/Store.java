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
		// 음식 매니
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
		
		for (User u : userMgr.getList()) { // user에 foodList(선호 음식), myFridge(보유 재료) 내용 추가
				u.readtxt("FoodList.txt", u.getFoodList());
				u.readtxt("MyFridge.txt", u.getMyFridgeList());
		}
		
		// 각 음식 매니저 출력
		System.out.println("==음식 목록==");
		while (true){
			System.out.print("(1)이름순 (2)가격 낮은 순 (3)가격 높은 순 (4)좋아요순 (5)종료: ");//우선 스위치문으로 구분해두었습니다.
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
				case 4://좋아요 순
					Collections.sort(foodMgr.getList(), new Comparator<Food>() {
						@Override
						public int compare(Food o1, Food o2) {
							if (o1.like < o2.like)
								return 1;
							if (o1.like > o2.like)
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

		System.out.println("==사용자 목록==");
		userMgr.printAll();

		// 로그인 성공할 경우 서치기능 구현
		if (Login()){
			searchMenu();
		}
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
					fridgeSearch();
					break;
				default:
					bool = false;
			}
		}
	}

	// 보유 재료를 하나씩 요소로 사용하여 food매니저가 가지고 있는 food들을 순회하며 재료에 포함되어있는지 확인
	public void fridgeSearch(){
		// 현재 구조적 한계로 인해 다중 for문 사용. 추후 수정 예정
		for (User u: userMgr.getList()){
			for (String fridge: u.getMyFridgeList()) {
				for (Food f : foodMgr.getList()) {
					if (f.matches(fridge))
						u.getFridgeSearchList().add(f);
				}
			}
		}

		System.out.format("\n==보유한 재료가 포함된 음식 목록==\n");
		for (User u: userMgr.getList()) {
			for (Food f: u.getFridgeSearchList()) {
				f.print();
			}
			u.getFridgeSearchList().clear();
		}

	}

	public boolean Login(){
		System.out.print("id를 입력해 주세요: ");
		String id = scan.next();
		System.out.print("pw를 입력해 주세요: ");
		String pw = scan.next();
		// user정보를 가진 리스트를 순회하며 동일한 id와 pw가 존재하는지 확인
		for (User u: userMgr.getList()){
			if (u.UserLogin(id, pw)) {
				System.out.println("Login Succes");
				return true;
			}
		}
		System.out.println("Login 실패. 프로그램을 종료합니다.");
		return false;
	}

	public static void main(String[] args) {
		new Store();
	}
}