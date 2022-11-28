package gui;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import food.*;

public class SetMyFridge {
    Font font = new Font("Binggrae-Bold",Font.BOLD, 14);
    ArrayList<String> ingredients = null;
    String checkedList = null;
    HashMap<JCheckBox, String> HIngres = new HashMap<>();
    JButton finish = new JButton("재료 선택 완료"); 
    int index = 0;

    public SetMyFridge(Store store) {
        JFrame frame = new BasicFormat(store);
        User user = store.userMgr.getList().get(0);
        ingredients = user.getIngredients();

        String[] categories = {"고기류", "채소류", "해산물", "유제품", "조미료", "기타"};
        int[] nums = {5, 26, 10, 3, 19, 33};

        JPanel setingre = new JPanel();

        for(int i = 0; i < categories.length; i++) {
            JPanel panels = null;
            panels = setPanels(panels, categories[i], nums[i]);
            panels.setBorder(new TitledBorder(new EtchedBorder(), categories[i]));
            setingre.add(panels);
        }

        JScrollPane scrollPane = new JScrollPane(setingre);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(30);
        scrollPane.setBounds(18, 40, 350, 390);
        scrollPane.setBorder(null);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBounds(170, 450, 200, 100);

        finish.setFont(font);
        finish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(finish.equals(ae.getSource())) {
                    try {
                        FileWriter fw = new FileWriter("./txt/MyFridge.txt");
                        checkedList = checkedList.replace("null ", "");
                        fw.write(checkedList);
                        fw.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                new MyFridge(store);
                frame.dispose();
            }
        });

        buttonPanel.add(finish);
        

        frame.add(scrollPane);
        frame.add(buttonPanel);

        frame.setTitle("보유 재료 수정");
        frame.setVisible(true);
    }

    JPanel setPanels(JPanel panel, String category, int num) {
        int cols = (num % 6) + 1;
        panel = new JPanel(new GridLayout(6, cols, 30, 35));

        for(int i = 0; i < num; i++) {
            JCheckBox checks = null;
            checks = setCheckBox(checks, ingredients.get(index));
            panel.add(checks);
            index++;
        }
        return panel;
    }

    JCheckBox setCheckBox(JCheckBox check, String name) {
        check = new JCheckBox(name);
        check.addItemListener(new myItemListner());
        check.setFont(font);
        HIngres.put(check, name);
        return check;
    }

    class myItemListner implements ItemListener{
        String tmp = null;

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange()==ItemEvent.SELECTED) {
                tmp = " " + HIngres.get(e.getItem()).toString();
                checkedList = checkedList + tmp;
                System.out.println(checkedList);
            }
            else {
                tmp = " " + HIngres.get(e.getItem()).toString();
                checkedList = checkedList.replace(tmp, "");
                System.out.println(checkedList);
            }
        }
    }
}