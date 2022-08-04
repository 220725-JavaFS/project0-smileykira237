package com.revature.controller;

import java.util.*;

import com.revature.service.OpenAcctService;

public class OpenAcctController {
	
	private Scanner scanner = new Scanner(System.in);
	OpenAcctService aServ = new OpenAcctService();
	
	public void openNewAcct() {
		
		System.out.println("\nNew Account Hub\n" + "\nAlright, I'll need a bit more information from you first. "
				+ "What type of account would you like to open?");
		
		System.out.println("\n1) Checking Account" + "\n2) Savings Account");
		
		int selection = scanner.nextInt();
		
		switch (selection) {
	
		case 1: aServ.openAcctChecking();
			break;
		case 2: aServ.openAcctSavings();
			break;
		default: System.out.println("Error: Selection Invalid!");
			break;
		}
	}

}
