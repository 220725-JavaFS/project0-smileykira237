package com.revature.service;

import java.util.*;

import com.revature.models.AccountHolder;


public class WithdrawalService {

	private Scanner scanner = new Scanner(System.in);
	
	public AccountHolder withdrawalChecking(AccountHolder acctHolder) {
	
		System.out.println("\nHow much would you like to withdraw: ");
		
		try {
		String cWithdrawal = scanner.next().trim();
		double withdrawal = Double.valueOf(cWithdrawal);
		
		//checker for insufficient funds
		while(withdrawal > acctHolder.getcAcctBalance()) {
			System.out.println("\nInsufficient Funds: You only have $" + acctHolder.getcAcctBalance() + "0 in your checking account."
					+ "\nPlease enter an alternate amount: ");
			cWithdrawal = scanner.next().trim();
			withdrawal = Double.valueOf(cWithdrawal);
		}
		//checker for negative numbers
		while(withdrawal < 0) {
			System.out.println("\nError: Cannot withdraw a negative amount."
					+ "\nPlease enter an alternate value: ");
			cWithdrawal = scanner.next().trim();
			withdrawal = Double.valueOf(cWithdrawal);
		}
		
		double total = acctHolder.getcAcctBalance() - withdrawal;
		acctHolder.setcAcctBalance(total);
		
		System.out.println("\nYour withdrawal is complete." + "\nChecking Account Balance: $" + acctHolder.getcAcctBalance() + "0");
		
		}catch(NumberFormatException e) {
			System.out.println("\nError: Selection Invalid "+ e.getStackTrace());

			System.out.println("Rerouting to main menu ...");
		}
		return acctHolder;
	}
	
	public AccountHolder withdrawalSavings(AccountHolder acctHolder) {
		
		System.out.println("\nHow much would you like to withdraw: ");
		
		try {
		String sWithdrawal = scanner.next().trim();
		double withdrawal = Double.valueOf(sWithdrawal);
		
		//checker for insufficient funds
		while(withdrawal > acctHolder.getsAcctBalance()) {
			System.out.println("\nInsufficient Funds: You only have $" + acctHolder.getsAcctBalance() + "0 in your savings account."
					+ "\nPlease enter an alternate amount: ");
			sWithdrawal = scanner.next().trim();
			withdrawal = Double.valueOf(sWithdrawal);
		}
		//checker for negative numbers
				while(withdrawal < 0) {
					System.out.println("\nError: Cannot withdraw a negative amount."
							+ "\nPlease enter an alternate value: ");
					sWithdrawal = scanner.next().trim();
					withdrawal = Double.valueOf(sWithdrawal);
				}
		
		double total = acctHolder.getsAcctBalance() - withdrawal;
		acctHolder.setsAcctBalance(total);
		
		System.out.println("\nYour withdrawal is complete." + "\nSavings Account Balance: $" + acctHolder.getsAcctBalance() + "0");
		
		}catch(NumberFormatException e) {
			System.out.println("\nError: Selection Invalid "+ e.getStackTrace());

			System.out.println("Rerouting to main menu ...");
		}
		return acctHolder;
}

}
