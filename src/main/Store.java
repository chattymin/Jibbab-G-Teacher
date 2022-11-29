package main;

import java.util.Scanner;

import gui.MainPage;
import mgr.Factory;
import mgr.Manager;

public class Store extends Manager<User> {
	public Manager<Food> foodMgr = new Manager<>();
	public Manager<User> userMgr = new Manager<>();
	
	Scanner scan = new Scanner(System.in);

	void run() {
		// 음식 매니저
		foodMgr.readAll("./txt/Foods.txt", new Factory<Food>() {
			@Override
			public Food create() {
				return new Food();
			}
		},this);
		
		// 사용자 매니저
		userMgr.readAll("./txt/User.txt", new Factory<User>() {
			@Override
			public User create() {
				return new User();
				}
		},this);

		// gui의 메인 클래스를 호출하는 것이고, store객체 입니다.
		new MainPage(this);
	}

	public static void main(String[] args) {
		Store store = new Store();
		store.run();
	}
}