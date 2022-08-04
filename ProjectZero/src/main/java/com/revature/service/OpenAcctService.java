package com.revature.service;

import java.util.*;

import com.revature.controller.MenuController;

public class OpenAcctService {

	private Scanner scanner = new Scanner(System.in);
	private double acctBalance = 5.00;
	private boolean hasDebitCard;
	
	public void openAcctChecking() {
		
		hasDebitCard = true;
		
		System.out.println("\nPlease fill in your contact information below:\n");
		
		System.out.println("Email:");
		String emailAddress = scanner.nextLine().trim();
		//valid email checker
		while (!emailAddress.contains("@") || !emailAddress.contains(".com")) {
			System.out.println("\nEmail address invalid. Please try again.\n" + "\nEmail:\n");
			emailAddress = scanner.nextLine().trim();
		}
		
		System.out.println("\nPhysical Address:");
		String address = scanner.nextLine().trim();	
		
		System.out.println("\nPrimary phone number:");
		long phoneNumber = scanner.nextLong();
		//valid phone checker
		while (phoneNumber <= 0000000000L || phoneNumber >= 10000000000L) {
			System.out.println("\nPhone number invalid. Please enter your 10-digit phone number, starting with"
					+ "the area code:");
			phoneNumber = scanner.nextLong();
		}
		
		System.out.println("\nThere is a $5.00 fee to open a new checking account. Do you still wish to proceed?");
		System.out.println("\n1) Yes" + "\n2) No");
		
		int selection = scanner.nextInt();
		
		switch (selection) {
		case 1: System.out.println("Thank you, your account information is as follows:\n");
		System.out.println("Email: " + emailAddress + "\nAddress: " + address + "\nPhone Number: "
				+ phoneNumber + "\nAccount Opened: Checking" + "\nAccount Balance: $" + acctBalance + "0");
		if(hasDebitCard == true) {
			System.out.println("Your new debit card should be delivered to the address provided within"
					+ "3-5 business days.");
		}
			break;
		case 2: System.out.println("\nI'm sorry, we cannot open an account for you at this time. Rerouting ...");
			break;
		default: System.out.println("Error: Selection Invalid!");
			break;
		}
	}
	
public void openAcctSavings() {
		
		hasDebitCard = false;
		
System.out.println("\nPlease fill in your contact information below:\n");
		
		System.out.println("Email:");
		String emailAddress = scanner.nextLine().trim();
		//valid email checker
		while (!emailAddress.contains("@") || !emailAddress.contains(".com")) {
			System.out.println("\nEmail address invalid. Please try again.\n" + "\nEmail:\n");
			emailAddress = scanner.nextLine().trim();
		}
		
		System.out.println("\nPhysical Address:");
		String address = scanner.nextLine().trim();	
		
		System.out.println("\nPrimary phone number:");
		long phoneNumber = scanner.nextLong();
		//valid phone checker
		while (phoneNumber <= 0000000000L || phoneNumber >= 10000000000L) {
			System.out.println("\nPhone number invalid. Please enter your 10-digit phone number, starting with"
					+ "the area code:");
			phoneNumber = scanner.nextLong();
		}
		
		System.out.println("\nThere is a $5.00 fee to open a new checking account. Do you still wish to proceed?");
		System.out.println("\n1) Yes" + "\n2) No");
		
		int selection = scanner.nextInt();
		
		switch (selection) {
		case 1: System.out.println("Thank you, your account information is as follows:\n");
		System.out.println("Email: " + emailAddress + "\nAddress: " + address + "\nPhone Number: "
				+ phoneNumber + "\nAccount Opened: Savings" + "\nAccount Balance: $" + acctBalance + "0");
		if(hasDebitCard == true) {
			System.out.println("Your new debit card should be delivered to the address provided within"
					+ "3-5 business days.");
		}
			break;
		case 2: System.out.println("\nI'm sorry, we cannot open an account for you at this time. Rerouting ...");
			break;
		default: System.out.println("Error: Selection Invalid!");
			break;
		}
	}

	public double getAcctBalance() {
		return acctBalance;
	}

	public void setAcctBalance(double acctBalance) {
		this.acctBalance = acctBalance;
	}
	
	
	}
//System.out.println("Thank you, your account information is as follows:\n");
//System.out.println("Email: " + emailAddress + "\nAddress: " + address + "\nPhone Number: "
//+ phoneNumber + "\nAccount Opened: Checking" + "\nAccount Balance: " + acctBalance);

	