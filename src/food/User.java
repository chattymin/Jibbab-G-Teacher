package food;

import mgr.Manageable;
import mgr.Manager;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class User implements Manageable {
    private ArrayList<String> myFridge = new ArrayList<>(); // 보유 재료 저장 리스트
    private ArrayList<String> ingredients = new ArrayList<>(); // 모든 재료 목록 리스트
    private ArrayList<String> foodList = new ArrayList<>(); // 선호하는 음식 리스트
    private HashSet<Food> fridgeSearchList = new HashSet<>();

    String name;

    @Override
    public void read(Scanner scan) {
        name = scan.next();
        readtxt("./txt/LikedList.txt", foodList);
        readtxt("./txt/MyFridge.txt", myFridge);
        readtxt("./txt/Ingredients.txt", ingredients);
    }
  
    public void readtxt(String filename, ArrayList<String> list) { // 보유 재료, 선호 음식 파일 입력 메소드
    	Scanner filein = openFile(filename);
    	String kwd = null;
		while (filein.hasNext()) {
			kwd = filein.next();
			list.add(kwd);
		}
		filein.close();
	}
    
	Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (Exception e) {
			System.out.printf("파일 오픈 실패: %s\n", filename);
			System.exit(0);
		}
		return filein;
	}

	@Override
    public void print() {
        System.out.format("[%s] \n 선호 음식 : ", name);
        for (String s : foodList)
        	System.out.print(s + " ");
        System.out.println();
        System.out.printf(" 보유 재료 : ");
        for (String s : myFridge)
        	System.out.print(s + " ");
        System.out.println();
	}

    @Override
    public boolean matches(String kwd) { //user의 변수 활용이 없어짐에 따라 matches메서드가 불필요해짐.
        return false;
    }

    public void fridgeSearch(Manager<Food> manager){
        for (String fridge: myFridge) {
            for (Food f : manager.getList()) {
                if (f.matches(fridge))
                    fridgeSearchList.add(f);
            }
        }

        System.out.format("\n==보유한 재료가 포함된 음식 목록==\n");
        for (Food f: fridgeSearchList) {f.print();}

        // 사용 종료된 HashSet비우기 => 보유 재료 변경됐을때 이전 값 남아있는 현상 방지
        fridgeSearchList.clear();
    }

    public ArrayList<String> getMyFoodList() {return foodList;}
    public ArrayList<String> getMyFridge() {return myFridge;}
    public ArrayList<String> getIngredients() {return ingredients;}
}