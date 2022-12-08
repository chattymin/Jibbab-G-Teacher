package gui;

import javax.swing.*;

import main.Food;
import main.Store;
import main.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;

public class SearchResult extends BasicFormat{

    public SearchResult(Store store){
        super(store);
        Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
        Cursor clickCursor = new Cursor(Cursor.HAND_CURSOR);
        User user = store.userMgr.getList().get(0);
        user.getlikedSaveFile().clear();
        user.readtxt("./txt/LikedSaveFile.txt", user.getlikedSaveFile());
        Font font = new Font("Binggrae-Bold",Font.BOLD, 14);


        setTitle("검색 결과");

        JPanel spanel = new JPanel();
        GridLayout layout = new GridLayout(0,1);
        spanel.setLayout(layout);

        for (Food f : store.foodMgr.getsearchResult()){
            JPanel panel = new JPanel(new BorderLayout());
            panel.setPreferredSize(new Dimension(370,280));
            JPanel panel1 = new JPanel();
            JPanel panel2 = new JPanel();
            JPanel panel3 = new JPanel();
            JPanel panel12 = new JPanel();

            String name = f.getName();
            String type = f.getType();
            String country = f.getCountry();
            String ingr = f.getIngr();

            ImageIcon icon = new ImageIcon("./image/Food/"+name+".png");
            JButton foodImg = new JButton(icon);
            panel1.add(foodImg);
            panel12.add("West",panel1);
            foodImg.addMouseListener(new MouseAdapter() {
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
            Food food = user.getFood(name,store);
            foodImg.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new DetailPage(store,food);
                    dispose();
                }
            });

            JLabel foodName = new JLabel(name);
            JTextArea foodInfo = new JTextArea("#"+country+" #"+type+" #재료 : "+ingr);
            foodInfo.setEnabled(false);
            foodInfo.setLineWrap(true);
            foodName.setFont(font);
            foodInfo.setFont(font);
            GridLayout layout2 = new GridLayout(2,1);
            panel2.setLayout(layout2);
            panel2.add(foodName);
            panel2.add(foodInfo);
            panel12.add("East",panel2);

            ImageIcon fullHeartIcon = new ImageIcon("./image/fullHeart.png");
            ImageIcon emptyHeartIcon = new ImageIcon("./image/emptyHeart.png");
            JButton foodLikedImg;
            if (user.getlikedSaveFile().contains(name))
                foodLikedImg = new JButton(fullHeartIcon);
            else
                foodLikedImg = new JButton(emptyHeartIcon);
            foodLikedImg.setBorderPainted(false);
            foodImg.setBounds(10,10,160,150);
            foodLikedImg.setBounds(350,10,40,40);
            foodName.setBounds(180,10,160,40);
            foodInfo.setBounds(180,60,180,100);
            panel3.add(foodLikedImg);
            foodLikedImg.addMouseListener(new MouseAdapter() {
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
            foodLikedImg.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // file writer를 통해 찜 목록에서 삭제 or 추가 기능 구현 필요
                    if (!user.getlikedSaveFile().contains(name)){ // 찜 안한 음식 찜하기
                        try {
                            FileWriter fw = new FileWriter("./txt/LikedSaveFile.txt");
                            for (String str: user.getlikedSaveFile()){
                                fw.write(str + " ");
                            }
                            fw.write(name);
                            fw.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }else { // 찜했던 음식 목록에서 삭제
                        try {
                            FileWriter fw = new FileWriter("./txt/LikedSaveFile.txt");
                            for (String str: user.getlikedSaveFile()){
                                if (str.contentEquals(name))
                                    continue;
                                fw.write(str + " ");
                            }
                            fw.close();  
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    new SearchResult(store);
                    dispose();
                }
            });

            panel.add("West",panel12);
            panel.add("East",panel3);

            spanel.add(panel);
        }

        add(spanel);
        JScrollPane s = new JScrollPane(spanel);
        add(s);
        setVisible(true);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setVisible(true);
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(0, 510, 400,100);



        JScrollPane scroll = new JScrollPane(spanel);
        scroll.setBounds(0,0,400,500);
        scroll.getVerticalScrollBar().setUnitIncrement(30);
        add(scroll);
        add(buttonPanel);
        setVisible(true);
    }
}
