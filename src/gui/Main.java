package gui;

import food.Food;
import food.Store;
import food.User;
import mgr.Manager;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

//GUI 구현을 위한 JFrame 생성 부분
public class Main {
	public Main(Store store) {
		new MainPage(store);
		
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
}