package gui;

import food.Food;
import food.User;

import java.awt.event.*;
import javax.swing.*;

public class DetailPage{

    public DetailPage(Food food, User user){
        // JFrame에 기본 포멧을 New 해주시고, 해당 frame에 추가적으로 작성해서 덧붙이시면 됩니다.
        JFrame frame = new BasicFormat();
        // BasicFormat의 창 이름은 "기본 포멧"이기 때문에 현재 페이지에 맞게 이름 변경해주세요
        frame.setTitle("상세 정보 창");

        //버튼을 만들 패널
        JPanel buttonPanel = new JPanel();
        buttonPanel.setVisible(true);
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(5, 510, 390,100);

        // homeButton
        ImageIcon homeImg = new ImageIcon("./image/home.png");
        JButton home =  new JButton(homeImg);
        home.setBorderPainted(false); // 버튼 테두리 설정해제
        home.setBounds(10,5,90,90);

        // 버튼 클릭했을때 이벤트.
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new MainPage(); // 사용하고자 하는 창 켜기. 페이지 이름을 임시로 적어둔겁니다. 추후 수정 예정
                frame.dispose(); // 창닫기
            }
        });

        // searchButton
        ImageIcon searchImg = new ImageIcon("./image/search.png");
        JButton search =  new JButton(searchImg);
        search.setBorderPainted(false); // 버튼 테두리 설정해제
        search.setBounds(110,5,90,90);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new SearchPage();
                frame.dispose();
            }
        });

        // fridgeButton
        ImageIcon fridgeImg = new ImageIcon("./image/fridge.png");
        JButton fridge =  new JButton(fridgeImg);
        fridge.setBorderPainted(false); // 버튼 테두리 설정해제
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
        JButton like =  new JButton(likeImg);
        like.setBorderPainted(false); // 버튼 테두리 설정해제
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

        // 메인 프레임에 메인패널을 붙여주는 작업
        //add(buttonPanel);
        frame.add(buttonPanel);

        // 임시로 foodMgr의 첫번째 food를 매개변수로 사용했습니다.
        // 이후 정상적으로 연결 할 경우 음식을 클릭 했을때 해당 음식을 매개변수로 전달해줘야 합니다.
        // ex) DetailPage(answerFood, user);
        String name = food.getName();
        String recipe = food.getRecipe();
        String ingr = food.getIngr();

        // text
        JLabel foodName = new JLabel(name);

        JTextArea foodRecipe = new JTextArea(recipe);
        foodRecipe.setEnabled(false); // 내용 수정 불가
        foodRecipe.setLineWrap(true); // 자동 줄바꿈

        JTextArea foodIngr = new JTextArea("재료\n" + ingr);
        foodIngr.setEnabled(false);
        foodIngr.setLineWrap(true);

        // image
        ImageIcon foodImgIcon = new ImageIcon("./image/"+name+".png");
        JLabel foodImg = new JLabel(foodImgIcon);

        // 좋아요 여부에 따른 하트 이미지 선정
        ImageIcon fullHeartIcon = new ImageIcon("./image/fullHeart.png");
        ImageIcon emptyHeartIcon = new ImageIcon("./image/emptyHeart.png");
        JButton foodLikedImg;

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
                new DetailPage(food,user);
                frame.dispose();
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
