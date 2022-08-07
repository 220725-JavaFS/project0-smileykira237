package com.revature.service;

import java.util.*;

import com.revature.models.AccountHolder;

public class DepositService {
	
	private Scanner scanner = new Scanner(System.in);

	public AccountHolder depositChecking(AccountHolder acctHolder) {
	
		System.out.println("\nHow much would you like to deposit: ");
		try {
		String cDeposit = scanner.next().trim();
		double deposit = Double.valueOf(cDeposit);
		
		//checker for negative numbers
		while(deposit < 0) {
			System.out.println("\nError: Cannot deposit a negative amount."
					+ "\nPlease enter an alternate value: ");
			cDeposit = scanner.next().trim();
			deposit = Double.valueOf(cDeposit);
		}
		
		double total = acctHolder.getcAcctBalance() + deposit;
		acctHolder.setcAcctBalance(total);
		
		System.out.println("\nYour deposit is complete." + "\nChecking Account Balance: $" + acctHolder.getcAcctBalance() + "0");
		}catch(NumberFormatException e) {
			System.out.println("\nError: Selection Invalid "+ e.getStackTrace());

			System.out.println("Rerouting to main menu ...");
		}
		return acctHolder;
	}
	
	public AccountHolder depositSavings(AccountHolder acctHolder) {
		
		System.out.println("\nHow much would you like to deposit: ");
		try {
		String sDeposit = scanner.next().trim();
		double deposit = Double.valueOf(sDeposit);
		
		//checker for negative numbers
		while(deposit < 0) {
			System.out.println("\nError: Cannot deposit a negative amount."
					+ "\nPlease enter an alternate value: ");
			sDeposit = scanner.next().trim();
			deposit = Double.valueOf(sDeposit);
		}
		
		double total = acctHolder.getsAcctBalance() + deposit;
		acctHolder.setsAcctBalance(total);
		
		System.out.println("\nYour deposit is complete." + "\nSavings Account Balance: $" + acctHolder.getsAcctBalance() + "0");
		}catch(NumberFormatException e) {
			System.out.println("\nError: Selection Invalid "+ e.getStackTrace());

			System.out.println("Rerouting to main menu ...");
		}
		return acctHolder;
}
}
