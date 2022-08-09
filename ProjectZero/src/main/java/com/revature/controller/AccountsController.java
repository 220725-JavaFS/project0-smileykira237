package com.revature.controller;

import java.util.*;

import com.revature.models.AccountHolder;
import com.revature.service.AccountsServices;

public class AccountsController {

	private Scanner scanner = new Scanner(System.in);
	private AccountsServices acctsServ = new AccountsServices(); 
	
public AccountHolder register(AccountHolder acctHolder) {
		
		System.out.println("Registration Hub\n" + "\n" + "In order for you to register for a new account, I need some information first.");
		System.out.println("What is your first name?");
		acctHolder.setFirstName(scanner.nextLine().trim());
		
		System.out.println("\nWhat is your last name?");
		acctHolder.setLastName(scanner.nextLine().trim());
		
		System.out.println("\nThank you, " + acctHolder.getFirstName() + ". Now, you will need to create a username for your new account.");
		System.out.println("Please enter your new username here: ");
		acctHolder.setUserName(scanner.nextLine().trim());
		
		System.out.println("\nGreat! Last step, you will need to create a password");
		System.out.println("Please enter your new password here: ");
		acctHolder.setUserPassword(scanner.nextLine().trim());
		
		System.out.println("\nThank you " + acctHolder.getFirstName() + ", your account set-up is complete.");
		System.out.println("Your account details are as follows: ");
		System.out.println("UserName: " + acctHolder.getUserName());
		System.out.println("Password: " + acctHolder.getUserPassword());
		System.out.println("Please keep this information somewhere safe.\n");
		
		return acctHolder;
	}	
	
public AccountHolder signIn(AccountHolder acctHolder) {
	 
	 System.out.println("\nSign-in Hub\n" + "\n" + "Please enter username: ");
	 String answer = scanner.nextLine().trim();
	 
	 //checker for valid username
	 while(!acctHolder.getUserName().equalsIgnoreCase(answer)) {
		 System.out.println("\nError: Username does not exist. Please try again: ");
		 answer = scanner.nextLine().trim();
	 }
	 
	 System.out.println("\nThank you, " + acctHolder.getUserName() + ". Enter password: ");
	 answer = scanner.nextLine().trim();
	 
	 //check for valid password
	 while(!acctHolder.getUserPassword().equals(answer)) {
		 System.out.println("\nError: Password incorrect. Please try again: ");
		 answer = scanner.nextLine().trim();
	 }
	 System.out.println("\nWelcome, " + acctHolder.getFirstName());
	 
	 return acctHolder;
}

public AccountHolder openNewAcct(AccountHolder acctHolder) {
		System.out.println("\nNew Account Hub\n" + "\nAlright, I'll need a bit more information from you first. "
				+ "What type of account would you like to open?");
		
		System.out.println("\n1) Checking Account" + "\n2) Savings Account");
		
		String selection = scanner.next().trim();
		
		switch (selection) {

		case "1": acctHolder = acctsServ.openAcctChecking(acctHolder);
			break;
		case "2": acctHolder = acctsServ.openAcctSavings(acctHolder);
			break;
		default: System.out.println("\nError: Selection Invalid. Rerouting ...");
		}
		return acctHolder;
	}
	
public AccountHolder AcctStatus(AccountHolder acctHolder) {

		
		System.out.println("\nAccount Status\n");
		
		acctHolder = acctsServ.acctStatus(acctHolder);
			
	return acctHolder;
}
	
public AccountHolder AcctDeposit(AccountHolder acctHolder) {
	
	System.out.println("\nDeposit Hub\n" + "\nAlright, I'll need a bit more information from you first. "
			+ "In which account would you like to make your deposit?");
	
	System.out.println("\n1) Checking Account" + "\n2) Savings Account");
	
	String selection = scanner.next().trim();
	
	switch (selection) {

	case "1": acctHolder = acctsServ.depositChecking(acctHolder);
		break;
	case "2": acctHolder = acctsServ.depositSavings(acctHolder);
		break;
	default:  System.out.println("\nError: Selection Invalid. Rerouting ...");
	}
	
	return acctHolder;
}

public AccountHolder AcctWithdrawal(AccountHolder acctHolder) {
	
	System.out.println("\nWithdrawal Hub\n" + "\nAlright, I'll need a bit more information from you first. "
			+ "From which account would you like to make your withdrawal?");
	
	System.out.println("\n1) Checking Account" + "\n2) Savings Account");
	
	String selection = scanner.next().trim();
	
	switch (selection) {

	case "1": acctHolder = acctsServ.withdrawalChecking(acctHolder);
		break;
	case "2": acctHolder = acctsServ.withdrawalSavings(acctHolder);
		break;
	default:  System.out.println("\nError: Selection Invalid. Rerouting ...");
	}
return acctHolder;
}

public AccountHolder AcctTransfer(AccountHolder acctHolder) {
	
	System.out.println("\nAccount Status\n" + "\nAlright, I'll need a bit more information from you first. "
			+ "From which account would you like to transfer funds?");
	
	System.out.println("\n1) Checking Account" + "\n2) Savings Account");
	
	String selection = scanner.next().trim();
	
	switch (selection) {

	case "1": acctHolder = acctsServ.tChecking(acctHolder);
		break;
	case "2": acctHolder = acctsServ.tSavings(acctHolder);
		break;
	default:  System.out.println("\nError: Selection Invalid. Rerouting ...");
	}
return acctHolder;
}

}
