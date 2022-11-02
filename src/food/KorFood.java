package food;

import java.util.Scanner;

// Food 클래스 상속받는 KorFood(한식) 클래스
public class KorFood extends Food {
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
	public void read(Scanner scan, int FoodCategory) {
		super.read(scan, FoodCategory);
	}

	@Override
	public void print() {
		super.print();
	}
	
	@Override
	public boolean matches(String kwd) {
		if (kwd.contentEquals("한식") && FoodCategory == 1)
			return true;
		//양식 클래스에 if(kwd.contentEquals("양식") && FoodCategory == 2)return true; 추가해주세요
		if (name.contains(kwd))
			return true;
		if (type.contains(kwd))
			return true;
		if (taste.contains(kwd))
			return true;
		// 재료 검색 부분 추가
		if (ingr.contains(kwd))
			return true;
		if (recipe.contains(kwd))
			return true;
		return false;
	}
}
