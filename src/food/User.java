package food;

import mgr.Manageable;
import mgr.Manager;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements Manageable {
	private ArrayList<String> ingredients = new ArrayList<>(); // 모든 재료 목록 리스트
	private ArrayList<String> myFridge = new ArrayList<>(); // 보유 재료 저장용 텍스트
	private ArrayList<Food> likedList = new ArrayList<>(); // 선호하는 음식 리스트
	private ArrayList<String> likedSaveFile = new ArrayList<>(); //선호하는 음식 저장용 텍스트

	String name = null;

	@Override
	public void read(Scanner scan, Store store) {
		name = scan.next();
		readtxt("./txt/LikedSaveFile.txt", likedSaveFile);
		readtxt("./txt/MyFridge.txt", myFridge);
		readtxt("./txt/Ingredients.txt", ingredients);
		readLikedList(store,likedList);
	}

	// 보유 재료, 선호 음식 파일 입력 메소드
	public void readtxt(String filename, ArrayList<String> list) {
		Scanner filein = openFile(filename);
		String kwd = null;
		while (filein.hasNext()) {
			kwd = filein.next();
			list.add(kwd);
		}
		filein.close();
	}

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

	@Override
	//user의 변수 활용이 없어짐에 따라 matches메서드가 불필요해짐.
	public boolean matches(String kwd) { 
		return false;
	}

	public void fridgeSearch(Manager<Food> manager){
		for (String fridge: myFridge) {
			for (Food f : manager.getList()) {
				if (f.matches(fridge))
					manager.getsearchResult().add(f);
			}
		}
	}

	public void readLikedList(Store store,ArrayList<Food>likedList){
		Food food = null;
		for (String s:likedSaveFile){
			for (Food f: store.foodMgr.getList()){
				if (f.name.equals(s)) {
					food = getFood(s,store);
					likedList.add(food);
				}
			}
		}
	}

	public Food getFood(String name,Store store){
		for (Food f: store.foodMgr.getList()){
			if (f.name.equals(name))
				return f;
		}
		return null;
	}

	public ArrayList<String> getMyFridge() {return myFridge;}
	public ArrayList<String> getIngredients() {return ingredients;}
	public ArrayList<String> getlikedSaveFile() {return likedSaveFile;}
	public ArrayList<Food> getlikedList() {return likedList;}
}