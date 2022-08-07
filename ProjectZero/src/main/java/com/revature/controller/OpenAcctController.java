package com.revature.controller;

import java.util.*;

import com.revature.models.AccountHolder;
import com.revature.service.OpenAcctService;

public class OpenAcctController {
	
	private Scanner scanner = new Scanner(System.in);
	OpenAcctService aServ = new OpenAcctService();
	
	public AccountHolder openNewAcct(AccountHolder acctHolder) {
		System.out.println("\nNew Account Hub\n" + "\nAlright, I'll need a bit more information from you first. "
				+ "What type of account would you like to open?");
		
		System.out.println("\n1) Checking Account" + "\n2) Savings Account");
		
		String selection = scanner.next().trim();
		
		switch (selection) {
	
		case "1": acctHolder = aServ.openAcctChecking(acctHolder);
			break;
		case "2": acctHolder = aServ.openAcctSavings(acctHolder);
			break;
		default: System.out.println("\nError: Selection Invalid. Rerouting ...");
		}
		return acctHolder;
	}

}
