package food;

import java.util.Scanner;

public class Western extends Food{
    @Override
    public String findCountry(int num) {
        switch (num) {
            case 0 : country = "기타"; break;
            case 1 : country = "한식"; break;
            case 2 : country = "양식"; break;
        }
        return country;
    }
    @Override
    public void read(Scanner scan,int FoodCategory) {
        super.read(scan,FoodCategory);
    }

    @Override
    public void print() {
        super.print();
    }

    @Override
    public boolean matches(String kwd) {
        if (kwd.contentEquals("���")&&FoodCategory==2)
            return true;
        if (name.contains(kwd))
            return true;
        if (type.contains(kwd))
            return true;
        if (taste.contains(kwd))
            return true;
        //재료 검색 부분 추가
        if (ingr.contains(kwd))
            return true;
        if (recipe.contains(kwd))
            return true;
        return false;
    }


}