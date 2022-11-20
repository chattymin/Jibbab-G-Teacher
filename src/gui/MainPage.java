package gui;

import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class MainPage {

    public MainPage(){
        JFrame frame = new BasicFormat();
        frame.setTitle("메인화면");
        int randomNumber;
        randomNumber =1;// (int) (Math.random()*2+1);
        ImageIcon tipImgIcon = new ImageIcon("./image/Tips"+randomNumber+".JPEG");
        JLabel tipImg = new JLabel(tipImgIcon);
        tipImg.setBounds(45, 200, 300, 150);
        frame.add(tipImg);
        frame.setVisible(true);
    }



}