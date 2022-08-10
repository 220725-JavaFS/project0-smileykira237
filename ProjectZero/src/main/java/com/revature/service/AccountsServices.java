package com.revature.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerDAOImpl;
import com.revature.models.AccountHolder;
import com.revature.models.BankAdmin;
import com.revature.models.BankEmployee;
import com.revature.utilities.ConnectionUtility;

public class AccountsServices {
	
	private CustomerDAO customerDAO = new CustomerDAOImpl();
	private Scanner scanner = new Scanner(System.in);
	private boolean hasDebitCard;
	
	public AccountHolder openAcctChecking(AccountHolder acctHolder) {
		
		if (acctHolder.isSavingsAccount()) {
			try(Connection conn = ConnectionUtility.getConnection()){
				String sql = "update customers set checking_account = true where username = '" + acctHolder.getUserName() + "';"; 
				PreparedStatement statement = conn.prepareStatement(sql);

				statement.execute();
				
			}catch(SQLException e) {
				e.printStackTrace();
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
			return acctHolder;
		}
		
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
		//checker for valid state entry
		while (acctHolder.getState().length() != 2) {
			System.out.println("\nState entry invalid. Please make sure you are entering state abbreviations, "
					+ "e.g. 'NY', and try again.\n" + "\nState:");
			acctHolder.setState(scanner.nextLine().trim());
		}
		
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
		insertCustomer(acctHolder);
		if(hasDebitCard == true) {
			System.out.println("Your new debit card should be delivered to the address provided within"
					+ "3-5 business days.");
		}
			return acctHolder;
		case "2": System.out.println("\nI'm sorry, we cannot open an account for you at this time. Rerouting ...");
			return acctHolder;
		default: System.out.println("Error: Selection Invalid. Rerouting ...");
			return acctHolder;
		}
	}

	public AccountHolder openAcctSavings(AccountHolder acctHolder) {
		if (acctHolder.isCheckingAccount()) {
			try(Connection conn = ConnectionUtility.getConnection()){
				String sql = "update customers set savings_account = true where username = '" + acctHolder.getUserName() + "';"; 
				PreparedStatement statement = conn.prepareStatement(sql);

				statement.execute();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			System.out.println("\nThere is a $5.00 fee to open a new savings account. Do you still wish to proceed?");
			System.out.println("\n1) Yes" + "\n2) No");

			String selection = scanner.next().trim();

			switch (selection) {
			case "1": System.out.println("Thank you, your account information is as follows:\n");
			System.out.println("Email: " + acctHolder.getEmail() + "\nHome address: " + acctHolder.getStrNumber() + " " + acctHolder.getStrName() 
			+ ", " + acctHolder.getCity() + ", " + acctHolder.getState() + ", " + acctHolder.getZip() + "\nPhone Number: " + acctHolder.getPhoneNumber() 
			+ "\nAccount Opened: Savings" + "\nAccount Balance: $" + acctHolder.getsAcctBalance() + "0");
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
			return acctHolder;
		}
			
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
//checker for valid state entry
		while (acctHolder.getState().length() != 2) {
			System.out.println("\nState entry invalid. Please make sure you are entering state abbreviations, "
					+ "e.g. 'NY', and try again.\n" + "\nState:");
			acctHolder.setState(scanner.nextLine().trim());
		}

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

System.out.println("\nThere is a $5.00 fee to open a new savings account. Do you still wish to proceed?");
System.out.println("\n1) Yes" + "\n2) No");

String selection = scanner.next().trim();

switch (selection) {
case "1": System.out.println("Thank you, your account information is as follows:\n");
System.out.println("Email: " + acctHolder.getEmail() + "\nHome address: " + acctHolder.getStrNumber() + " " + acctHolder.getStrName() 
+ ", " + acctHolder.getCity() + ", " + acctHolder.getState() + ", " + acctHolder.getZip() + "\nPhone Number: " + acctHolder.getPhoneNumber() 
+ "\nAccount Opened: Savings" + "\nAccount Balance: $" + acctHolder.getsAcctBalance() + "0");
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
		
if(acctHolder.isCheckingAccount() == false && acctHolder.isSavingsAccount() == false) {
		System.out.println("Account holder: " + acctHolder.getFirstName() + " " + acctHolder.getLastName() + "\nUsername: " + acctHolder.getUserName()
		+ "\nEmail: " + acctHolder.getEmail() + "\nHome address: " + acctHolder.getStrNumber() + " " + acctHolder.getStrName() 
		+ ", " + acctHolder.getCity() + ", " + acctHolder.getState() + ", " + acctHolder.getZip() + "\nPhone Number: " + acctHolder.getPhoneNumber());
		System.out.println("Checking Account Balance: You do not have a checking account");
		System.out.println("Checking Account Balance: You do not have a savings account");
	return acctHolder;
		}else if(acctHolder.isSavingsAccount() == false) {
			System.out.println("Account holder: " + acctHolder.getFirstName() + " " + acctHolder.getLastName() + "\nUsername: " + acctHolder.getUserName()
			+ "\nEmail: " + acctHolder.getEmail() + "\nHome address: " + acctHolder.getStrNumber() + " " + acctHolder.getStrName() 
			+ ", " + acctHolder.getCity() + ", " + acctHolder.getState() + ", " + acctHolder.getZip() + "\nPhone Number: " + acctHolder.getPhoneNumber());
			System.out.println("Checking Account Balance: $" + acctHolder.getcAcctBalance() + "0");
			System.out.println("Checking Account Balance: You do not have a savings account");
			return acctHolder;
				}else if(acctHolder.isCheckingAccount() == false) {
					System.out.println("Account holder: " + acctHolder.getFirstName() + " " + acctHolder.getLastName() + "\nUsername: " + acctHolder.getUserName()
					+ "\nEmail: " + acctHolder.getEmail() + "\nHome address: " + acctHolder.getStrNumber() + " " + acctHolder.getStrName() 
					+ ", " + acctHolder.getCity() + ", " + acctHolder.getState() + ", " + acctHolder.getZip() + "\nPhone Number: " + acctHolder.getPhoneNumber());
					System.out.println("Checking Account Balance: You do not have a checking account");
					System.out.println("Savings Account Balance: $" + acctHolder.getsAcctBalance() + "0");
					return acctHolder;
				}
		
		System.out.println("Your account information is as follows:\n");
		System.out.println("Account holder: " + acctHolder.getFirstName() + " " + acctHolder.getLastName() + "\nUsername: " + acctHolder.getUserName()
		+ "\nEmail: " + acctHolder.getEmail() + "\nHome address: " + acctHolder.getStrNumber() + " " + acctHolder.getStrName() 
		+ ", " + acctHolder.getCity() + ", " + acctHolder.getState() + ", " + acctHolder.getZip() + "\nPhone Number: " + acctHolder.getPhoneNumber());
		System.out.println("Checking Account Balance: $" + acctHolder.getcAcctBalance() + "0");
		System.out.println("Savings Account Balance: $" + acctHolder.getsAcctBalance() + "0");
		
		return acctHolder;
	}

	public AccountHolder acctUpdater(AccountHolder acctHolder) {
		
		System.out.println("Your account information is as follows: " + "\nUsername: " + acctHolder.getUserName() + "\nPassword: " + acctHolder.getUserPassword()
		+ "\nEmail: " + acctHolder.getEmail() + "\nAddress: " + acctHolder.getStrNumber() + ", " + acctHolder.getStrName() + ", " + acctHolder.getCity()
		+ ", " + acctHolder.getState() + " " + acctHolder.getZip() + "\nPhone Number: " + acctHolder.getPhoneNumber() + "\nWhich record would you like to update?");
		
		String selection = scanner.nextLine().toLowerCase().trim();
		selection = scanner.nextLine().toLowerCase().trim();

		switch(selection) {
		case "username": System.out.println("\nWhat would you like to change your username to?");
		acctHolder.setUserName(scanner.nextLine().trim());
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "update customers set username = '" + acctHolder.getUserName() + "';"; 
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.execute();
			
		}catch(SQLException e) {
			System.out.println("");
		}
		System.out.println("Thank you, " + acctHolder.getFirstName() + ". Your username has been updated to:\n" + acctHolder.getUserName());
			break;
		case "password": System.out.println("\nWhat would you like to change your password to?");
		acctHolder.setUserPassword(scanner.nextLine().trim());
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "update customers set password = '" + acctHolder.getUserPassword() + "';"; 
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.execute();
			
		}catch(SQLException e) {
			System.out.println("");
		}
		System.out.println("Thank you, " + acctHolder.getFirstName() + ". Your password has been updated to:\n" + acctHolder.getUserPassword());
			break;
		case "email": System.out.println("\nWhat would you like to change your email to?");
		acctHolder.setEmail(scanner.nextLine().trim());
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "update customers set email = '" + acctHolder.getEmail() + "';"; 
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.execute();
			
		}catch(SQLException e) {
			System.out.println("");
		}
		System.out.println("Thank you, " + acctHolder.getFirstName() + ". Your email has been updated to:\n" + acctHolder.getEmail());
			break;
		case "address": System.out.println("\nWhat is your updated street number?");
		acctHolder.setStrNumber(scanner.nextLine().trim());
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "update customers set str_number = '" + acctHolder.getStrNumber() + "';"; 
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.execute();
			
		}catch(SQLException e) {
			System.out.println("");
		}
		System.out.println("\nStreet name?");
		acctHolder.setStrName(scanner.nextLine().trim());
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "update customers set str_name = '" + acctHolder.getStrName() + "';"; 
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.execute();
			
		}catch(SQLException e) {
			System.out.println("");
		}
		System.out.println("\nCity?");
		acctHolder.setCity(scanner.nextLine().trim());
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "update customers set city = '" + acctHolder.getCity() + "';"; 
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.execute();
			
		}catch(SQLException e) {
			System.out.println("");
		}
		System.out.println("\nState?");
		acctHolder.setState(scanner.nextLine().trim());
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "update customers set state = '" + acctHolder.getState() + "';"; 
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.execute();
			
		}catch(SQLException e) {
			System.out.println("");
		}
		System.out.println("\nZip?");
		acctHolder.setZip(Integer.parseInt(scanner.nextLine().trim()));
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "update customers set zip = '" + acctHolder.getZip() + "';"; 
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.execute();
			
		}catch(SQLException e) {
			System.out.println("");
		}
		System.out.println("Thank you, " + acctHolder.getFirstName() + "\nYour address has been updated to: \n" + acctHolder.getStrNumber() +
				", " + acctHolder.getStrName() + ", " + acctHolder.getCity() + ", " + acctHolder.getState() + " " + acctHolder.getZip());
			break;
		case "phone number": System.out.println("\nWhat would you like to change your phone number to?");
		acctHolder.setPhoneNumber(Long.parseLong(scanner.nextLine().trim()));
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "update customers set username = '" + acctHolder.getPhoneNumber() + "';"; 
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.execute();
			
		}catch(SQLException e) {
			System.out.println("");
		}
		System.out.println("Thank you, " + acctHolder.getFirstName() + "Your phone number has been updated to:\n" + acctHolder.getPhoneNumber());
			break;
			default: System.out.println("Entry invalid. Rerouting ...");
				break;
		}
		
		return acctHolder;
	}
	
	public AccountHolder depositChecking(AccountHolder acctHolder) {
		
	if(acctHolder.isCheckingAccount() == false) {
			System.out.println("\nYou do not have a checking account. Rerouting ...");
						return acctHolder;
					}
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
		if(acctHolder.isSavingsAccount() == false) {
			System.out.println("\nYou do not have a savings account. Rerouting ...");
						return acctHolder;
					}
		
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
		if(acctHolder.isCheckingAccount() == false) {
			System.out.println("\nYou do not have a checking account. Rerouting ...");
						return acctHolder;
					}
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
		if(acctHolder.isSavingsAccount() == false) {
			System.out.println("\nYou do not have a savings account. Rerouting ...");
						return acctHolder;
					}
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
		if(acctHolder.isCheckingAccount() == false) {
			System.out.println("\nYou do not have a checking account. Rerouting ...");
						return acctHolder;
					}
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
		if(acctHolder.isSavingsAccount() == false) {
			System.out.println("\nYou do not have a savings account. Rerouting ...");
						return acctHolder;
					}
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
	
	public BankEmployee checkingApps(BankEmployee employee) {
		
		System.out.println("Which would you like to do?" + "\n1) Approve an application" + "\n2) Deny an application");
		String selection = scanner.nextLine().trim();
		
		switch(selection) {
		case "1": try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "select first_name, last_name,checking_account from customers where checking_account = true;";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			System.out.println("\nBelow is a list of checking accounts recently applied for:");
			
			if(result.next()) {//resultSets have cursors. .next(); is called to move cursor to next group of values
						String one = result.getString("first_name");
						String two = result.getString("last_name");
						Boolean three = result.getBoolean("checking_account");
						String firstRecord = "First Name: " + one + "    Last Name: " + two + "    Has Checking: " + three; 
						System.out.println(firstRecord);

						String four = null, five = null;
						boolean six = false;
						if (result.next() != false) {
						four = result.getString("first_name");
						five = result.getString("last_name");
						six = result.getBoolean("checking_account"); 
						String secondRecord = "First Name: " + four + "    Last Name: " + five + "    Has Checking: " + six;
						System.out.println(secondRecord);
						}
						
						String seven = null, eight = null;
						boolean nine = false;
						if (result.next() != false) {
						 seven = result.getString("first_name");
						 eight = result.getString("last_name");
						 nine = result.getBoolean("checking_account");
						 String thirdRecord = "First Name: " + seven + "    Last Name: " + eight + "    Has Checking: " + nine;
						System.out.println(thirdRecord);
						}
						
						System.out.println("\nPlease choose the applicant you would like to approve: ");
						if (one != null) {
							System.out.println("1) " + one + " " + two);
						} else {System.out.println("");}
						if (four != null) {
							System.out.println("2) " + four + " " + five);
						} else {System.out.println("");}
						if (seven != null) {
							System.out.println("3) " + seven + " " + eight);
						} else{System.out.println("");}
						selection = scanner.nextLine().trim();
						
						switch(selection) {
						case "1": if (one != null) {
							System.out.println("Account Appoved! This customer can now fully utilize their new checking account.");
							
							try(Connection conn2 = ConnectionUtility.getConnection()){
								sql = "update customers set checking_account = true where first_name = '" + one + "';"; 
								PreparedStatement statement2 = conn2.prepareStatement(sql);

								statement2.execute();
								
							}catch(SQLException e) {
								e.printStackTrace();
							}
							
						} else{System.out.println("Empty record");}
							break;
						case "2":  if (four != null) {
							System.out.println("Account Appoved! This customer can now fully utilize their new checking account.");
							
							try(Connection conn2 = ConnectionUtility.getConnection()){
								sql = "update customers set checking_account = true where first_name = '" + four + "';"; 
								PreparedStatement statement2 = conn2.prepareStatement(sql);

								statement2.execute();
								
							}catch(SQLException e) {
								e.printStackTrace();
							}
							
						} else{System.out.println("Empty record");}
							break;
						case "3": if (seven != null) {
							System.out.println("Account Appoved! This customer can now fully utilize their new checking account.");
							
							try(Connection conn2 = ConnectionUtility.getConnection()){
								sql = "update customers set checking_account = true where first_name = '" + seven + "';"; 
								PreparedStatement statement2 = conn2.prepareStatement(sql);

								statement2.execute();
								
							}catch(SQLException e) {
								e.printStackTrace();
							}
							
						} else{System.out.println("Empty record");}
							break;
							default: System.out.println("Selection invalid. Rerouting ...");
								break;
						}
				return employee;
				}
			}catch(SQLException e) {
			e.printStackTrace();
		}
			break;
		case "2": try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "select first_name, last_name,checking_account from customers where checking_account = true;";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			System.out.println("\nBelow is a list of checking accounts recently applied for:");
			
			if(result.next()) {//resultSets have cursors. .next(); is called to move cursor to next group of values
						String one = result.getString("first_name");
						String two = result.getString("last_name");
						Boolean three = result.getBoolean("checking_account");
						String firstRecord = "First Name: " + one + "    Last Name: " + two + "    Has Checking: " + three; 
						System.out.println(firstRecord);

						String four = null, five = null;
						boolean six = false;
						if (result.next() != false) {
						four = result.getString("first_name");
						five = result.getString("last_name");
						six = result.getBoolean("checking_account"); 
						String secondRecord = "First Name: " + four + "    Last Name: " + five + "    Has Checking: " + six;
						System.out.println(secondRecord);
						}
						
						String seven = null, eight = null;
						boolean nine = false;
						if (result.next() != false) {
						 seven = result.getString("first_name");
						 eight = result.getString("last_name");
						 nine = result.getBoolean("checking_account");
						 String thirdRecord = "First Name: " + seven + "    Last Name: " + eight + "    Has Checking: " + nine;
						System.out.println(thirdRecord);
						}
						
						System.out.println("\nPlease choose the applicant you would like to deny: ");
						if (one != null) {
							System.out.println("1) " + one + " " + two);
						} else {System.out.println("");}
						if (four != null) {
							System.out.println("2) " + four + " " + five);
						} else {System.out.println("");}
						if (seven != null) {
							System.out.println("3) " + seven + " " + eight);
						} else{System.out.println("");}
						selection = scanner.nextLine().trim();
						
						switch(selection) {
						case "1": if (one != null) {
							System.out.println("\nAccount Denied! This customer can no longer utilize their checking account functionality.");
							
								try(Connection conn2 = ConnectionUtility.getConnection()){
									sql = "update customers set checking_account = false where first_name = '" + one + "';"; 
									PreparedStatement statement2 = conn2.prepareStatement(sql);

									statement2.execute();
									
								}catch(SQLException e) {
									e.printStackTrace();
								}
							
						} else{System.out.println("Empty record");}
							break;
						case "2":  if (four != null) {
							System.out.println("Account Denied! This customer can no longer utilize their checking account functionality.");
							
							try(Connection conn2 = ConnectionUtility.getConnection()){
								sql = "update customers set checking_account = false where first_name = '" + four + "';"; 
								PreparedStatement statement2 = conn2.prepareStatement(sql);

								statement2.execute();
								
							}catch(SQLException e) {
								e.printStackTrace();
							}
						} else{System.out.println("Empty record");}
							break;
						case "3": if (seven != null) {
							System.out.println("Account Denied! This customer can no longer utilize their checking account functionality.");
							
							try(Connection conn2 = ConnectionUtility.getConnection()){
								sql = "update customers set checking_account = false where first_name = '" + seven + "';"; 
								PreparedStatement statement2 = conn2.prepareStatement(sql);

								statement2.execute();
								
							}catch(SQLException e) {
								e.printStackTrace();
							}
							
						} else{System.out.println("Empty record");}
							break;
							default: System.out.println("Selection invalid. Rerouting ...");
								break;
						}
				return employee;
				}
			}catch(SQLException e) {
			e.printStackTrace();
		}
			break;
		}
		return employee;
	}

	public BankEmployee savingsApps(BankEmployee employee) {
		
		System.out.println("\nWhich would you like to do?" + "\n1) Approve an application" + "\n2) Deny an application");
		String selection = scanner.nextLine().trim();
		
		switch(selection) {
		case "1": try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "select first_name, last_name,savings_account from customers where savings_account = true;";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			System.out.println("\nBelow is a list of savings accounts recently applied for:");
			
			if(result.next()) {//resultSets have cursors. .next(); is called to move cursor to next group of values
						String one = result.getString("first_name");
						String two = result.getString("last_name");
						Boolean three = result.getBoolean("savings_account");
						String firstRecord = "First Name: " + one + "    Last Name: " + two + "    Has Savings: " + three; 
						System.out.println(firstRecord);

						String four = null, five = null;
						boolean six = false;
						if (result.next() != false) {
						four = result.getString("first_name");
						five = result.getString("last_name");
						six = result.getBoolean("savings_account"); 
						String secondRecord = "First Name: " + four + "    Last Name: " + five + "    Has Savings: " + six;
						System.out.println(secondRecord);
						}
						
						String seven = null, eight = null;
						boolean nine = false;
						if (result.next() != false) {
						 seven = result.getString("first_name");
						 eight = result.getString("last_name");
						 nine = result.getBoolean("savings_account");
						 String thirdRecord = "First Name: " + seven + "    Last Name: " + eight + "    Has Savings: " + nine;
						System.out.println(thirdRecord);
						}
						
						System.out.println("\nPlease choose the applicant you would like to approve: ");
						if (one != null) {
							System.out.println("1) " + one + " " + two);
						} else {System.out.println("");}
						if (four != null) {
							System.out.println("2) " + four + " " + five);
						} else {System.out.println("");}
						if (seven != null) {
							System.out.println("3) " + seven + " " + eight);
						} else{System.out.println("");}
						selection = scanner.nextLine().trim();
						
						switch(selection) {
						case "1": if (one != null) {
							System.out.println("Account Appoved! This customer can now fully utilize their new savings account.");
							
							try(Connection conn2 = ConnectionUtility.getConnection()){
								sql = "update customers set savings_account = true where first_name = '" + one + "';"; 
								PreparedStatement statement2 = conn2.prepareStatement(sql);

								statement2.execute();
								
							}catch(SQLException e) {
								e.printStackTrace();
							}
							
						} else{System.out.println("Empty record");}
							break;
						case "2":  if (four != null) {
							System.out.println("Account Appoved! This customer can now fully utilize their new savings account.");
							
							try(Connection conn2 = ConnectionUtility.getConnection()){
								sql = "update customers set savings_account = true where first_name = '" + four + "';"; 
								PreparedStatement statement2 = conn2.prepareStatement(sql);

								statement2.execute();
								
							}catch(SQLException e) {
								e.printStackTrace();
							}
							
						} else{System.out.println("Empty record");}
							break;
						case "3": if (seven != null) {
							System.out.println("Account Appoved! This customer can now fully utilize their new savings account.");
							
							try(Connection conn2 = ConnectionUtility.getConnection()){
								sql = "update customers set savings_account = true where first_name = '" + seven + "';"; 
								PreparedStatement statement2 = conn2.prepareStatement(sql);

								statement2.execute();
								
							}catch(SQLException e) {
								e.printStackTrace();
							}
							
						} else{System.out.println("Empty record");}
							break;
							default: System.out.println("Selection invalid. Rerouting ...");
								break;
						}
				return employee;
				}
			}catch(SQLException e) {
			e.printStackTrace();
		}
			break;
		case "2": try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "select first_name, last_name,savings_account from customers where savings_account = true;";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			System.out.println("\nBelow is a list of savings accounts recently applied for:");
			
			if(result.next()) {//resultSets have cursors. .next(); is called to move cursor to next group of values
						String one = result.getString("first_name");
						String two = result.getString("last_name");
						Boolean three = result.getBoolean("savings_account");
						String firstRecord = "First Name: " + one + "    Last Name: " + two + "    Has Savings: " + three; 
						System.out.println(firstRecord);

						String four = null, five = null;
						boolean six = false;
						if (result.next() != false) {
						four = result.getString("first_name");
						five = result.getString("last_name");
						six = result.getBoolean("savings_account"); 
						String secondRecord = "First Name: " + four + "    Last Name: " + five + "    Has Savings: " + six;
						System.out.println(secondRecord);
						}
						
						String seven = null, eight = null;
						boolean nine = false;
						if (result.next() != false) {
						 seven = result.getString("first_name");
						 eight = result.getString("last_name");
						 nine = result.getBoolean("savings_account");
						 String thirdRecord = "First Name: " + seven + "    Last Name: " + eight + "    Has Savings: " + nine;
						System.out.println(thirdRecord);
						}
						
						System.out.println("\nPlease choose the applicant you would like to deny: ");
						if (one != null) {
							System.out.println("1) " + one + " " + two);
						} else {System.out.println("");}
						if (four != null) {
							System.out.println("2) " + four + " " + five);
						} else {System.out.println("");}
						if (seven != null) {
							System.out.println("3) " + seven + " " + eight);
						} else{System.out.println("");}
						selection = scanner.nextLine().trim();
						
						switch(selection) {
						case "1": if (one != null) {
							System.out.println("\nAccount Denied! This customer can no longer utilize their savings account functionality.");
							
								try(Connection conn2 = ConnectionUtility.getConnection()){
									sql = "update customers set savings_account = false where first_name = '" + one + "';"; 
									PreparedStatement statement2 = conn2.prepareStatement(sql);

									statement2.execute();
									
								}catch(SQLException e) {
									e.printStackTrace();
								}
							
						} else{System.out.println("Empty record");}
							break;
						case "2":  if (four != null) {
							System.out.println("Account Denied! This customer can no longer utilize their savings account functionality.");
							
							try(Connection conn2 = ConnectionUtility.getConnection()){
								sql = "update customers set savings_account = false where first_name = '" + four + "';"; 
								PreparedStatement statement2 = conn2.prepareStatement(sql);

								statement2.execute();
								
							}catch(SQLException e) {
								e.printStackTrace();
							}
						} else{System.out.println("Empty record");}
							break;
						case "3": if (seven != null) {
							System.out.println("Account Denied! This customer can no longer utilize their savings account functionality.");
							
							try(Connection conn2 = ConnectionUtility.getConnection()){
								sql = "update customers set savings_account = false where first_name = '" + seven + "';"; 
								PreparedStatement statement2 = conn2.prepareStatement(sql);

								statement2.execute();
								
							}catch(SQLException e) {
								e.printStackTrace();
							}
							
						} else{System.out.println("Empty record");}
							break;
							default: System.out.println("Selection invalid. Rerouting ...");
								break;
						}
				return employee;
				}
			}catch(SQLException e) {
			e.printStackTrace();
		}
			break;
		}
		return employee;
	}

	public BankAdmin checkingApps(BankAdmin admin) {
		
		System.out.println("Which would you like to do?" + "\n1) Approve an application" + "\n2) Deny an application");
		String selection = scanner.nextLine().trim();
		
		switch(selection) {
		case "1": try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "select first_name, last_name,checking_account from customers where checking_account = true;";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			System.out.println("\nBelow is a list of checking accounts recently applied for:");
			
			if(result.next()) {//resultSets have cursors. .next(); is called to move cursor to next group of values
						String one = result.getString("first_name");
						String two = result.getString("last_name");
						Boolean three = result.getBoolean("checking_account");
						String firstRecord = "First Name: " + one + "    Last Name: " + two + "    Has Checking: " + three; 
						System.out.println(firstRecord);

						String four = null, five = null;
						boolean six = false;
						if (result.next() != false) {
						four = result.getString("first_name");
						five = result.getString("last_name");
						six = result.getBoolean("checking_account"); 
						String secondRecord = "First Name: " + four + "    Last Name: " + five + "    Has Checking: " + six;
						System.out.println(secondRecord);
						}
						
						String seven = null, eight = null;
						boolean nine = false;
						if (result.next() != false) {
						 seven = result.getString("first_name");
						 eight = result.getString("last_name");
						 nine = result.getBoolean("checking_account");
						 String thirdRecord = "First Name: " + seven + "    Last Name: " + eight + "    Has Checking: " + nine;
						System.out.println(thirdRecord);
						}
						
						System.out.println("\nPlease choose the applicant you would like to approve: ");
						if (one != null) {
							System.out.println("1) " + one + " " + two);
						} else {System.out.println("");}
						if (four != null) {
							System.out.println("2) " + four + " " + five);
						} else {System.out.println("");}
						if (seven != null) {
							System.out.println("3) " + seven + " " + eight);
						} else{System.out.println("");}
						selection = scanner.nextLine().trim();
						
						switch(selection) {
						case "1": if (one != null) {
							System.out.println("Account Appoved! This customer can now fully utilize their new checking account.");
							
							try(Connection conn2 = ConnectionUtility.getConnection()){
								sql = "update customers set checking_account = true where first_name = '" + one + "';"; 
								PreparedStatement statement2 = conn2.prepareStatement(sql);

								statement2.execute();
								
							}catch(SQLException e) {
								e.printStackTrace();
							}
							
						} else{System.out.println("Empty record");}
							break;
						case "2":  if (four != null) {
							System.out.println("Account Appoved! This customer can now fully utilize their new checking account.");
							
							try(Connection conn2 = ConnectionUtility.getConnection()){
								sql = "update customers set checking_account = true where first_name = '" + four + "';"; 
								PreparedStatement statement2 = conn2.prepareStatement(sql);

								statement2.execute();
								
							}catch(SQLException e) {
								e.printStackTrace();
							}
							
						} else{System.out.println("Empty record");}
							break;
						case "3": if (seven != null) {
							System.out.println("Account Appoved! This customer can now fully utilize their new checking account.");
							
							try(Connection conn2 = ConnectionUtility.getConnection()){
								sql = "update customers set checking_account = true where first_name = '" + seven + "';"; 
								PreparedStatement statement2 = conn2.prepareStatement(sql);

								statement2.execute();
								
							}catch(SQLException e) {
								e.printStackTrace();
							}
							
						} else{System.out.println("Empty record");}
							break;
							default: System.out.println("Selection invalid. Rerouting ...");
								break;
						}
				return admin;
				}
			}catch(SQLException e) {
			e.printStackTrace();
		}
			break;
		case "2": try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "select first_name, last_name,checking_account from customers where checking_account = true;";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			System.out.println("\nBelow is a list of checking accounts recently applied for:");
			
			if(result.next()) {//resultSets have cursors. .next(); is called to move cursor to next group of values
						String one = result.getString("first_name");
						String two = result.getString("last_name");
						Boolean three = result.getBoolean("checking_account");
						String firstRecord = "First Name: " + one + "    Last Name: " + two + "    Has Checking: " + three; 
						System.out.println(firstRecord);

						String four = null, five = null;
						boolean six = false;
						if (result.next() != false) {
						four = result.getString("first_name");
						five = result.getString("last_name");
						six = result.getBoolean("checking_account"); 
						String secondRecord = "First Name: " + four + "    Last Name: " + five + "    Has Checking: " + six;
						System.out.println(secondRecord);
						}
						
						String seven = null, eight = null;
						boolean nine = false;
						if (result.next() != false) {
						 seven = result.getString("first_name");
						 eight = result.getString("last_name");
						 nine = result.getBoolean("checking_account");
						 String thirdRecord = "First Name: " + seven + "    Last Name: " + eight + "    Has Checking: " + nine;
						System.out.println(thirdRecord);
						}
						
						System.out.println("\nPlease choose the applicant you would like to deny: ");
						if (one != null) {
							System.out.println("1) " + one + " " + two);
						} else {System.out.println("");}
						if (four != null) {
							System.out.println("2) " + four + " " + five);
						} else {System.out.println("");}
						if (seven != null) {
							System.out.println("3) " + seven + " " + eight);
						} else{System.out.println("");}
						selection = scanner.nextLine().trim();
						
						switch(selection) {
						case "1": if (one != null) {
							System.out.println("\nAccount Denied! This customer can no longer utilize their checking account functionality.");
							
								try(Connection conn2 = ConnectionUtility.getConnection()){
									sql = "update customers set checking_account = false where first_name = '" + one + "';"; 
									PreparedStatement statement2 = conn2.prepareStatement(sql);

									statement2.execute();
									
								}catch(SQLException e) {
									e.printStackTrace();
								}
							
						} else{System.out.println("Empty record");}
							break;
						case "2":  if (four != null) {
							System.out.println("Account Denied! This customer can no longer utilize their checking account functionality.");
							
							try(Connection conn2 = ConnectionUtility.getConnection()){
								sql = "update customers set checking_account = false where first_name = '" + four + "';"; 
								PreparedStatement statement2 = conn2.prepareStatement(sql);

								statement2.execute();
								
							}catch(SQLException e) {
								e.printStackTrace();
							}
						} else{System.out.println("Empty record");}
							break;
						case "3": if (seven != null) {
							System.out.println("Account Denied! This customer can no longer utilize their checking account functionality.");
							
							try(Connection conn2 = ConnectionUtility.getConnection()){
								sql = "update customers set checking_account = false where first_name = '" + seven + "';"; 
								PreparedStatement statement2 = conn2.prepareStatement(sql);

								statement2.execute();
								
							}catch(SQLException e) {
								e.printStackTrace();
							}
							
						} else{System.out.println("Empty record");}
							break;
							default: System.out.println("Selection invalid. Rerouting ...");
								break;
						}
				return admin;
				}
			}catch(SQLException e) {
			e.printStackTrace();
		}
			break;
		}
		return admin;
	}

	public BankAdmin savingsApps(BankAdmin admin) {
		
		System.out.println("\nWhich would you like to do?" + "\n1) Approve an application" + "\n2) Deny an application");
		String selection = scanner.nextLine().trim();
		
		switch(selection) {
		case "1": try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "select first_name, last_name,savings_account from customers where savings_account = true;";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			System.out.println("\nBelow is a list of savings accounts recently applied for:");
			
			if(result.next()) {//resultSets have cursors. .next(); is called to move cursor to next group of values
						String one = result.getString("first_name");
						String two = result.getString("last_name");
						Boolean three = result.getBoolean("savings_account");
						String firstRecord = "First Name: " + one + "    Last Name: " + two + "    Has Savings: " + three; 
						System.out.println(firstRecord);

						String four = null, five = null;
						boolean six = false;
						if (result.next() != false) {
						four = result.getString("first_name");
						five = result.getString("last_name");
						six = result.getBoolean("savings_account"); 
						String secondRecord = "First Name: " + four + "    Last Name: " + five + "    Has Savings: " + six;
						System.out.println(secondRecord);
						}
						
						String seven = null, eight = null;
						boolean nine = false;
						if (result.next() != false) {
						 seven = result.getString("first_name");
						 eight = result.getString("last_name");
						 nine = result.getBoolean("savings_account");
						 String thirdRecord = "First Name: " + seven + "    Last Name: " + eight + "    Has Savings: " + nine;
						System.out.println(thirdRecord);
						}
						
						System.out.println("\nPlease choose the applicant you would like to approve: ");
						if (one != null) {
							System.out.println("1) " + one + " " + two);
						} else {System.out.println("");}
						if (four != null) {
							System.out.println("2) " + four + " " + five);
						} else {System.out.println("");}
						if (seven != null) {
							System.out.println("3) " + seven + " " + eight);
						} else{System.out.println("");}
						selection = scanner.nextLine().trim();
						
						switch(selection) {
						case "1": if (one != null) {
							System.out.println("Account Appoved! This customer can now fully utilize their new savings account.");
							
							try(Connection conn2 = ConnectionUtility.getConnection()){
								sql = "update customers set savings_account = true where first_name = '" + one + "';"; 
								PreparedStatement statement2 = conn2.prepareStatement(sql);

								statement2.execute();
								
							}catch(SQLException e) {
								e.printStackTrace();
							}
							
						} else{System.out.println("Empty record");}
							break;
						case "2":  if (four != null) {
							System.out.println("Account Appoved! This customer can now fully utilize their new savings account.");
							
							try(Connection conn2 = ConnectionUtility.getConnection()){
								sql = "update customers set savings_account = true where first_name = '" + four + "';"; 
								PreparedStatement statement2 = conn2.prepareStatement(sql);

								statement2.execute();
								
							}catch(SQLException e) {
								e.printStackTrace();
							}
							
						} else{System.out.println("Empty record");}
							break;
						case "3": if (seven != null) {
							System.out.println("Account Appoved! This customer can now fully utilize their new savings account.");
							
							try(Connection conn2 = ConnectionUtility.getConnection()){
								sql = "update customers set savings_account = true where first_name = '" + seven + "';"; 
								PreparedStatement statement2 = conn2.prepareStatement(sql);

								statement2.execute();
								
							}catch(SQLException e) {
								e.printStackTrace();
							}
							
						} else{System.out.println("Empty record");}
							break;
							default: System.out.println("Selection invalid. Rerouting ...");
								break;
						}
				return admin;
				}
			}catch(SQLException e) {
			e.printStackTrace();
		}
			break;
		case "2": try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "select first_name, last_name,savings_account from customers where savings_account = true;";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			System.out.println("\nBelow is a list of savings accounts recently applied for:");
			
			if(result.next()) {//resultSets have cursors. .next(); is called to move cursor to next group of values
						String one = result.getString("first_name");
						String two = result.getString("last_name");
						Boolean three = result.getBoolean("savings_account");
						String firstRecord = "First Name: " + one + "    Last Name: " + two + "    Has Savings: " + three; 
						System.out.println(firstRecord);

						String four = null, five = null;
						boolean six = false;
						if (result.next() != false) {
						four = result.getString("first_name");
						five = result.getString("last_name");
						six = result.getBoolean("savings_account"); 
						String secondRecord = "First Name: " + four + "    Last Name: " + five + "    Has Savings: " + six;
						System.out.println(secondRecord);
						}
						
						String seven = null, eight = null;
						boolean nine = false;
						if (result.next() != false) {
						 seven = result.getString("first_name");
						 eight = result.getString("last_name");
						 nine = result.getBoolean("savings_account");
						 String thirdRecord = "First Name: " + seven + "    Last Name: " + eight + "    Has Savings: " + nine;
						System.out.println(thirdRecord);
						}
						
						System.out.println("\nPlease choose the applicant you would like to deny: ");
						if (one != null) {
							System.out.println("1) " + one + " " + two);
						} else {System.out.println("");}
						if (four != null) {
							System.out.println("2) " + four + " " + five);
						} else {System.out.println("");}
						if (seven != null) {
							System.out.println("3) " + seven + " " + eight);
						} else{System.out.println("");}
						selection = scanner.nextLine().trim();
						
						switch(selection) {
						case "1": if (one != null) {
							System.out.println("\nAccount Denied! This customer can no longer utilize their savings account functionality.");
							
								try(Connection conn2 = ConnectionUtility.getConnection()){
									sql = "update customers set savings_account = false where first_name = '" + one + "';"; 
									PreparedStatement statement2 = conn2.prepareStatement(sql);

									statement2.execute();
									
								}catch(SQLException e) {
									e.printStackTrace();
								}
							
						} else{System.out.println("Empty record");}
							break;
						case "2":  if (four != null) {
							System.out.println("Account Denied! This customer can no longer utilize their savings account functionality.");
							
							try(Connection conn2 = ConnectionUtility.getConnection()){
								sql = "update customers set savings_account = false where first_name = '" + four + "';"; 
								PreparedStatement statement2 = conn2.prepareStatement(sql);

								statement2.execute();
								
							}catch(SQLException e) {
								e.printStackTrace();
							}
						} else{System.out.println("Empty record");}
							break;
						case "3": if (seven != null) {
							System.out.println("Account Denied! This customer can no longer utilize their savings account functionality.");
							
							try(Connection conn2 = ConnectionUtility.getConnection()){
								sql = "update customers set savings_account = false where first_name = '" + seven + "';"; 
								PreparedStatement statement2 = conn2.prepareStatement(sql);

								statement2.execute();
								
							}catch(SQLException e) {
								e.printStackTrace();
							}
							
						} else{System.out.println("Empty record");}
							break;
							default: System.out.println("Selection invalid. Rerouting ...");
								break;
						}
				return admin;
				}
			}catch(SQLException e) {
			e.printStackTrace();
		}
			break;
		}
		return admin;
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
