package gui;

import food.Food;
import food.User;
import mgr.Factory;
import mgr.Manager;

import javax.swing.*;
import java.awt.*;

public class SearchResult {
    public SearchResult(Manager<Food> foodMgr,User user,String kwd){
        /*
        JFrame frame = new BasicFormat();
        frame.setTitle("검색 결과");
        GridLayout layout = new GridLayout(0,1);
        layout.setVgap(10);
        frame.setLayout(layout);

        for (Food f : foodMgr.getList()){

            if (f.matches(kwd)){
                JPanel panel = new JPanel();
                JPanel panel1 = new JPanel();
                JPanel panel2 = new JPanel();
                JPanel panel3 = new JPanel();


                BorderLayout layout1 = new BorderLayout();
                JPanel panel12 = new JPanel(new BorderLayout());
                panel.setLayout(layout1);

                String name = f.getName();
                String type = f.getType();
                String country = f.getCountry();
                String ingr = f.getIngr();


                ImageIcon icon = new ImageIcon("./image/"+name+".png");
                JLabel foodImg = new JLabel(icon);
                panel1.add(foodImg);
                panel12.add("West",panel1);

                JLabel foodName = new JLabel(name);
                JTextArea foodInfo = new JTextArea("#"+country+" #"+type+" #재료"+ingr);
                foodInfo.setEnabled(false);
                foodInfo.setLineWrap(true);
                GridLayout layout2 = new GridLayout(2,1);
                panel2.setLayout(layout2);
                panel2.add(foodName);
                panel2.add(foodInfo);
                panel1.add("East",panel2);

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
                panel3.add(foodLikedImg);

                panel.add("West",panel12);
                panel.add("East",panel3);

                frame.add(panel);
            }

        }

        frame.setVisible(true);

         */
    }
}
