package com.revature.service;

import java.util.*;

public class DepositService {
	
	private Scanner scanner = new Scanner(System.in);
	OpenAcctService oServ = new OpenAcctService();

	public void depositChecking() {
	
		System.out.println("\nHow much would you like to deposit: ");
		try {
		String cDeposit = scanner.next().trim();
		double deposit = Double.valueOf(cDeposit);
		
		double total = oServ.getcAcctBalance() + deposit;
		oServ.setcAcctBalance(total);
		
		System.out.println("\nYour deposit is complete." + "\nChecking Account Balance: $" + oServ.getcAcctBalance() + "0");
		}catch(NumberFormatException e) {
			System.out.println("\nError: Selection Invalid "+ e.getStackTrace());

			System.out.println("Rerouting to main menu ...");
		}
	}
	
	public void depositSavings() {
		
		System.out.println("\nHow much would you like to deposit: ");
		try {
		String sDeposit = scanner.next().trim();
		double deposit = Double.valueOf(sDeposit);
		
		double total = oServ.getsAcctBalance() + deposit;
		oServ.setsAcctBalance(total);
		
		System.out.println("\nYour deposit is complete." + "\nSavings Account Balance: $" + oServ.getsAcctBalance() + "0");
		}catch(NumberFormatException e) {
			System.out.println("\nError: Selection Invalid "+ e.getStackTrace());

			System.out.println("Rerouting to main menu ...");
		}
}
}
