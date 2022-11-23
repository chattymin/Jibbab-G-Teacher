package gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import food.Store;

// 검색 종류를 선택하는 검색선택 gui 구현 화면입니다
public class SearchSelection {
	public SearchSelection(Store store) {
        JFrame frame = new BasicFormat(store);
        frame.setTitle("검색 종류 선택");
        Font font = new Font("Binggrae-Bold", Font.BOLD, 14);
        
		JPanel searchMenu = new JPanel();
		searchMenu.setVisible(true);
		searchMenu.setLayout(null);
		searchMenu.setBounds(0, 0, 400, 500);
		
		JTextField kwdTextField = new JTextField("", 20);
		kwdTextField.setBounds(45, 30, 200, 25);
		JButton kwdSearch = new JButton("통합검색");
		kwdSearch.setBounds(250, 30, 95, 25);
		kwdSearch.setFont(font);
		
		ImageIcon icon = new ImageIcon("./image/searchbtn/korean.png");
		Image img = icon.getImage();
		Image korfood = img.getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		JButton searchKor = new JButton(new ImageIcon(korfood));
		searchKor.setBounds(45, 80, 60, 60);
		searchKor.setContentAreaFilled(false);
		//searchKor.setBorder(new LineBorder(Color.black, 2, true));
		JLabel korLabel = new JLabel("한식");
		korLabel.setBounds(45, 145, 60, 15);
		korLabel.setHorizontalAlignment(JLabel.CENTER);
		korLabel.setFont(font);
		
		ImageIcon icon2 = new ImageIcon("./image/searchbtn/chinese.png");
		Image img2 = icon2.getImage();
		Image chifood = img2.getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		JButton searchChi = new JButton(new ImageIcon(chifood));
		searchChi.setBounds(125, 80, 60, 60);
		searchChi.setContentAreaFilled(false);
		//searchChi.setBorder(new LineBorder(Color.black, 2, true));
		JLabel chiLabel = new JLabel("중식");
		chiLabel.setBounds(125, 145, 60, 15);
		chiLabel.setHorizontalAlignment(JLabel.CENTER);
		chiLabel.setFont(font);
		
		ImageIcon icon3 = new ImageIcon("./image/searchbtn/japanese.png");
		Image img3 = icon3.getImage();
		Image japfood = img3.getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		JButton searchJap = new JButton(new ImageIcon(japfood));
		searchJap.setBounds(205, 80, 60, 60);
		searchJap.setContentAreaFilled(false);
		//searchJap.setBorder(new LineBorder(Color.black, 2, true));
		JLabel japLabel = new JLabel("일식");
		japLabel.setBounds(205, 145, 60, 15);
		japLabel.setHorizontalAlignment(JLabel.CENTER);
		japLabel.setFont(font);
		
		ImageIcon icon4 = new ImageIcon("./image/searchbtn/western.png");
		Image img4 = icon4.getImage();
		Image westfood = img4.getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		JButton searchWest = new JButton(new ImageIcon(westfood));
		searchWest.setBounds(285, 80, 60, 60);
		searchWest.setContentAreaFilled(false);
		//searchWest.setBorder(new LineBorder(Color.black, 2, true));
		JLabel westLabel = new JLabel("양식");
		westLabel.setBounds(285, 145, 60, 15);
		westLabel.setHorizontalAlignment(JLabel.CENTER);
		westLabel.setFont(font);
		
		ImageIcon icon5 = new ImageIcon("./image/searchbtn/beef.png");
		Image img5 = icon5.getImage();
		Image beeffood = img5.getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		JButton searchBeef = new JButton(new ImageIcon(beeffood));
		searchBeef.setBounds(45, 170, 80, 80);
		searchBeef.setContentAreaFilled(false);
		//searchBeef.setBorder(new LineBorder(Color.black, 2, true));
		JLabel beefLabel = new JLabel("소고기");
		beefLabel.setBounds(45, 255, 80, 15);
		beefLabel.setHorizontalAlignment(JLabel.CENTER);
		beefLabel.setFont(font);
		
		ImageIcon icon6 = new ImageIcon("./image/searchbtn/pork.png");
		Image img6 = icon6.getImage();
		Image porkfood = img6.getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		JButton searchPork = new JButton(new ImageIcon(porkfood));
		searchPork.setBounds(155, 170, 80, 80);
		searchPork.setContentAreaFilled(false);
		//searchPork.setBorder(new LineBorder(Color.black, 2, true));
		JLabel porkLabel = new JLabel("돼지고기");
		porkLabel.setBounds(155, 255, 80, 15);
		porkLabel.setHorizontalAlignment(JLabel.CENTER);
		porkLabel.setFont(font);
		
		ImageIcon icon7 = new ImageIcon("./image/searchbtn/chicken.png");
		Image img7 = icon7.getImage();
		Image chickenfood = img7.getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		JButton searchChicken = new JButton(new ImageIcon(chickenfood));
		searchChicken.setBounds(265, 170, 80, 80);
		searchChicken.setContentAreaFilled(false);
		//searchChicken.setBorder(new LineBorder(Color.black, 2, true));
		JLabel chickenLabel = new JLabel("닭고기");
		chickenLabel.setBounds(265, 255, 80, 15);
		chickenLabel.setHorizontalAlignment(JLabel.CENTER);
		chickenLabel.setFont(font);
		
		ImageIcon icon8 = new ImageIcon("./image/searchbtn/maindish.png");
		Image img8 = icon8.getImage();
		Image maindish = img8.getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		JButton searchMainDish = new JButton(new ImageIcon(maindish));
		searchMainDish.setBounds(45, 280, 140, 80);
		searchMainDish.setContentAreaFilled(false);
		//searchMainDish.setBorder(new LineBorder(Color.black, 2, true));
		JLabel mainDishLabel = new JLabel("메인요리");
		mainDishLabel.setBounds(45, 365, 140, 15);
		mainDishLabel.setHorizontalAlignment(JLabel.CENTER);
		mainDishLabel.setFont(font);
		
		ImageIcon icon9 = new ImageIcon("./image/searchbtn/sidedish.png");
		Image img9 = icon9.getImage();
		Image sidedish = img9.getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		JButton searchSideDish = new JButton(new ImageIcon(sidedish));
		searchSideDish.setBounds(205, 280, 140, 80);
		searchSideDish.setContentAreaFilled(false);
		//searchSideDish.setBorder(new LineBorder(Color.black, 2, true));
		JLabel sideDishLabel = new JLabel("사이드요리");
		sideDishLabel.setBounds(205, 365, 140, 15);
		sideDishLabel.setHorizontalAlignment(JLabel.CENTER);
		sideDishLabel.setFont(font);
		
		ImageIcon icon10 = new ImageIcon("./image/fridge.png");
		Image img10 = icon10.getImage();
		Image ingr = img10.getScaledInstance(80, 70, Image.SCALE_DEFAULT);
		JButton searchIngr = new JButton(new ImageIcon(ingr));
		searchIngr.setBounds(45, 390, 300, 80);
		searchIngr.setContentAreaFilled(false);
		//searchIngr.setBorder(new LineBorder(Color.black, 2, true));
		JLabel ingrLabel = new JLabel("냉장고 재료로 검색");
		ingrLabel.setBounds(45, 480, 300, 15);
		ingrLabel.setHorizontalAlignment(JLabel.CENTER);
		ingrLabel.setFont(font);
		
		searchMenu.add(kwdTextField);
		searchMenu.add(kwdSearch);
		searchMenu.add(searchIngr);
		searchMenu.add(ingrLabel);
		
		searchMenu.add(searchKor);
		searchMenu.add(korLabel);
		
		searchMenu.add(searchChi);
		searchMenu.add(chiLabel);
		
		searchMenu.add(searchJap);
		searchMenu.add(japLabel);
		
		searchMenu.add(searchWest);
		searchMenu.add(westLabel);
		
		searchMenu.add(searchBeef);
		searchMenu.add(beefLabel);
		
		searchMenu.add(searchPork);
		searchMenu.add(porkLabel);
		
		searchMenu.add(searchChicken);
		searchMenu.add(chickenLabel);
		
		searchMenu.add(searchMainDish);
		searchMenu.add(mainDishLabel);
		
		searchMenu.add(searchSideDish);
		searchMenu.add(sideDishLabel);
		
		frame.add(searchMenu);
		
		frame.setVisible(true);
		
		kwdSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (e.getActionCommand().equals("통합검색")) {
        			store.foodMgr.getsearchResult().clear();
        			String kwd = kwdTextField.getText();
        			store.foodMgr.kwdSearch(kwd);
        			//new SearchResult(store);
    			}
        	}
		});
        	
		// 검색 결과 fridgesearchlist 불러오기
		searchIngr.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (e.getActionCommand().equals("냉장고 재료로 검색")) {
        			store.userMgr.getList().get(0).getFridgeSearchList().clear();	
        			store.userMgr.getList().get(0).fridgeSearch(store.foodMgr);
        			//new SearchResult(store);
            	}
        	}
		});
		
		// 검색 결과 searchresult(배열) 불러오기
		searchKor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		store.foodMgr.getsearchResult().clear();
        		store.foodMgr.kwdSearch("한식");
        		//new SearchResult(store);
            	}
        	});
		searchChi.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		store.foodMgr.getsearchResult().clear();
        		store.foodMgr.kwdSearch("중식");
        		//new SearchResult(store);
            	}
        	});
		searchJap.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		store.foodMgr.getsearchResult().clear();
        		store.foodMgr.kwdSearch("일식");
        		//new SearchResult(store);
            	}
        	});
		searchWest.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		store.foodMgr.getsearchResult().clear();
        		store.foodMgr.kwdSearch("양식");
        		//new SearchResult(store);
            	}
        	});
		searchBeef.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		store.foodMgr.getsearchResult().clear();
        		store.foodMgr.kwdSearch("소");
            	}
        	});
		searchPork.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		store.foodMgr.getsearchResult().clear();
        		store.foodMgr.kwdSearch("돼지");
            	}
        	});
		searchChicken.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		store.foodMgr.getsearchResult().clear();
        		store.foodMgr.kwdSearch("닭");
            	}
        	});
		searchMainDish.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		store.foodMgr.getsearchResult().clear();
        		store.foodMgr.kwdSearch("메인");
            	}
        	});
		searchSideDish.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		store.foodMgr.getsearchResult().clear();
        		store.foodMgr.kwdSearch("사이드");
            	}
        	});
	}
}