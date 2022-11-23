package gui;

import food.Food;
import food.Store;
import food.User;

import javax.swing.*;
import java.awt.*;

public class LikedList {

    public LikedList(Store store) {

        User user = store.userMgr.getList().get(0);
        JFrame frame = new BasicFormat(store);
        frame.setTitle("좋아요 목록");
        JPanel spanel = new JPanel();

        for (Food f : user.getlikedList()){

            JPanel panel = new JPanel();
            JPanel panel1 = new JPanel();
            JPanel panel2 = new JPanel();
            JPanel panel3 = new JPanel();


            JPanel panel12 = new JPanel();
            panel.setLayout(null);

            String name = f.getName();
            String type = f.getType();
            String country = f.getCountry();
            String ingr = f.getIngr();


            ImageIcon icon = new ImageIcon("./image/"+name+".png");
            JLabel foodImg = new JLabel(icon);

            JLabel foodName = new JLabel(name);
            JTextArea foodInfo = new JTextArea("#"+country+" #"+type+" #재료"+ingr);
            foodInfo.setEnabled(false);
            foodInfo.setLineWrap(true);

            ImageIcon fullHeartIcon = new ImageIcon("./image/fullHeart.png");
            ImageIcon emptyHeartIcon = new ImageIcon("./image/emptyHeart.png");
            JButton foodLikedImg;
            if (user.getMyFoodList().contains(name))
                foodLikedImg = new JButton(fullHeartIcon);
            else
                foodLikedImg = new JButton(emptyHeartIcon);
            foodLikedImg.setBorderPainted(false);
            foodImg.setBounds(10,10,160,150);
            foodLikedImg.setBounds(350,10,40,40);
            foodName.setBounds(180,10,160,40);
            foodInfo.setBounds(180,60,210,100);

            panel.add(foodName);
            panel.add(foodInfo);
            panel.add(foodImg);
            panel.add(foodLikedImg);
            spanel.add(panel);

        }
        frame.add(spanel);
        JScrollPane s = new JScrollPane(spanel);
        frame.add(s);
        frame.setVisible(true);

    }

}