package com.revature.service;

import java.util.*;

import com.revature.models.AccountHolder;

public class TransferService {
	
	private Scanner scanner = new Scanner(System.in);
	
public AccountHolder tChecking(AccountHolder acctHolder) {
		
		System.out.println("\nHow much would you like to transfer: ");
		
		try {
		String sTransfer = scanner.next().trim();
		double transfer = Double.valueOf(sTransfer);
		
		//checker for insufficient funds
		while(transfer > acctHolder.getcAcctBalance()) {
			System.out.println("\nInsufficient Funds: You only have $" + acctHolder.getcAcctBalance() + "0 in your checking account."
					+ "\nPlease enter an alternate amount: ");
			sTransfer = scanner.next().trim();
			transfer = Double.valueOf(sTransfer);
		}
		//checker for negative numbers
				while(transfer < 0) {
					System.out.println("\nError: Cannot transfer a negative amount."
							+ "\nPlease enter an alternate value: ");
					sTransfer = scanner.next().trim();
					transfer = Double.valueOf(sTransfer);
				}
		
		double total = acctHolder.getcAcctBalance() - transfer;
		acctHolder.setcAcctBalance(total);
		total = acctHolder.getsAcctBalance() + transfer;
		acctHolder.setsAcctBalance(total);
		
		System.out.println("\nYour transfer is complete." + "\nSavings Account Balance: $" + acctHolder.getcAcctBalance() + "0" 
				+ "\nChecking Account Balance: $" + acctHolder.getsAcctBalance() + "0");
		
		}catch(NumberFormatException e) {
			System.out.println("\nError: Selection Invalid "+ e.getStackTrace());

			System.out.println("Rerouting to main menu ...");
		}
		return acctHolder;
}
	
public AccountHolder tSavings(AccountHolder acctHolder) {
		
		System.out.println("\nHow much would you like to transfer: ");
		
		try {
		String sTransfer = scanner.next().trim();
		double transfer = Double.valueOf(sTransfer);
		
		//checker for insufficient funds
		while(transfer > acctHolder.getsAcctBalance()) {
			System.out.println("\nInsufficient Funds: You only have $" + acctHolder.getsAcctBalance() + "0 in your savings account."
					+ "\nPlease enter an alternate amount: ");
			sTransfer = scanner.next().trim();
			transfer = Double.valueOf(sTransfer);
		}
		//checker for negative numbers
				while(transfer < 0) {
					System.out.println("\nError: Cannot transfer a negative amount."
							+ "\nPlease enter an alternate value: ");
					sTransfer = scanner.next().trim();
					transfer = Double.valueOf(sTransfer);
				}
		
		double total = acctHolder.getsAcctBalance() - transfer;
		acctHolder.setsAcctBalance(total);
		total = acctHolder.getcAcctBalance() + transfer;
		acctHolder.setcAcctBalance(total);
		
		System.out.println("\nYour transfer is complete." + "\nSavings Account Balance: $" + acctHolder.getsAcctBalance() + "0" 
				+ "\nChecking Account Balance: $" + acctHolder.getcAcctBalance() + "0");
		
		}catch(NumberFormatException e) {
			System.out.println("\nError: Selection Invalid "+ e.getStackTrace());

			System.out.println("Rerouting to main menu ...");
		}
		return acctHolder;
}

}
