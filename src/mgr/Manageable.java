package mgr;

import java.util.Scanner;

import main.Store;

public interface Manageable {
	void read(Scanner scan, Store store);
	boolean matches(String kwd);
}
