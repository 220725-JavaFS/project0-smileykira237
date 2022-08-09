package com.revature.service;

import java.util.List;
import java.util.Scanner;

import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerDAOImpl;
import com.revature.models.AccountHolder;

public class AccountsServices {
	
	private CustomerDAO customerDAO = new CustomerDAOImpl();
	private Scanner scanner = new Scanner(System.in);
	private boolean hasDebitCard;
	
	public AccountHolder openAcctChecking(AccountHolder acctHolder) {
		
		acctHolder.getUserName();
		acctHolder.getUserPassword();
		acctHolder.getFirstName();
		acctHolder.getLastName();
		
		System.out.println("\nPlease fill in your contact information below:\n");
		
		System.out.println("Email:");
		acctHolder.setEmail(scanner.nextLine().trim());
		//valid email checker
		while (!acctHolder.getEmail().contains("@") || !acctHolder.getEmail().contains(".com")) {
			System.out.println("\nEmail address invalid. Please try again.\n" + "\nEmail:");
			acctHolder.setEmail(scanner.nextLine().trim());
		}
		
		System.out.println("\nWe will also need your current address." + "\nStreet number: ");
		acctHolder.setStrNumber(scanner.nextLine().trim());
		
		System.out.println("\nStreet name: ");
		acctHolder.setStrName(scanner.nextLine().trim());
		
		System.out.println("\nCity: ");
		acctHolder.setCity(scanner.nextLine().trim());
		
		System.out.println("\nState: ");
		acctHolder.setState(scanner.nextLine().trim());
		
		System.out.println("\nZip: ");
		acctHolder.setZip(Integer.parseInt(scanner.nextLine().trim()));
		
		System.out.println("\nPrimary phone number:");
		acctHolder.setPhoneNumber(Long.parseLong(scanner.nextLine().trim()));
		//valid phone checker
		while (acctHolder.getPhoneNumber() <= 0000000000L || acctHolder.getPhoneNumber() >= 10000000000L) {
			System.out.println("\nPhone number invalid. Please enter your 10-digit phone number, starting with"
					+ "the area code:");
			acctHolder.setPhoneNumber(Long.parseLong(scanner.nextLine().trim()));
		}
		
		System.out.println("\nThere is a $5.00 fee to open a new checking account. Do you still wish to proceed?");
		System.out.println("\n1) Yes" + "\n2) No");
		
		String selection = scanner.next().trim();
		
		switch (selection) {
		case "1": System.out.println("Thank you, your account information is as follows:\n");
		System.out.println("Email: " + acctHolder.getEmail() + "\nHome address: " + acctHolder.getStrNumber() + " " + acctHolder.getStrName() 
		+ ", " + acctHolder.getCity() + ", " + acctHolder.getState() + ", " + acctHolder.getZip() + "\nPhone Number: " + acctHolder.getPhoneNumber() 
		+ "\nAccount Opened: Checking" + "\nAccount Balance: $" + acctHolder.getcAcctBalance() + "0");
		hasDebitCard = true;
		acctHolder.isSavingsAccount();
		acctHolder.setCheckingAccount(true);
		if(hasDebitCard == true) {
			System.out.println("Your new debit card should be delivered to the address provided within"
					+ "3-5 business days.");
		}
			break;
		case "2": System.out.println("\nI'm sorry, we cannot open an account for you at this time. Rerouting ...");
			break;
		default: System.out.println("Error: Selection Invalid. Rerouting ...");
		}
		insertCustomer(acctHolder);
		return acctHolder;
	}

	public AccountHolder openAcctSavings(AccountHolder acctHolder) {
		
		acctHolder.getUserName();
		acctHolder.getUserPassword();
		acctHolder.getFirstName();
		acctHolder.getLastName();
		
System.out.println("\nPlease fill in your contact information below:\n");
		
System.out.println("\nPlease fill in your contact information below:\n");

System.out.println("Email:");
acctHolder.setEmail(scanner.nextLine().trim());
//valid email checker
while (!acctHolder.getEmail().contains("@") || !acctHolder.getEmail().contains(".com")) {
	System.out.println("\nEmail address invalid. Please try again.\n" + "\nEmail:");
	acctHolder.setEmail(scanner.nextLine().trim());
}

System.out.println("\nWe will also need your current address." + "\nStreet number: ");
acctHolder.setStrNumber(scanner.nextLine().trim());

System.out.println("\nStreet name: ");
acctHolder.setStrName(scanner.nextLine().trim());

System.out.println("\nCity: ");
acctHolder.setCity(scanner.nextLine().trim());

System.out.println("\nState: ");
acctHolder.setState(scanner.nextLine().trim());

System.out.println("\nZip: ");
acctHolder.setZip(Integer.parseInt(scanner.nextLine()));

System.out.println("\nPrimary phone number:");
acctHolder.setPhoneNumber(Long.parseLong(scanner.nextLine()));
long answer = acctHolder.getPhoneNumber();
//valid phone checker
while (answer <= 0000000000L || answer >= 10000000000L) {
	System.out.println("\nPhone number invalid. Please enter your 10-digit phone number, starting with"
			+ "the area code:");
	acctHolder.setPhoneNumber(Long.parseLong(scanner.nextLine()));
}

System.out.println("\nThere is a $5.00 fee to open a new checking account. Do you still wish to proceed?");
System.out.println("\n1) Yes" + "\n2) No");

String selection = scanner.next().trim();

switch (selection) {
case "1": System.out.println("Thank you, your account information is as follows:\n");
System.out.println("Email: " + acctHolder.getEmail() + "\nHome address: " + acctHolder.getStrNumber() + " " + acctHolder.getStrName() 
+ ", " + acctHolder.getCity() + ", " + acctHolder.getState() + ", " + acctHolder.getZip() + "\nPhone Number: " + acctHolder.getPhoneNumber() 
+ "\nAccount Opened: Checking" + "\nAccount Balance: $" + acctHolder.getsAcctBalance() + "0");
hasDebitCard = true;
acctHolder.isCheckingAccount();
acctHolder.setSavingsAccount(true);
if(hasDebitCard == false) {
	System.out.println("Your new debit card should be delivered to the address provided within"
			+ "3-5 business days.");
}
	break;
case "2": System.out.println("\nI'm sorry, we cannot open an account for you at this time. Rerouting ...");
	break;
default: System.out.println("Error: Selection Invalid. Rerouting ...");
}
insertCustomer(acctHolder);
return acctHolder;
}

	public AccountHolder acctStatus(AccountHolder acctHolder) {
		System.out.println("Your account information is as follows:\n");
		System.out.println("Account holder: " + acctHolder.getFirstName() + " " + acctHolder.getLastName() + "\nUsername: " + acctHolder.getUserName()
		+ "\nEmail: " + acctHolder.getEmail() + "\nHome address: " + acctHolder.getStrNumber() + " " + acctHolder.getStrName() 
		+ ", " + acctHolder.getCity() + ", " + acctHolder.getState() + ", " + acctHolder.getZip() + "\nPhone Number: " + acctHolder.getPhoneNumber());
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
		System.out.println("\nError: Selection Invalid "+ e.getStackTrace() + "\n Try ommiting any commas or dollar signs you may have included.");

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
		System.out.println("\nError: Selection Invalid "+ e.getStackTrace() + "\n Try ommiting any commas or dollar signs you may have included.");

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
		System.out.println("\nError: Selection Invalid "+ e.getStackTrace() + "\n Try ommiting any commas or dollar signs you may have included.");

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
		System.out.println("\nError: Selection Invalid "+ e.getStackTrace() + "\n Try ommiting any commas or dollar signs you may have included.");

			System.out.println("Rerouting to main menu ...");
		}
		return acctHolder;
}
	
	public AccountHolder tChecking(AccountHolder acctHolder) {
		
		System.out.println("\nHow much would you like to transfer: ");
		
		try {
		String cTransfer = scanner.next().trim();
		double transfer = Double.valueOf(cTransfer);
		
		//checker for insufficient funds
		while(transfer > acctHolder.getcAcctBalance()) {
			System.out.println("\nInsufficient Funds: You only have $" + acctHolder.getcAcctBalance() + "0 in your checking account."
					+ "\nPlease enter an alternate amount: ");
			cTransfer = scanner.next().trim();
			transfer = Double.valueOf(cTransfer);
		}
		//checker for negative numbers
				while(transfer < 0) {
					System.out.println("\nError: Cannot transfer a negative amount."
							+ "\nPlease enter an alternate value: ");
					cTransfer = scanner.next().trim();
					transfer = Double.valueOf(cTransfer);
				}
		
		double total = acctHolder.getcAcctBalance() - transfer;
		acctHolder.setcAcctBalance(total);
		total = acctHolder.getsAcctBalance() + transfer;
		acctHolder.setsAcctBalance(total);
		
		System.out.println("\nYour transfer is complete." + "\nChecking Account Balance: $" + acctHolder.getcAcctBalance() + "0" 
				+ "\nSavings Account Balance: $" + acctHolder.getsAcctBalance() + "0");
		
		}catch(NumberFormatException e) {
		System.out.println("\nError: Selection Invalid "+ e.getStackTrace() + "\n Try ommiting any commas or dollar signs you may have included.");

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
		System.out.println("\nError: Selection Invalid "+ e.getStackTrace() + "\n Try ommiting any commas or dollar signs you may have included.");

			System.out.println("Rerouting to main menu ...");
		}
		return acctHolder;
}
	
	public AccountHolder getAccountHolderByUsername(String username) {
		return customerDAO.getAccountHolderByUsername(username);
	}

	public List<AccountHolder> getAllAccountHolders(){
		return customerDAO.getAllAccountHolders();
	}
	
	public void insertCustomer(AccountHolder acctHolder) {
		customerDAO.insertCustomer(acctHolder);
	}

}
