package food;

import java.util.Scanner;

import mgr.Manageable;

public class Western extends Food{
    @Override
    public String findCountry(int num) {
        switch (num) {
        case 0 : country = "��Ÿ"; break;
        case 1 : country = "�ѽ�"; break;
        case 2 : country = "���"; break;
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
        //��� �˻� �κ� �߰�
        if (ingr.contains(kwd))
            return true;
        if (recipe.contains(kwd))
            return true;
        return false;
    }


}