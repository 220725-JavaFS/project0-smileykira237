package com.revature.controller;

import java.util.*;

import com.revature.service.DepositService;

public class DepositController {
	
	private Scanner scanner = new Scanner(System.in);
	private DepositService dServ = new DepositService();
	
	public void AcctDeposit() {
		
		System.out.println("\nDeposit Hub\n" + "\nAlright, I'll need a bit more information from you first. "
				+ "In which account would you like to make your deposit?");
		
		System.out.println("\n1) Checking Account" + "\n2) Savings Account");
		
		String selection = scanner.next().trim();
		
		switch (selection) {
	
		case "1": dServ.depositChecking();
			break;
		case "2": dServ.depositSavings();
			break;
		default:  System.out.println("\nError: Selection Invalid. Rerouting ...");
		}
	}

}
