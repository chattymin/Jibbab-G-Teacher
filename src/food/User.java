package food;

import mgr.Manageable;
import java.util.ArrayList;
import java.util.Scanner;

// 사용자 id와 pw를 만들어두었습니다.
//  id는 본인의 이니셜, pw는 123456입니다
// ex) id : pdm        pw : 123456

public class User implements Manageable {
    ArrayList<String> foodList = new ArrayList<>(); //선호하는 음식 저장 리스트
    String ID, PW, name, phoneNumber;

    @Override
    public void read(Scanner scan) {
        String kwd = null;
        ID = scan.next();
        PW = scan.next();
        name = scan.next();
        phoneNumber = scan.next();
        while (true){
            kwd = scan.next();
            if (kwd.contentEquals("end"))
                break;
            foodList.add(kwd);
        }
    }

    @Override
    public void print() {
        System.out.format("[%s] %s\n 선호 음식 : ", name, phoneNumber);
        for (String s : foodList)
            System.out.print(s + " ");
        System.out.println();
    }

    @Override
    public boolean matches(String kwd) {
        if (kwd.contains(name))
            return true;
        if (kwd.contains(phoneNumber))
            return true;
        return false;
    }

    // 로그인을 위한 id, pw 체크
    public boolean UserLogin(String id, String pw){
        if (ID.contentEquals(id) && PW.contentEquals(pw))
            return true;
        return false;
    }
}