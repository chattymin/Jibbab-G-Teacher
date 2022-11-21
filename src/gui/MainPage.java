package gui;

import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import food.Food;
import food.Store;
import food.User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {
    public MainPage(Store store) {
        JFrame frame = new BasicFormat(store);
        frame.setTitle("메인화면");

        // Tips패널
        JPanel TipsPanel = new JPanel();
        TipsPanel.setLayout(null);
        TipsPanel.setBounds(5, 5, 390, 415);

        int randomNumber1;
        randomNumber1 = (int) (Math.random()*2+1);
        ImageIcon tipImgIcon = new ImageIcon("./image/Tips"+randomNumber1+".JPEG");
        JLabel FirstImg = new JLabel(tipImgIcon);
        FirstImg.setBounds(0, 0, 390, 200);

        int randomNumber2;
        randomNumber2 = (int)(Math.random()*2+1);
        while (randomNumber2 != randomNumber1){
            randomNumber2 = (int)(Math.random()*2+1);
        }
        System.out.println("2:" + randomNumber2 + "1: " + randomNumber1);
        ImageIcon tipImgIcon2 = new ImageIcon("./image/Tips"+randomNumber2+".JPEG");
        JLabel SecTip = new JLabel(tipImgIcon2);
        SecTip.setBounds(0, 210, 390, 200);

        TipsPanel.add(FirstImg);
        TipsPanel.add(SecTip);

        frame.add(TipsPanel);

        // 리스트 설정 패널
        JPanel MainButtonPanel = new JPanel();
        MainButtonPanel.setLayout(null);
        MainButtonPanel.setBounds(5, 420, 390, 90);

        JButton LikedListModify = new JButton("찜 수정");
        LikedListModify.setBounds(0, 5, 190, 80);

        JButton FridgeListModify = new JButton("보유재료수정");
        FridgeListModify.setBounds(200, 5, 190, 80);

        MainButtonPanel.add(LikedListModify);
        MainButtonPanel.add(FridgeListModify);

        frame.add(MainButtonPanel);

        // 최종 설정
        frame.setVisible(true);
    }

}