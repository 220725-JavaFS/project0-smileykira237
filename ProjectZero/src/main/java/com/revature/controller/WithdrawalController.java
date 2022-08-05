package com.revature.controller;

import java.util.*;

import com.revature.service.WithdrawalService;

public class WithdrawalController {

	private Scanner scanner = new Scanner(System.in);
	private WithdrawalService wServ = new WithdrawalService();
	
	public void AcctWithdrawal() {
		
		System.out.println("\nWithdrawal Hub\n" + "\nAlright, I'll need a bit more information from you first. "
				+ "From which account would you like to make your withdrawal?");
		
		System.out.println("\n1) Checking Account" + "\n2) Savings Account");
		
		String selection = scanner.next().trim();
		
		switch (selection) {
	
		case "1": wServ.withdrawalChecking();
			break;
		case "2": wServ.withdrawalSavings();
			break;
		default:  System.out.println("\nError: Selection Invalid. Rerouting ...");
		}
	
}
}
