package food;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import mgr.Manageable;

public class Food implements Manageable, Comparable<Food> {
	String country; // 나라
	String name; // 음식 이름
	String type; // 타입 ex)메인
	String ingr; // ingredient 재료
	ArrayList<String> recipes = new ArrayList<>();
	String recipe; // 조리
	int price = 10; // 정렬 수정하는 분이 맞춰서 수정해주세요..

	// 중식 메인 면 짜장 0 면요리 짜장면 4
	@Override
	public void read(Scanner scan,Store store) {
		String temp = null;
		country = scan.next();
		type = scan.next();
		ingr = scan.next();
		while (true){
			temp = scan.next();
			if (temp.equals("end"))
				break;
			ingr = ingr + " " + temp;
		} //arraylist 사용 안 하고 하는 방식이 더 좋아보여서 했습니다.
		recipe = scan.next();
		while (true){
			temp = scan.next();
			if (temp.contentEquals("enter")) {
				recipes.add(recipe);
				recipe = "";
				continue;
			}
			if (temp.contentEquals("완성"))
				break;
			recipe = recipe + " " + temp;
		}
		name = scan.next();
	}

	@Override
	public void print() {
		System.out.format("[%s]%s(%s) - 재료:%s\n 조리법:%s\n",
				country, name, type, ingr, recipe);
	}

	@Override
	public boolean matches(String kwd) {
		if (country.contentEquals(kwd))
			return true;
		if (name.contains(kwd))
			return true;
		if (type.contains(kwd))
			return true;
		if (ingr.contains(kwd))
			return true;
		if (recipe.contains(kwd))
			return true;
		return false;
	}
	public String[] getTexts() {  //  행 추가를 위해 객체 데이터를 가져오는 getTexts 메소드
		return new String[] {name, country, type, ingr, recipe};
	}


	@Override
	public int compareTo(Food o) {
		return name.compareTo(o.name);
	}

	public String getName(){return name;}

	public String getRecipe(){return recipe;}

	public String getIngr(){return ingr;}

	public ArrayList<String> getRecipes(){return recipes;}
	public String getType(){return type;}
	public String getCountry(){return country;}
}

