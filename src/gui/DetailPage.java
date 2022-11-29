package gui;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

import main.Food;
import main.Store;
import main.User;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DetailPage{
    JButton foodLikedImg;
    public DetailPage(Store store, Food food){
        // JFrame에 기본 포멧을 New 해주시고, 해당 frame에 추가적으로 작성해서 덧붙이시면 됩니다.
        JFrame frame = new BasicFormat(store);
        // BasicFormat의 창 이름은 "기본 포멧"이기 때문에 현재 페이지에 맞게 이름 변경해주세요
        frame.setTitle("상세 정보 창");
        User user = store.userMgr.getList().get(0);

        // 마우스 커서
        Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR);
        Cursor clickCursor = new Cursor(Cursor.HAND_CURSOR);

        // 폰트 설정
        Font font = new Font("Binggrae",Font.PLAIN, 14);

        // 하트 실시간 반영을 위한 리스트 재구성
        user.getlikedSaveFile().clear();
        user.readtxt("./txt/LikedSaveFile.txt", user.getlikedSaveFile());

        // 임시로 foodMgr의 첫번째 food를 매개변수로 사용했습니다.
        // 이후 정상적으로 연결 할 경우 음식을 클릭 했을때 해당 음식을 매개변수로 전달해줘야 합니다.
        // ex) DetailPage(answerFood, user);
        String name = food.getName();
        String ingr = food.getIngr();

        // text
        JLabel foodName = new JLabel(name);
        foodName.setFont(font);

        JTextArea foodRecipe = new JTextArea();
        for (String str: food.getRecipes()){
            foodRecipe.append(str+"\n");
        }
        foodRecipe.setFont(font);
        foodRecipe.setEnabled(false); // 내용 수정 불가
        foodRecipe.setLineWrap(true); // 자동 줄바꿈

        JTextArea foodIngr = new JTextArea("재료\n" + ingr);
        foodIngr.setEnabled(false);
        foodIngr.setLineWrap(true);
        foodIngr.setFont(font);

        // image
        ImageIcon foodImgIcon = new ImageIcon("./image/Food/"+name+".png");
        JLabel foodImg = new JLabel(foodImgIcon);

        // 좋아요 여부에 따른 하트 이미지 선정
        ImageIcon fullHeartIcon = new ImageIcon("./image/fullHeart.png");
        ImageIcon emptyHeartIcon = new ImageIcon("./image/emptyHeart.png");


        // 좋아요 한 음식인지 확인 후 하트 모양 결정
        if(user.getlikedSaveFile().contains(name)){
            foodLikedImg = new JButton(fullHeartIcon);
        }else{
            foodLikedImg = new JButton(emptyHeartIcon);
        }
        foodLikedImg.setBorderPainted(false);

        // 각 객체 위치 지정
        foodName.setBounds(180,10,160,50);
        foodRecipe.setBounds(10,180,380,330);
        foodIngr.setBounds(180,70,210,100);

        foodImg.setBounds(10,10,160,160);
        foodLikedImg.setBounds(350,10,40,40);

        // 하트모양 눌렀을 경우 찜 목록 삭제 or 추가
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
                new DetailPage(store, food);
                frame.dispose();

            }
        });

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

        // frame에 넣기
        frame.add(foodName);
        frame.add(foodRecipe);
        frame.add(foodIngr);

        frame.add(foodImg);
        frame.add(foodLikedImg);


        // 이걸 여기서 작성해줘야 위에 작성한 frame에 넣은 요소들이 합쳐져서 보입니다.
        // BasicFormat에서 visible(true)하면 여기 클래스에서 넣은 frame 요소들은 안보여요
        frame.setVisible(true);
    }
}