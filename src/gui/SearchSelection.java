package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import food.Food;
import food.Store;

// 검색 종류를 선택하는 검색선택 gui 구현 화면입니다
public class SearchSelection {
	public SearchSelection(Store store) {
		// JFrame에 기본 포멧을 New 해주시고, 해당 frame에 추가적으로 작성해서 덧붙이시면 됩니다.
        JFrame frame = new BasicFormat();
        // BasicFormat의 창 이름은 "기본 포멧"이기 때문에 현재 페이지에 맞게 이름 변경해주세요
        frame.setTitle("검색 종류 선택");
        
		JPanel searchMenu = new JPanel();
		searchMenu.setVisible(true);
		searchMenu.setLayout(null);
		searchMenu.setBounds(0, 0, 400, 500);
		
		JButton ingrSearch = new JButton("보유 재료로 검색");
		ingrSearch.setBounds(45, 100, 300, 150);
		ingrSearch.setBackground(Color.WHITE);
		ingrSearch.setBorder(new LineBorder(Color.red, 5, true));
		
		JButton categorySearch = new JButton("카테고리별 검색");
		categorySearch.setBounds(45, 280, 300, 150);
		categorySearch.setBackground(Color.WHITE);
		categorySearch.setBorder(new LineBorder(Color.green, 5, true));
		
		JTextField kwdTextField = new JTextField("", 20);
		kwdTextField.setBounds(45, 30, 200, 25);
		JButton kwdSearch = new JButton("통합검색");
		kwdSearch.setBounds(250, 30, 95, 25);
		
		searchMenu.add(kwdTextField);
		searchMenu.add(kwdSearch);
		searchMenu.add(ingrSearch);
		searchMenu.add(categorySearch);
		
		frame.add(searchMenu);
		
		frame.setVisible(true);
		
		kwdSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (e.getActionCommand().equals("통합검색")) {
        			String kwd = kwdTextField.getText();
        			store.foodMgr.kwdSearch(kwd);
    			}
        	}
		});
        	
		
		ingrSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (e.getActionCommand().equals("보유 재료로 검색")) {
        		// new ingrSearchPage();
        		frame.dispose();
            	}
        	}
		});
		
		categorySearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (e.getActionCommand().equals("카테고리별 검색")) {
        		// new cateSearchPage();
        		frame.dispose();
            	}
        	}
		});
	}
}