package com.revature.controller;

import java.util.*;

public class SignInController {
	
	Scanner scanner = new Scanner(System.in);
	MenuController mCont = new MenuController();
	
	 public void signIn() {
		 
		 System.out.println("Sign-in Hub\n" + "\n" + "Please enter username: ");
		 String userName = scanner.nextLine().trim();
		 
		 System.out.println("\nThank you, " + userName + ". Enter password: ");
		 String password = scanner.nextLine().trim();
		 password = "******";
		 
		 System.out.println("\nWelcome, " + userName);
		 mCont.mainMenu();
	 }

}
