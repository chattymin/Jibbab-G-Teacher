package gui;

import javax.swing.*;

import food.Store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BasicFormat extends JFrame{
    //저희 프로그램의 기본 포멧을 여기에 만들어뒀고, 호출해서 사용하시면 됩니다.

    public BasicFormat(Store store){
        // 마우스 커서
        Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
        Cursor clickCursor = new Cursor(Cursor.HAND_CURSOR);

        //버튼을 만들 패널
        JPanel buttonPanel = new JPanel();
        buttonPanel.setVisible(true);
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(5, 510, 390,100);

        // homeButton
        ImageIcon homeImg = new ImageIcon("./image/home.png");
        JButton home =  new JButton("home",homeImg);
        home.setBorderPainted(false); // 버튼 테두리 설정해제
        home.setContentAreaFilled(false); // 뒤의 버튼 배경(?)이 계속 생겨서 써놓은 메소드입니다
        home.setBounds(10,5,90,90);
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainPage(store);
                dispose();
            }
        });
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //마우스가 해당 컴포넌트 영역 안으로 들어올때 발생
                setCursor(clickCursor);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                ////마우스가 해당 컴포넌트 영역 밖으로 나갈때 발생
                setCursor(normalCursor);
            }
        });

            // searchButton
        ImageIcon searchImg = new ImageIcon("./image/search.png");
        JButton search =  new JButton(searchImg);
        search.setBorderPainted(false); // 버튼 테두리 설정해제
        search.setContentAreaFilled(false);
        search.setBounds(110,5,90,90);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new SearchSelection(store);
                dispose();
            }
        });
        search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //마우스가 해당 컴포넌트 영역 안으로 들어올때 발생
                setCursor(clickCursor);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                ////마우스가 해당 컴포넌트 영역 밖으로 나갈때 발생
                setCursor(normalCursor);
            }
        });

        // fridgeButton
        ImageIcon fridgeImg = new ImageIcon("./image/fridge.png");
        JButton fridge =  new JButton(fridgeImg);
        fridge.setBorderPainted(false); // 버튼 테두리 설정해제
        fridge.setContentAreaFilled(false);
        fridge.setBounds(200,5,90,90);
        fridge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyFridge(store);
                dispose();
            }
        });
        fridge.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //마우스가 해당 컴포넌트 영역 안으로 들어올때 발생
                setCursor(clickCursor);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                ////마우스가 해당 컴포넌트 영역 밖으로 나갈때 발생
                setCursor(normalCursor);
            }
        });


        // likeButton
        ImageIcon likeImg = new ImageIcon("./image/like.png");
        JButton like =  new JButton(likeImg);
        like.setBorderPainted(false); // 버튼 테두리 설정해제
        like.setContentAreaFilled(false);
        like.setBounds(290,5,90,90);
        like.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LikedList(store);
                dispose();
            }
        });
        like.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //마우스가 해당 컴포넌트 영역 안으로 들어올때 발생
                setCursor(clickCursor);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                ////마우스가 해당 컴포넌트 영역 밖으로 나갈때 발생
                setCursor(normalCursor);
            }
        });

        // 패널에 버튼을 붙여준다
        buttonPanel.add(home);
        buttonPanel.add(search);
        buttonPanel.add(fridge);
        buttonPanel.add(like);

        // 메인 프레임에 메인패널을 붙여주는 작업
        add(buttonPanel);

        basicSetting();

    }

    public void basicSetting(){
        // 기본 설정
        setTitle("기본 포멧"); // 이름
        setLayout(null);
        setSize(400,640); // 가로, 세로 사이즈
        setResizable(true); // 창 크기 변경 가능 여부(false)
        setLocationRelativeTo(null); // 창이 가운데 생성되도록
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 정상 종료
    }
}
