package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt. Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class MyFridge extends JFrame {

    public MyFridge() { }

    void run() {
        drawGUI();
    }

    void drawGUI() {
        this.setTitle("내 냉장고");
        // this.setResizable(false);
        this.setVisible(true);
        this.setPreferredSize(new Dimension(400, 640));
        this.setSize(400, 640);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel Fridge = new JPanel();
        JPanel downBar = new JPanel();

        Fridge.setBounds(0, 0, 385, 530);

        downBar.setLayout(new GridLayout(0, 4, 0, 0));
        downBar.setBounds(0, 491, 385, 110);

        JButton homeButton = new JButton("Home");
        JButton searchButton = new JButton("Search");
        JButton fridgeButton = new JButton("Fridge");
        JButton likedButton = new JButton("Liked");
        
        downBar.add(homeButton);
        downBar.add(searchButton);
        downBar.add(fridgeButton);
        downBar.add(likedButton);

        this.add(downBar);
        this.add(Fridge);
        
        
    }
    
    public static void main(String[] args) {
        MyFridge fridge = new MyFridge();
        fridge.run();
    }

}