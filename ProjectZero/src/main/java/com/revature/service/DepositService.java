package com.revature.service;

import java.util.*;

public class DepositService {
	
	private Scanner scanner = new Scanner(System.in);
	 OpenAcctService dOServ = new OpenAcctService();

	public double depositChecking() {
		
		dOServ.setcAcctBalance(5.0);
	
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
		
		double total = dOServ.getcAcctBalance() + deposit;
		dOServ.setcAcctBalance(total);
		
		System.out.println("\nYour deposit is complete." + "\nChecking Account Balance: $" + dOServ.getcAcctBalance() + "0");
		}catch(NumberFormatException e) {
			System.out.println("\nError: Selection Invalid "+ e.getStackTrace());

			System.out.println("Rerouting to main menu ...");
		}
		return dOServ.getcAcctBalance();
	}
	
	public double depositSavings() {
		
		dOServ.setsAcctBalance(5.0);
		
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
		
		double total = dOServ.getsAcctBalance() + deposit;
		dOServ.setsAcctBalance(total);
		
		System.out.println("\nYour deposit is complete." + "\nSavings Account Balance: $" + dOServ.getsAcctBalance() + "0");
		}catch(NumberFormatException e) {
			System.out.println("\nError: Selection Invalid "+ e.getStackTrace());

			System.out.println("Rerouting to main menu ...");
		}
		return dOServ.getcAcctBalance();
}
}
