package com.revature.controller;

import java.util.Scanner;

public class MenuController {
	
	RegistrationController rCont = new RegistrationController();
	SignInController sCont = new SignInController();
	OpenAcctController aCont = new OpenAcctController();
	Scanner scanner = new Scanner(System.in);
	
	//Display menu options to user
	public void startMenu() {
		System.out.println("Please choose from the following menu options: ");
		System.out.println("1) Register\n" + "2) Sign in\n" + "3) Exit"); 
		
		int selection = scanner.nextInt();
		
		switch (selection){
		
			case 1: rCont.register();
			sCont.signIn();
				break;
			case 2: sCont.signIn();
				break;
			case 3: System.out.println("Now exiting online banking ... Goodbye!");
				break;
			default: System.out.println("Error: Selection Invalid!");
				break;
				}
		
		 System.out.println("\nTransaction Menu\n" + "\n" + "Please make a selection below:");
		 System.out.println("1) Open New Account\n" + "2) Account Status\n" + "3) Deposit\n" + 
		 "4) Withdrawal\n" + "5) Funds Transfer\n" + "6) Logout");
		 
		 int nextSelection = scanner.nextInt();
		 
		 switch(nextSelection) {
		 
		 case 1: aCont.openNewAcct();
			 break;
		 case 2:
			 break;
		 case 3:
			 break;
		 case 4:
			 break;
		 case 5:
			 break;
		 case 6: System.out.println("You've been logged out.");
		 scanner.close();
			 break;
		 default: System.out.println("Error: Selection Invalid!");
			 break;
		 }
	}
	
	public void mainMenu() {
		 System.out.println("\nTransaction Menu\n" + "\n" + "Please make a selection below:");
		 System.out.println("1) Open New Account\n" + "2) Account Status\n" + "3) Deposit\n" + 
		 "4) Withdrawal\n" + "5) Funds Transfer\n" + "6) Logout");
		 
		 int nextSelection = scanner.nextInt();
		 
		 switch(nextSelection) {
		 
		 case 1: aCont.openNewAcct();
			 break;
		 case 2:
			 break;
		 case 3:
			 break;
		 case 4:
			 break;
		 case 5:
			 break;
		 case 6: System.out.println("You've been logged out.");
		 scanner.close();
			 break;
		 default: System.out.println("Error: Selection Invalid!");
			 break;
		 }
	}
}