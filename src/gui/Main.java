package gui;

import food.Food;
import food.User;
import mgr.Manager;

import javax.swing.JFrame;

//GUI 구현을 위한 JFrame 생성 부분
public class Main {
	public Main(Food food, User user) {
		new DetailPage(food,user);
	}

	public Main(User user) {
		new MyFridge(user);
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
