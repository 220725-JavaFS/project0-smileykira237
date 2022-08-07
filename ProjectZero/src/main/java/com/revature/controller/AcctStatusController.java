package com.revature.controller;

import java.util.*;

import com.revature.models.AccountHolder;
import com.revature.service.AcctStatusService;

public class AcctStatusController {
	
	private Scanner scanner = new Scanner(System.in);
	private AcctStatusService acctStatServ = new AcctStatusService();
	
	public AccountHolder AcctStatus(AccountHolder acctHolder) {
		
		System.out.println("\nAccount Status\n" + "\nAlright, I'll need a bit more information from you first. "
				+ "For which account would you like to view the status?");
		
		System.out.println("\n1) Checking Account" + "\n2) Savings Account");
		
		String selection = scanner.next().trim();
		
		switch (selection) {
	
		case "1": acctHolder = acctStatServ.statChecking(acctHolder);
			break;
		case "2": acctHolder = acctStatServ.statSavings(acctHolder);
			break;
		default:  System.out.println("\nError: Selection Invalid. Rerouting ...");
		}
	return acctHolder;
}

}
