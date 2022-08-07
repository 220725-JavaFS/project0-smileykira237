package com.revature.service;

import java.util.Scanner;

import com.revature.models.AccountHolder;

public class AccountsServices {
	
	private Scanner scanner = new Scanner(System.in);
	private boolean hasDebitCard;
	
	public AccountHolder openAcctChecking(AccountHolder acctHolder) {
		
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
		
		String selection = scanner.next().trim();
		
		switch (selection) {
		case "1": System.out.println("Thank you, your account information is as follows:\n");
		System.out.println("Email: " + emailAddress + "\nAddress: " + address + "\nPhone Number: "
				+ phoneNumber + "\nAccount Opened: Checking" + "\nAccount Balance: $" + acctHolder.getcAcctBalance() + "0");
		if(hasDebitCard == true) {
			System.out.println("Your new debit card should be delivered to the address provided within"
					+ "3-5 business days.");
		}
			break;
		case "2": System.out.println("\nI'm sorry, we cannot open an account for you at this time. Rerouting ...");
			break;
		default: System.out.println("Error: Selection Invalid. Rerouting ...");
		}
		return acctHolder;
	}

	public AccountHolder openAcctSavings(AccountHolder acctHolder) {
		
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
		
		System.out.println("\nThere is a $5.00 fee to open a new savings account. Do you still wish to proceed?");
		System.out.println("\n1) Yes" + "\n2) No");
		
		String selection = scanner.next().trim();
		
		switch (selection) {
		case "1": System.out.println("Thank you, your account information is as follows:\n");
		System.out.println("Email: " + emailAddress + "\nAddress: " + address + "\nPhone Number: "
				+ phoneNumber + "\nAccount Opened: Savings" + "\nAccount Balance: $" + acctHolder.getsAcctBalance() + "0");
		if(hasDebitCard == true) {
			System.out.println("Your new debit card should be delivered to the address provided within"
					+ "3-5 business days.");
		}
			break;
		case "2": System.out.println("\nI'm sorry, we cannot open an account for you at this time. Rerouting ...");
			break;
		default: System.out.println("\nError: Selection Invalid. Rerouting ...");
		}
		return acctHolder;
	}

	public AccountHolder acctStatus(AccountHolder acctHolder) {
		System.out.println("Checking Account Balance: $" + acctHolder.getcAcctBalance() + "0");
		System.out.println("Savings Account Balance: $" + acctHolder.getsAcctBalance() + "0");
		
		return acctHolder;
	}

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
		
		System.out.println("\nYour transfer is complete." + "\nChecking Account Balance: $" + acctHolder.getcAcctBalance() + "0" 
				+ "\nSavings Account Balance: $" + acctHolder.getsAcctBalance() + "0");
		
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
