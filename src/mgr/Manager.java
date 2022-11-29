package mgr;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import main.Store;

public class Manager<T extends Manageable> {
	// List는 직접적으로 접근하시면 안됩니다!!! getList 메서드 만들어 두었으니 해당 방법으로 접근 부탁드릴게요
	private ArrayList<T> mList = new ArrayList<>();
	private ArrayList<T> searchResult = new ArrayList<>();
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

	public void readAll(String filename, Factory<T> fac, Store store) {
		Scanner filein = openFile(filename);
		T m = null;

		while (filein.hasNext()) {
			m = fac.create();
			m.read(filein,store);
			mList.add(m);
		}
		filein.close();
	}
	
	public T find(String kwd) {
		for (T m : getList())
			if (m.matches(kwd))
				return m;
		return null;
	}
	
	// 통합검색에서 키워드를 받고 나온 결과를 searchresult에 저장
	public void kwdSearch(String kwd) {
		for (T m : getList()) {
			if (m.matches(kwd)) {
				searchResult.add(m);
			}
		}
	}

	public ArrayList<T> getList() {return mList;}
	public ArrayList<T> getsearchResult() {return searchResult;}

}