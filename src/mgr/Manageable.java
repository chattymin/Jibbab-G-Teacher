package mgr;

import java.util.Scanner;

public interface Manageable {
	void read(Scanner scan, int FoodCategory);
	void print();
	boolean matches(String kwd);
}
