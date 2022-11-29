package mgr;

import food.Store;

import java.util.Scanner;

public interface Manageable {
	void read(Scanner scan, Store store);
	boolean matches(String kwd);
}
