package main;

import java.util.ArrayList;
import java.util.Scanner;
import mgr.Manageable;

public class Food implements Manageable, Comparable<Food> {
	String country; // 나라
	String name; // 음식 이름
	String type; // 타입 ex)메인
	String ingr; // ingredient 재료
	ArrayList<String> recipes = new ArrayList<>();
	String recipe; // 조리

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

	@Override
	public int compareTo(Food o) {
		return name.compareTo(o.name);
	}

	public String getName(){return name;}
	public String getIngr(){return ingr;}
	public ArrayList<String> getRecipes(){return recipes;}
	public String getType(){return type;}
	public String getCountry(){return country;}
}

