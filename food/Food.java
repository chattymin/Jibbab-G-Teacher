package food;

import java.util.Scanner;
import mgr.Manageable;

public class Food implements Manageable {
	String name; // 음식 이름
	String type; // 타입 ex)메인
	String taste; // 맛
	String ingr; // ingredient 재료
	String recipe; // 조리
	String country;// 나라

	@Override
	public void read(Scanner scan) {
		type = scan.next();
		taste = scan.next();
		ingr = scan.next();
		recipe = scan.next();
		name = scan.next();
		country = "디저트";

	}

	@Override
	public void print() {
		System.out.format("[%s]%s(%s) - %s 재료:%s 조리법:%s\n", country, name, type, taste, ingr, recipe);
	}

	@Override
	public boolean matches(String kwd) {
		if (kwd.contentEquals("디저트"))
			return true;
		if (name.contains(kwd))
			return true;
		if (type.contains(kwd))
			return true;
		if (taste.contains(kwd))
			return true;
		if (ingr.contains(kwd))
			return true;
		if (recipe.contains(kwd))
			return true;
		return false;
	}
}
