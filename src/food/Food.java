package food;

import java.util.Scanner;
import mgr.Manageable;

public class Food implements Manageable {
	int FoodCategory;	// 한식, 양식등 상속 구분용
	String name;		// 음식 이름
	String type; //타입 ex)메인
	String taste; //맛
	String ingr; //ingredient 재료
	String recipe; //조리
	String country;//나라  
	
	String findCountry(int num) {
		switch (num) {
		case 0 : country = "기타"; break;
		case 1 : country = "한식"; break;
		case 2 : country = "양식"; break;
		}
		return country;
	}
	
	@Override
	public void read(Scanner scan, int FoodCategory) {
		this.FoodCategory = FoodCategory;
		type = scan.next();
		taste = scan.next();
		ingr = scan.next();
		recipe = scan.next();
		name = scan.next();
		country = findCountry(FoodCategory);
	}

	@Override
	public void print() {
		System.out.format("[%s]%s(%s) - %s 재료:%s 조리법:%s\n", country, name, type, taste, ingr, recipe);
	}
	
	@Override
	public boolean matches(String kwd) {
		if (kwd.contentEquals("기타") && FoodCategory == 0)
			return true;
		//한식 클래스에 if(kwd.contentEquals("한식") && FoodCategory == 1)return true; 추가해주세요
		//양식 클래스에 if(kwd.contentEquals("양식") && FoodCategory == 2)return true; 추가해주세요
		if (name.contains(kwd))
			return true;
		if (type.contains(kwd))
			return true;
		if (taste.contains(kwd))
			return true;
		if (recipe.contains(kwd))
			return true;
		return false;
	}
}
