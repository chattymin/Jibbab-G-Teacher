package gui;

import food.Food;
import food.Store;
import food.User;
import mgr.Factory;
import mgr.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;

public class SearchResult {

    public SearchResult(Store store){
        Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
        Cursor clickCursor = new Cursor(Cursor.HAND_CURSOR);
        User user = store.userMgr.getList().get(0);
        user.getlikedSaveFile().clear();
        user.readtxt("./txt/LikedSaveFile.txt", user.getlikedSaveFile());
        Font font = new Font("Binggrae-Bold",Font.BOLD, 14);
        JFrame frame = new JFrame();
        frame.setTitle("검색 결과");
        frame.setLayout(null);
        frame.setSize(400,640); // 가로, 세로 사이즈
        frame.setResizable(true); // 창 크기 변경 가능 여부(false)
        frame.setLocationRelativeTo(null); // 창이 가운데 생성되도록
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
                    frame.setCursor(clickCursor);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    ////마우스가 해당 컴포넌트 영역 밖으로 나갈때 발생
                    frame.setCursor(normalCursor);
                }
            });
            Food food = user.getFood(name,store);
            foodImg.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new DetailPage(store,food);
                    frame.dispose();
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
            foodInfo.setBounds(180,60,210,100);
            panel3.add(foodLikedImg);
            foodLikedImg.addMouseListener(new MouseAdapter() {
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
                    frame.dispose();
                }
            });



            panel.add("West",panel12);
            panel.add("East",panel3);

            spanel.add(panel);


        }
        frame.add(spanel);
        JScrollPane s = new JScrollPane(spanel);
        frame.add(s);
        frame.setVisible(true);
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
        home.addMouseListener(new MouseAdapter() {
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
                frame.dispose();
            }
        });
        search.addMouseListener(new MouseAdapter() {
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
                frame.dispose();
            }
        });
        fridge.addMouseListener(new MouseAdapter() {
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
                new LikedList(store);
                frame.dispose();
            }
        });
        like.addMouseListener(new MouseAdapter() {
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

        // 패널에 버튼을 붙여준다
        buttonPanel.add(home);
        buttonPanel.add(search);
        buttonPanel.add(fridge);
        buttonPanel.add(like);

        JScrollPane scroll = new JScrollPane(spanel);
        scroll.setBounds(0,0,400,500);
        scroll.getVerticalScrollBar().setUnitIncrement(30);
        frame.add(scroll);
        frame.add(buttonPanel);

        frame.setVisible(true);

    }

}
