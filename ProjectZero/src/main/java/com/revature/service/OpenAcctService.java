package com.revature.service;

import java.util.*;

import com.revature.controller.MenuController;

public class OpenAcctService {

	private Scanner scanner = new Scanner(System.in);
	private double acctBalance = 5.00;
	private boolean hasDebitCard = true;
	MenuController mCont = new MenuController();
	
	public void openAcctService() {
		
		System.out.println("\nPlease fill in your contact information below:\n");
		
		System.out.println("Email:");
		String emailAddress = scanner.nextLine().trim();
		//valid email checker
		while (!emailAddress.contains("@")) {
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
		System.out.println("\n1) Yes" + "\n2)No");
		
		int selection = scanner.nextInt();
		
		switch (selection) {
		case 1: System.out.println("");
			break;
		case 2: System.out.println("I'm sorry, we cannot open an account for you at this time. Would you like "
				+ "to return to main menu?\n" + "\n1) Yes" + "\n2) No");
		int nextSelection = scanner.nextInt();
		switch (nextSelection) {
		case 1: mCont.mainMenu();
			break;
		case 2: System.out.println("Now exiting online banking system ... Goodbye.");
			break;
		}
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
//+ phoneNumber);

//System.out.println("There is a $5.00 fee to open a new checking account. Do you still wish to proceed?");
//System.out.println("\n1) Yes" + "\n2)No");
	//int nextSelection = scanner.nextInt();
	//switch (nextSelection) {
	//case 1: System.out.println("");
		//break;
	//case 2:
		//break;
	//default: System.out.println("Error: Selection Invalid!");
			//break;
//	}
	