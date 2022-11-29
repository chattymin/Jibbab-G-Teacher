package gui;

import java.awt.event.*;
import javax.swing.*;

import main.Store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {
    public MainPage(Store store) {
        JFrame frame = new BasicFormat(store);
        frame.setTitle("메인화면");
        Font font = new Font("Binggrae",Font.PLAIN, 25);

        //마우스 커서
        Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
        Cursor clickCursor = new Cursor(Cursor.HAND_CURSOR);

        // Tips패널
        JPanel TipsPanel = new JPanel();
        TipsPanel.setLayout(null);
        TipsPanel.setBounds(5, 5, 390, 415);

        int randomNumber1;
        randomNumber1 = (int)(Math.random()*30)+1;
        ImageIcon tipImgIcon = new ImageIcon("./image/tip/Tips"+randomNumber1+".jpg");
        JLabel FirstImg = new JLabel(tipImgIcon);
        FirstImg.setBounds(0, 0, 390, 200);
        //중복 제거
        int randomNumber2;
        randomNumber2 = (int)(Math.random()*30)+1;
        while (true){
            if(randomNumber2 == randomNumber1)
                randomNumber2=(int)(Math.random()*30)+1;
            else
                break;

        }
        ImageIcon tipImgIcon2 = new ImageIcon("./image/tip/Tips"+randomNumber2+".jpg");
        JLabel SecTip = new JLabel(tipImgIcon2);
        SecTip.setBounds(0, 210, 390, 200);

        TipsPanel.add(FirstImg);
        TipsPanel.add(SecTip);

        frame.add(TipsPanel);

        // 리스트 설정 패널
        JPanel MainButtonPanel = new JPanel();
        MainButtonPanel.setLayout(null);
        MainButtonPanel.setBounds(5, 420, 390, 90);


        JButton FridgeListModify = new JButton("보유재료수정");
        FridgeListModify.setFont(font);
        FridgeListModify.setBounds(75, 5, 250, 80);
        FridgeListModify.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //마우스가 해당 컴포넌트 영역 안으로 들어올때 발생
                frame.setCursor(clickCursor);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                ////마우스가 해당 컴포넌트 영역 밖으로 나갈때 발생
                frame.setCursor(normalCursor);
            }
        });

        FridgeListModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new SetMyFridge(store);
                frame.dispose();
            }
        });


        MainButtonPanel.add(FridgeListModify);

        frame.add(MainButtonPanel);

        // 최종 설정
        frame.setVisible(true);
    }

}