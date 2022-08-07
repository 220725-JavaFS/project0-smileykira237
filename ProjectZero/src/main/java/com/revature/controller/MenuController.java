package com.revature.controller;

import java.util.*;

import com.revature.models.AccountHolder;

public class MenuController {
	
	private AccountHolder acctHolder = new AccountHolder();
	private RegistrationController rCont = new RegistrationController();
	private SignInController sCont = new SignInController();
	private AccountsController aCont = new AccountsController();
	private Scanner scanner = new Scanner(System.in);
	
	//Display menu options to user
	public boolean menu() {
		System.out.println("Please choose from the following menu options: ");
		System.out.println("1) Register\n" + "2) Sign in\n" + "3) Exit"); 

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

		 case "1": acctHolder = aCont.openNewAcct(acctHolder);
		 	 break;
		 case "2": acctHolder = aCont.AcctStatus(acctHolder);
			 break;
		 case "3": acctHolder = aCont.AcctDeposit(acctHolder);
			 break;
		 case "4": acctHolder = aCont.AcctWithdrawal(acctHolder);
			 break;
		 case "5": acctHolder = aCont.AcctTransfer(acctHolder);
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