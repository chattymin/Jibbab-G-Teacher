package mgr;

import food.Store;

import java.util.Scanner;

public interface Manageable {
	void read(Scanner scan, Store store);
	void print();
	boolean matches(String kwd);
}
