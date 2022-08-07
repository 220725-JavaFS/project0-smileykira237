package com.revature.controller;

import java.util.*;

public class SignInController {
	
	Scanner scanner = new Scanner(System.in);
	
	 public void signIn() {
		 
		 System.out.println("\nSign-in Hub\n" + "\n" + "Please enter username: ");
		 String userName = scanner.nextLine().trim();
		 
		 System.out.println("\nThank you, " + userName + ". Enter password: ");
		 
		 @SuppressWarnings("unused")
		String password = scanner.nextLine().trim();
		 
		 System.out.println("\nWelcome, " + userName);
	 }

}
