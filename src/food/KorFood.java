package food;

import java.util.Scanner;

public class KorFood extends Food {

	@Override
	public void read(Scanner scan) {
		super.read(scan);
		country = "한식";
	}

	@Override
	public void print() {
		super.print();
	}

	@Override
	public boolean matches(String kwd) {
		if (kwd.contentEquals("한식"))
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
