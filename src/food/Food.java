// 파일 입출력 구현 여부를 판단하기 위해 간단하게 만들어두었습니다. 
// 작업 시작하시기 전에 제대로 작동하는지 확인하시고 삭제 후 작업 부탁드립니다.

package food;

import java.util.Scanner;
import mgr.Manageable;

public class Food implements Manageable {
	int FoodCategory;	// 한식, 양식등 상속 구분용
	String name;		// 음식 이름
	
	@Override
	public void read(Scanner scan, int FoodCategory) {
		// TODO Auto-generated method stub
		this.FoodCategory = FoodCategory;
		name = scan.next();
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.printf("%s\n", name);
	}
	@Override
	public boolean matches(String kwd) {
		// TODO Auto-generated method stub
		if(name.contains(kwd))
			return true;
		if(kwd.contentEquals("한식") && FoodCategory == 1)
			return true;
		return false;
	}
}
