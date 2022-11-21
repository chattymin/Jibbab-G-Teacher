package gui;

import food.Food;
import food.Store;
import food.User;
import mgr.Manager;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

//GUI 구현을 위한 JFrame 생성 부분
public class Main {
	public Main(Store store) {
		new SearchSelection(store);
	}

	public Main(Food food, User user) {
		new DetailPage(food, user);
	}

	public Main(User user) {
		new MyFridge(user);
	}
	
	//검색결과
	public Main(Manager<Food> foodMgr, User user) {
		//Scanner scan = new Scanner(System.in);
		//String kwd = scan.next();
		String kwd = "메인";
		new SearchResult(foodMgr,user,kwd);
	}

	//좋아요 목록
	public Main(User user, String kwd){
		new LikedList(user,kwd);
	}

	static void createAndShowGUI() {
        JFrame frame = new JFrame("FoodStoreDemo"); // GUI 창 제목 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FoodStoreDemo newContentPane = new FoodStoreDemo(); // Frame에 씌우는 FoodStoreDemo 패널 생성
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
	 // GUI 실행 메인 함수 부분
	 public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}