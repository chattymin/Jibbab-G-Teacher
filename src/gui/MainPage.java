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
        Font font = new Font("Binggrae-Bold",Font.BOLD, 10);

        // Tips패널
        JPanel TipsPanel = new JPanel();
        TipsPanel.setLayout(null);
        TipsPanel.setBounds(5, 5, 390, 415);

        int randomNumber1;
        randomNumber1 = (int) (Math.random()*6+1);
        ImageIcon tipImgIcon = new ImageIcon("./image/tip/Tips"+randomNumber1+".jpg");
        JLabel FirstImg = new JLabel(tipImgIcon);
        FirstImg.setBounds(0, 0, 390, 200);
        //중복 제거 완료
        int randomNumber2;
        randomNumber2 = (int)(Math.random()*30+1);
        while (true){
            if(randomNumber2 == randomNumber1)
                randomNumber2=(int)(Math.random()*30+1);
            else
                break;

        }
        System.out.println("2:" + randomNumber2 + "1: " + randomNumber1);
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

        //이미지를 넣어보고 싶었는데 사이즈이슈로 그냥 글씨나오는 패널로 할게요...
        JButton LikedListModify = new JButton("찜 수정");
        LikedListModify.setBounds(0, 5, 190, 80);

        JButton FridgeListModify = new JButton("보유재료수정");
        FridgeListModify.setBounds(200, 5, 190, 80);

        MainButtonPanel.add(LikedListModify);
        MainButtonPanel.add(FridgeListModify);

        frame.add(MainButtonPanel);
         /*
        ImageIcon fridgeEditImg = new ImageIcon("./image/001.jpg");
        JLabel Eidt1 = new JLabel(fridgeEditImg);
        Eidt1.setBounds(200, 5, 190, 80);
        /*JButton fridgeEdit =  new JButton(fridgeEditImg);
        fridgeEdit.setBorderPainted(false); // 버튼 테두리 설정해제
        fridgeEdit.setContentAreaFilled(false);
        fridgeEdit.setBounds(200, 5, 80, 80);
        fridgeEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new MyFridge(store);
                dispose();
            }
        });*/

        // 최종 설정
        frame.setVisible(true);
    }

}