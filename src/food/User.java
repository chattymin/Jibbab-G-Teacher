package food;

import mgr.Manageable;
import mgr.Manager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class User implements Manageable {
	private ArrayList<String> ingredients = new ArrayList<>(); // 모든 재료 목록 리스트
	private ArrayList<String> foodList = new ArrayList<>(); // 선호하는 음식 리스트
	private ArrayList<String> myFridge = new ArrayList<>(); // 보유 재료 저장용 텍스트
	private ArrayList<Food> likedList = new ArrayList<>(); // 선호하는 음식 리스트
	private ArrayList<String> likedSaveFile = new ArrayList<>(); //선호하는 음식 저장용 텍스트
	private HashSet<Food> fridgeSearchList = new HashSet<>();

	String name;

	@Override
	public void read(Scanner scan,Store store) {
		name = scan.next();
		readtxt("./txt/LikedSaveFile.txt", likedSaveFile);
		readtxt("./txt/MyFridge.txt", myFridge);
		readtxt("./txt/Ingredients.txt", ingredients);
		readLikedList(store);
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
	// filewriter로 선호음식 텍스트 파일에 음식 추가로 저장
	public void saveLikedFood(String filename) throws IOException {
		FileWriter fw = new FileWriter(filename, true);
		String fo = null;
		// 실제로 찜한 food 객체가 들어가있는 likelist와 텍스트파일인 likesavefile과 비교해서
		// 리스트의 들어가있는 음식들 중에서 세이브파일에 포함되지 않은 음식이 있으면 fo에 음식이름을 저장하고 텍스트파일에 추가
		for (Food f : likedList)
			for (String s : likedSaveFile)
				if(!f.name.contains(s)) {
					fo = " " + f.name;
				}
				else {
					System.out.println("중복 음식입니다!");
					fw.close();
				}
		fw.write(fo);
		fw.close();
	}

	// 위 savelikedfood와 같은 구조의 savemyfridge 메소드 (보유 재료 비교 후 추가)
	public void saveMyFridge(String filename, Scanner scan) throws IOException {
		FileWriter fw = new FileWriter(filename, true);
		String fridge = null;
		fridge = scan.next();
		for (String s : myFridge)
			if(!s.contains(fridge)) {
				fridge = " " + fridge;
			}
			else {
				System.out.println("중복 재료입니다!");
				fw.close();
			}
		fw.write(fridge);
		fw.close();
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
	public void print() {
		System.out.format("[%s] \n 선호 음식 : ", name);
		for (String s : likedSaveFile)
			System.out.print(s + " ");
		System.out.println();
		System.out.printf(" 보유 재료 : ");
		for (String s : myFridge)
			System.out.print(s + " ");
		System.out.println();
	}

	@Override
	public boolean matches(String kwd) { //user의 변수 활용이 없어짐에 따라 matches메서드가 불필요해짐.
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

	public void readLikedList(Store store){
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
	public ArrayList<String> getMyFoodList() {return foodList;}
	public ArrayList<String> getMyFridge() {return myFridge;}
	public ArrayList<String> getIngredients() {return ingredients;}
	// getMyFridgeList 삭제
	public ArrayList<String> getMyFridgeList() {return myFridge;}
	public ArrayList<String> getlikedSaveFile() {return likedSaveFile;}
	public HashSet<Food> getFridgeSearchList() {return fridgeSearchList;}
	public ArrayList<Food> getlikedList() {return likedList;}
}