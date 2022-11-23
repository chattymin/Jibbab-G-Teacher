package gui;

import food.Food;
import food.Store;
import food.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LikedList {

    public LikedList(Store store) {
        User user = store.userMgr.getList().get(0);
        Font font = new Font("Binggrae-Bold",Font.BOLD, 14);
        JFrame frame = new JFrame();
        frame.setTitle("좋아요 목록");
        frame.setLayout(null);
        frame.setSize(400,640); // 가로, 세로 사이즈
        frame.setResizable(true); // 창 크기 변경 가능 여부(false)
        frame.setLocationRelativeTo(null); // 창이 가운데 생성되도록
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel spanel = new JPanel();
        GridLayout layout = new GridLayout(0,1);
        spanel.setLayout(layout);

        for (Food f : user.getlikedList()){

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

            ImageIcon icon = new ImageIcon("./image/"+name+".png");
            JLabel foodImg = new JLabel(icon);
            panel1.add(foodImg);
            panel12.add("West",panel1);

            JLabel foodName = new JLabel(name);
            JTextArea foodInfo = new JTextArea("#"+country+" #"+type+" #재료"+ingr);
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

            spanel.add(panel);
        }
        //버튼을 만들 패널
        JPanel buttonPanel = new JPanel();
        buttonPanel.setVisible(true);
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(0, 510, 400,100);

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
                frame.dispose();
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
                //new SearchPage;
                frame.dispose();
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
                //new FridgePage();
                frame.dispose();
            }
        });

        // likeButton
        ImageIcon likeImg = new ImageIcon("./image/like.png");
        Image likeImage = likeImg.getImage();
        JButton like =  new JButton(likeImg);
        like.setBorderPainted(false); // 버튼 테두리 설정해제
        like.setContentAreaFilled(false);
        like.setBounds(290,5,90,90);
        like.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new LikePage();
                frame.dispose();
            }
        });

        // 패널에 버튼을 붙여준다
        buttonPanel.add(home);
        buttonPanel.add(search);
        buttonPanel.add(fridge);
        buttonPanel.add(like);

        JScrollPane s = new JScrollPane(spanel);
        s.setBounds(0,0,400,500);
        frame.add(s);
        frame.add(buttonPanel);

        frame.setVisible(true);


    }

}


