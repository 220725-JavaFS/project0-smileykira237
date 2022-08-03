package com.revature.controller;

import java.util.*;

public class SignInController {
	
	Scanner scanner = new Scanner(System.in);
	
	 public void signIn() {
		 
		 System.out.println("Sign-in Hub\n" + "\n" + "Please enter username: ");
		 String userName = scanner.nextLine().trim();
		 
		 System.out.println("\nThank you, " + userName + ". Enter password: ");
		 String password = scanner.nextLine().trim();
		 
		 System.out.println("\n");
		 System.out.println("Transaction Menu\n" + "\n" + "Please make a selection below:");
		 System.out.println("1) Open New Account\n" + "2) Account Status\n" + "3) Deposit\n" + "4) Withdrawal\n" + "5) Funds Transfer");
		 
		 int selection = scanner.nextInt();
		 
		 switch(selection) {
		 
		 case 1: 
			 break;
		 case 2:
			 break;
		 case 3:
			 break;
		 case 4:
			 break;
		 case 5:
			 break;
		 default: System.out.println("Error: Selection Invalid!");
			 break;
		 }
	 }

}
