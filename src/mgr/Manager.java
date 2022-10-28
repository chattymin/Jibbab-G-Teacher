package mgr;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
	ArrayList<Manageable> mList = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	
	Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (Exception e) {
			System.out.printf("파일 오픈 실패: %s\n", filename);
			System.exit(0);
		}
		return filein;
	}
	
	public void readAll(Factory fac, String filename) {
		Scanner filein = openFile(filename);
		Manageable m = null;
		int inherit = 0;
		
		while(filein.hasNext()) {
			inherit = filein.nextInt();
			m = fac.create(inherit);
			m.read(filein, inherit);
			mList.add(m);
		}
		filein.close();
	}
	
	public void printAll() {
		for (Manageable m : mList) {
			m.print();
		}
	}
	
	public void search() {
		String kwd = null;
		while (true) {
			System.out.print("\n검색어 입력(end입력시 종료) : ");
			kwd = scan.next();
			if(kwd.equals("end")) 
				break;
			System.out.println("====검색 결과====");
			for(Manageable m : mList) {
				if(m.matches(kwd)) {
					m.print();
				}
			}
		}
	}
}
