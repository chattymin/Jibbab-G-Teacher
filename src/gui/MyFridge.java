package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import food.Food;
import food.User;

public class MyFridge {

    Image background = new ImageIcon("./image/emptyFridge.png").getImage();

    public MyFridge(Food food, User user) {
        JFrame frame = new BasicFormat();
        frame.setTitle("내 냉장고");

        JPanel buttonPanel = new ImagePanel();

        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
        buttonPanel.setBounds(0,0, 390, 510);
        buttonPanel.setBackground(Color.RED);

        JButton btns[] = new JButton[40];
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton("버튼"+(i + 1));
            btns[i].setPreferredSize(new Dimension(60, 60));
			buttonPanel.add(btns[i]);
		}

        frame.setVisible(true);
        frame.add(buttonPanel);
    }

}

class ImagePanel extends JPanel {public void paintComponent(Graphics g) {
    Dimension d= getSize();
    ImageIcon image = new ImageIcon("image/emptyFridge.png");
    g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
}}