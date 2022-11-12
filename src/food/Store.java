package food;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import mgr.Factory;
import mgr.Manager;

public class Store extends Manager {
	public Manager<Food> foodMgr = new Manager<>();
	public Manager<User> userMgr = new Manager<>();
	public ArrayList<Manager> totalList = new ArrayList<>();// 각 foodMgr를 전부 담아놓는 리스트

	Scanner scan = new Scanner(System.in);

	public Store() {
		// 각각 음식들 매니저 분리
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

		// 각 음식 매니저 출력
		System.out.println("==음식 목록==");
		while (true){
			System.out.println("(1)이름순 (2)가격 낮은 순 (3)가격 높은 순 (4)좋아요순 (5)종료:");//우선 스위치문으로 구분해두었습니다.
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

		// 각 음식들 전부 totalList에 추가
		totalList.add(foodMgr);

		System.out.println("==사용자 목록==");
		userMgr.printAll();

		// 로그인 성공할 경우 서치기능 구현
		if (Login()){
			totalSearch();
		}
	}

	// 종합검색: 나라별 검색, 재료 검색 가리지 않고 모든 음식들 중 kwd에 해당하는 내용 출력
	public void totalSearch() {
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