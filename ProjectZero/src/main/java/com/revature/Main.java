package com.revature;

import com.revature.controller.MenuController;

public class Main {

	public static void main(String[] args) {
	
		System.out.println("Hello! Welcome to the online banking system.\n");
		
		MenuController mCont = new MenuController();
		
		mCont.menu();
	}

}
