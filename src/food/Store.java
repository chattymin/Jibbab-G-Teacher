package food;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import gui.Main;
import mgr.Factory;
import mgr.Manager;

public class Store extends Manager {
	public Manager<Food> foodMgr = new Manager<>();
	public Manager<User> userMgr = new Manager<>();
	
	Scanner scan = new Scanner(System.in);

	public Store() {
		// 음식 매니저
		foodMgr.readAll("./txt/Foods.txt", new Factory<Food>() {
			@Override
			public Food create() {
				return new Food();
			}
		});

		// 사용자 매니저
		userMgr.readAll("./txt/User.txt", new Factory<User>() {
			@Override
			public User create() {
				return new User();
				}
		});
		/*
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
		
		//찜목록 추가 부분
    	System.out.println("찜할 음식을 입력해주세요: ");
    	addLikedFood();
    	
    	//보유 재료 추가 부분 
    	System.out.println("보유 재료를 입력해주세요: ");
    	try {
			userMgr.getList().get(0).saveMyFridge("./txt/MyFridge.txt", scan);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("----------보유 재료-----------");
    	for (String s : userMgr.getList().get(0).getMyFridgeList())
    		System.out.print(s + " ");
    	*/

		// gui의 메인 클래스를 호출하는 것이고, food객체, user객체 입니다.
		// 박동민의 page 형식에 맞는 호출 값이기 때문에 다른 분들은 다른 형식의 호출을 진행하셔도 됩니다.
		new Main(foodMgr.getList().get(0),userMgr.getList().get(0));
		// 이찬영 내 냉장고 페이지 호출
		//new Main(userMgr.getList().get(0));
		//new Main(foodMgr.getList().get(0),userMgr.getList().get(0));
		//검색결과
		// 혜은님거
		//new Main(foodMgr,userMgr.getList().get(0));
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
	
	// 음식을 입력받아서 선호음식 리스트에 저장, 동시에 세이브텍스트파일에 추가
	void addLikedFood() {
		String kwd = null;
    	kwd = scan.next();
    	Food fo = new Food(); 
    	fo = foodMgr.find(kwd);
    	userMgr.getList().get(0).getlikedList().add(fo);
    	try {
			userMgr.getList().get(0).saveLikedFood("./txt/likedSaveFile.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("----------찜 목록----------");
    	for (String s : userMgr.getList().get(0).getlikedSaveFile())
    		System.out.print(s + " ");
    	System.out.println();
    }

	public static void main(String[] args) {
		new Store();
	}
}