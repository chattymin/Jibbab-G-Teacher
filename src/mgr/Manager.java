package mgr;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

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

	public void readAll(String filename, Factory<T> fac) {
		Scanner filein = openFile(filename);
		T m = null;

		while (filein.hasNext()) {
			m = fac.create();
			m.read(filein);
			mList.add(m);
		}
		filein.close();
	}

	public void printAll() {
		for (T m : mList) {
			m.print();
		}
	}

	// 한식 양식 디저트 순으로 음식 종류별 검색 가능
	// ex)한식->한식 전체 출력,찌개-> 한식 리스트 중 찌개 해당 음식 출력
	// end입력시 한식 리스트 검색 종료->양식 검색 리스트 돌아감
	public void search() {
		String kwd = null;
		while (true) {
			System.out.printf("\n검색(end입력시 종료) : ");
			kwd = scan.next();
			if (kwd.equals("end"))
				break;
			System.out.println("====검색 결과====");
			for (T m : getList()) {
				if (m.matches(kwd)) {
					m.print();
				}
			}
		}
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