package gui;

import food.Store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoadingPage {

    private int alpha = 1;
    private int increment = 9;
    JLabel label = new JLabel("Team G",SwingConstants.CENTER);
    Font font = new Font("Binggrae-Bold",Font.BOLD, 100);


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new LoadingPage().makeUI();
            }
        });
    }

    public void makeUI() {
        JFrame frame = new JFrame();
        new Timer(40, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                alpha += increment;
                if (alpha >= 255) {
                    alpha = -1;
                    new Store();
                    frame.dispose();
                }
                if (alpha <= 0) {
                    alpha = 0;
                    increment = 0;
                }

                label.setForeground(new Color(0, 0, 0, alpha));
            }
        }).start();

        label.setFont(font);
        frame.add(label);
        frame.setResizable(false); // 창 크기 변경 가능 여부(false)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,640); // 가로, 세로 사이즈
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}