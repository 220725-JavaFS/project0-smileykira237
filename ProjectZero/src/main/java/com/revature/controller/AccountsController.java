package com.revature.controller;

import java.util.*;

import com.revature.models.AccountHolder;
import com.revature.service.AccountsServices;

public class AccountsController {

	private Scanner scanner = new Scanner(System.in);
	private AccountsServices acctsServ = new AccountsServices(); 
	
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
