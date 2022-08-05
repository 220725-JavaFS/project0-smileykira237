package com.revature.controller;

import java.util.*;

public class MenuController {
	
	RegistrationController rCont = new RegistrationController();
	SignInController sCont = new SignInController();
	OpenAcctController aCont = new OpenAcctController();
	DepositController dCont = new DepositController();
	Scanner scanner = new Scanner(System.in);
	
	//Display menu options to user
	public boolean menu() {
		System.out.println("Please choose from the following menu options: ");
		System.out.println("1) Register\n" + "2) Sign in\n" + "3) Exit"); 

		Scanner scanner = new Scanner(System.in);
		String selection = scanner.next().trim();
		
		switch (selection){
		    case "1": rCont.register();
		sCont.signIn();
				break;
			case "2": sCont.signIn();
				break;
			case "3": System.out.println("Now Exiting ...");
				scanner.close();
				return false;
			default: System.out.println("Error: Selection Invalid");
			scanner.close();
			return false;
		}
		do {
		 System.out.println("\nTransaction Menu\n" + "\n" + "Please make a selection below:");
		 System.out.println("1) Open New Account\n" + "2) Account Status\n" + "3) Deposit\n" + 
		 "4) Withdrawal\n" + "5) Funds Transfer\n" + "6) Logout");
		 String nextSelection = scanner.next().trim();
		 
		 switch(nextSelection) {

		 case "1": aCont.openNewAcct();
		 	 break;
		 case "2":
			 break;
		 case "3": dCont.AcctDeposit();
			 break;
		 case "4":
			 break;
		 case "5":
			 break;
		 case "6": System.out.println("You've been logged out.");
		 scanner.close();
			 return false;
		 default: System.out.println("\nError: Selection Invalid. Rerouting to main menu ... ");
		 }
		}
		while(true);
}
}