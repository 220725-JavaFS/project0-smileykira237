package com.revature.controller;

import java.util.*;

import com.revature.models.AccountHolder;
import com.revature.service.TransferService;

public class TransferController {
	
	private Scanner scanner = new Scanner(System.in);
	private TransferService tServ = new TransferService();
	
	public AccountHolder AcctTransfer(AccountHolder acctHolder) {
		
		System.out.println("\nAccount Status\n" + "\nAlright, I'll need a bit more information from you first. "
				+ "From which account would you like to transfer funds?");
		
		System.out.println("\n1) Checking Account" + "\n2) Savings Account");
		
		String selection = scanner.next().trim();
		
		switch (selection) {
	
		case "1": acctHolder = tServ.tChecking(acctHolder);
			break;
		case "2": acctHolder = tServ.tSavings(acctHolder);
			break;
		default:  System.out.println("\nError: Selection Invalid. Rerouting ...");
		}
	return acctHolder;
}

}
