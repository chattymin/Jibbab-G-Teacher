package food;

import java.util.Scanner;
import mgr.Manageable;

public class Food implements Manageable {
	String country; // 나라
	String name; // 음식 이름
	String type; // 타입 ex)메인
	String price; // 맛
	String ingr; // ingredient 재료
	String recipe; // 조리
	int like; // 좋아요 수

	// 중식 메인 4000원 면 짜장 0 면요리 짜장면 4
	@Override
	public void read(Scanner scan) {
		String temp = null;
		country = scan.next();
		type = scan.next();
		price = scan.next();
		ingr = scan.next();
		while (true){
			temp = scan.next();
			if (temp.equals("0"))
				break;
			ingr = ingr + " " + temp;
		} //arraylist 사용 안 하고 하는 방식이 더 좋아보여서 했습니다.
		recipe = scan.next();
		name = scan.next();
		like = scan.nextInt();
	}

	@Override
	public void print() {
		System.out.format("[%s]%s(%s) - 가격 : %s 재료:%s 조리법:%s 좋아요 수 : %d\n", country, name, type, price, ingr, recipe, like);
	}

	@Override
	public boolean matches(String kwd) {
		if (country.contentEquals(kwd))
			return true;
		if (name.contains(kwd))
			return true;
		if (type.contains(kwd))
			return true;
		if (price.contains(kwd))
			return true;
		if (ingr.contains(kwd))
			return true;
		if (recipe.contains(kwd))
			return true;
		return false;
	}
	public String[] getTexts() {  //  행 추가를 위해 객체 데이터를 가져오는 getTexts 메소드
		return new String[] {name, country, type, price, 
				ingr, recipe, "" + like};
	}
}
