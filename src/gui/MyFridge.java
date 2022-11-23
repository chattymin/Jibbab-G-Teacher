package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Font;

import food.Store;
import food.User;

public class MyFridge {

    Image background = new ImageIcon("./image/emptyFridge.png").getImage();
    HashMap<String, ImageIcon>HMyIngre = new HashMap<>();

    public MyFridge(Store store) {
        User user = store.userMgr.getList().get(0);
        // Font font = new Font("Binggrae-Bold",Font.BOLD, 14);
        ArrayList<String> myFridge = user.getMyFridge();
        // 재료, 이미지 해시 생성.
        setHash(HMyIngre, user);

        // JFrame frame = new BasicFormat(store);  
        JFrame frame = new BasicFormat(store);
        frame.setTitle("내 냉장고");

        JPanel buttonPanel = new ImagePanel();
        int rows = (myFridge.size() / 4) + 1;
        GridLayout layout = new GridLayout(rows , 4, 30, 40);
        buttonPanel.setLayout(layout);
        buttonPanel.setBounds(0, 0, 390, 510);

        JButton btns[] = new JButton[myFridge.size()];
		for (int i = 0; i < myFridge.size(); i++) {
			btns[i] = new JButton(HMyIngre.get(myFridge.get(i)));
            setButton(btns[i]);
			buttonPanel.add(btns[i]);
		}


        JScrollPane scrollPane = new JScrollPane(buttonPanel, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(30);
        scrollPane.setBounds(0, 0, 390, 510);
        frame.add(scrollPane);

        frame.setVisible(true);

    }

    // 재료의 키워드와 이미지를 해시로 저장
    public void setHash(HashMap hash, User user) {
        // 김치 양파 파 버섯 감자 참치 스팸
        ArrayList<String> ingredients = user.getIngredients();
        
        for(String ingre : ingredients) {
            ImageIcon tmpIcon = new ImageIcon("./image/ingredients/" + ingre + ".png");
            Image tmpImg = tmpIcon.getImage();
            Image img = tmpImg.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            hash.put(ingre, icon);
        }
    }

    public void setButton(JButton button) {
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(60, 60));
    }
}

class ImagePanel extends JPanel {public void paintComponent(Graphics g) {
    Dimension d= getSize();
    ImageIcon image = new ImageIcon("image/emptyFridge.png");
    g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
}}