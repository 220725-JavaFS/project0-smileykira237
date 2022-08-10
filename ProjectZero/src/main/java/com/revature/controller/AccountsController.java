package com.revature.controller;

import java.util.*;

import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerDAOImpl;
import com.revature.models.AccountHolder;
import com.revature.models.BankEmployee;
import com.revature.models.BankAdmin;
import com.revature.service.AccountsServices;

public class AccountsController {

	private Scanner scanner = new Scanner(System.in);
	private AccountsServices acctsServ = new AccountsServices(); 
	private CustomerDAO cDAO = new CustomerDAOImpl();
	
public AccountHolder register(AccountHolder acctHolder) {
		
		System.out.println("Registration Hub\n" + "\n" + "In order for you to register for a new account, I need some information first.");
		System.out.println("What is your first name?");
		acctHolder.setFirstName(scanner.nextLine().trim());
		
		System.out.println("\nWhat is your last name?");
		acctHolder.setLastName(scanner.nextLine().trim());
		
		System.out.println("\nThank you, " + acctHolder.getFirstName() + ". Now, you will need to create a username for your new account.");
		System.out.println("Please enter your new username here: ");
		acctHolder.setUserName(scanner.nextLine().trim());
		
		System.out.println("\nGreat! Last step, you will need to create a password");
		System.out.println("Please enter your new password here: ");
		acctHolder.setUserPassword(scanner.nextLine().trim());
		
		System.out.println("\nThank you " + acctHolder.getFirstName() + ", your account set-up is complete.");
		System.out.println("Your account details are as follows: ");
		System.out.println("UserName: " + acctHolder.getUserName());
		System.out.println("Password: " + acctHolder.getUserPassword());
		System.out.println("Please keep this information somewhere safe.\n");
		
		return acctHolder;
	}	
	
public AccountHolder signIn(AccountHolder acctHolder) {
	 
	try {
	 System.out.println("\nSign-in Hub\n" + "\n" + "Please enter username: ");
	 String answer = scanner.nextLine().trim();
	 
	 //checker for valid user-name
	 while(!acctHolder.getUserName().equalsIgnoreCase(answer)) {
		 System.out.println("\nError: Username does not exist. Please try again: ");
		 answer = scanner.nextLine().trim();
	 }
		 System.out.println("\nThank you, " + acctHolder.getUserName() + ". Enter password: ");
		 answer = scanner.nextLine().trim();
		 
		 //check for valid password
		 while(!acctHolder.getUserPassword().equals(answer)) {
			 System.out.println("\nError: Password incorrect. Please try again: ");
			 answer = scanner.nextLine().trim();
		 }
		 System.out.println("\nWelcome, " + acctHolder.getFirstName());
			return acctHolder;

	 }catch(Exception e){
		System.out.println("Error: " + e.getStackTrace() + "\nThis user does not exist ...");
		return null;
	}
}

public BankEmployee employeeMenu(BankEmployee employee) {
	System.out.println("\nEmployee Hub\n" + "\n" + "Please enter employee ID: ");
	 String answer = scanner.nextLine().trim();
	 
	 //checker for valid employeeID
	 while(!employee.getEmployeeID().equalsIgnoreCase(answer)) {
		 System.out.println("\nError: Employee ID does not exist. Please try again: ");
		 answer = scanner.nextLine().trim();
	 }
	 
	 System.out.println("\nThank you, " + employee.getEmployeeID() + ". Enter access code: ");
	 answer = scanner.nextLine().trim();
	 
	 //check for valid password
	 while(!employee.getAccessCode().equals(answer)) {
		 System.out.println("\nError: access code incorrect. Please try again: ");
		 answer = scanner.nextLine().trim();
	 }
	 System.out.println("\nWelcome, " + employee.getFirstName());
	 
	 while(answer.contentEquals(answer)) {
		 System.out.println("\nEmployee Transaction Menu\n");
		System.out.println("Please choose from the following menu options: ");
		System.out.println("1) View account holder information \n" + "2) Approve/deny checking account application\n" + 
	    "3) Approve/deny savings account application\n" + "4) Exit");
		answer = scanner.next().trim();
		
		switch (answer){
		    case "1": System.out.println("\nPlease enter the username of the customer whose information you would like to view:");
		    answer = scanner.nextLine().trim();
		    answer = scanner.nextLine().trim();
		    
		    AccountHolder acctHolder = cDAO.getAccountHolderByUsername(answer);
		    System.out.println("\n" + acctHolder);
				break;
			case "2": employee = acctsServ.checkingApps(employee);
				break;
			case "3": employee = acctsServ.savingsApps(employee);
				break;
			case "4": System.out.println("Now Exiting ...");
				scanner.close();
				return null;
			default: System.out.println("Error: Selection Invalid");
			scanner.close();
				return null;
	}
}

	 return employee;
}

public BankAdmin adminMenu(BankAdmin admin) {

	System.out.println("\nAdministration Hub\n" + "\n" + "Please enter admin ID: ");
	 String answer = scanner.nextLine().trim();
	 
	 //checker for valid employeeID
	 while(!admin.getAdminID().equalsIgnoreCase(answer)) {
		 System.out.println("\nError: Admin ID does not exist. Please try again: ");
		 answer = scanner.nextLine().trim();
	 }
	 
	 System.out.println("\nThank you, " + admin.getAdminID() + ". Enter access code: ");
	 answer = scanner.nextLine().trim();
	 
	 //check for valid password
	 while(!admin.getAccessCode().equals(answer)) {
		 System.out.println("\nError: access code incorrect. Please try again: ");
		 answer = scanner.nextLine().trim();
	 }
	 System.out.println("\nWelcome, " + admin.getFirstName());
	 
	 while(answer.contentEquals(answer)) {
		 System.out.println("\nAdministrator Transaction Menu\n");
		System.out.println("Please choose from the following menu options: ");
		System.out.println("1) View account holder information \n" + "2) Approve/deny checking account application\n" + 
	    "3) Approve/deny savings account application\n" + "4) Open New Customer Account\n" + "5) Update account holder information\n" 
		+ "6) Deposit Into Customer Account\n" + "7) Withdrawal From Customer Account\n" + "8) Customer Account Transfer\n" + "9) Exit");
		answer = scanner.next().trim();
		
		switch (answer){
		    case "1": System.out.println("\nPlease enter the username of the customer whose information you would like to view:");
		    answer = scanner.nextLine().trim();
		    answer = scanner.nextLine().trim();
		    
		    AccountHolder acctHolder = cDAO.getAccountHolderByUsername(answer);
		    System.out.println("\n" + acctHolder);
				break;
			case "2": admin = acctsServ.checkingApps(admin);
				break;
			case "3": admin = acctsServ.savingsApps(admin);
				break;
			case "4": AccountHolder aHolder =  new AccountHolder();
					  openNewAcct(aHolder);
				break;
			case "5": AccountHolder aHolder2 =  new AccountHolder();
					  acctUpdate(aHolder2);
				break;
			case "6": AccountHolder aHolder3 =  new AccountHolder();
			  		  AcctDeposit(aHolder3);
				break;
			case "7": AccountHolder aHolder4 =  new AccountHolder();
	  		  		  AcctWithdrawal(aHolder4);
				break;
			case "8": AccountHolder aHolder5 =  new AccountHolder();
	  		  		  AcctDeposit(aHolder5);
				break;
			case "9": System.out.println("Now Exiting ...");
				scanner.close();
				return admin;
			default: System.out.println("Error: Selection Invalid");
			scanner.close();
				return admin;
	}
	 }
	return admin;
}

public AccountHolder openNewAcct(AccountHolder acctHolder) {
		System.out.println("\nNew Account Hub\n" + "\nAlright, I'll need a bit more information from you first. "
				+ "What type of account would you like to open?");
		
		System.out.println("\n1) Checking Account" + "\n2) Savings Account");
		
		String selection = scanner.next().trim();
		
		switch (selection) {

		case "1": acctHolder = acctsServ.openAcctChecking(acctHolder);
			return acctHolder;
		case "2": acctHolder = acctsServ.openAcctSavings(acctHolder);
			break;
		default: System.out.println("\nError: Selection Invalid. Rerouting ...");
		}
		return acctHolder;
	}
	
public AccountHolder acctUpdate(AccountHolder acctHolder) {
	
	System.out.println("\nUpdate Account\n");
	
	acctHolder = acctsServ.acctUpdater(acctHolder);
	return acctHolder;
}

public AccountHolder AcctStatus(AccountHolder acctHolder) {

		
		System.out.println("\nAccount Status\n");
		
		acctHolder = acctsServ.acctStatus(acctHolder);
			
	return acctHolder;
}
	
public AccountHolder AcctDeposit(AccountHolder acctHolder) {
	
	System.out.println("\nDeposit Hub\n" + "\nAlright, I'll need a bit more information from you first. "
			+ "In which account would you like to make your deposit?");
	
	System.out.println("\n1) Checking Account" + "\n2) Savings Account");
	
	String selection = scanner.next().trim();
	
	switch (selection) {

	case "1": acctHolder = acctsServ.depositChecking(acctHolder);
		break;
	case "2": acctHolder = acctsServ.depositSavings(acctHolder);
		break;
	default:  System.out.println("\nError: Selection Invalid. Rerouting ...");
	}
	
	return acctHolder;
}

public AccountHolder AcctWithdrawal(AccountHolder acctHolder) {
	
	System.out.println("\nWithdrawal Hub\n" + "\nAlright, I'll need a bit more information from you first. "
			+ "From which account would you like to make your withdrawal?");
	
	System.out.println("\n1) Checking Account" + "\n2) Savings Account");
	
	String selection = scanner.next().trim();
	
	switch (selection) {

	case "1": acctHolder = acctsServ.withdrawalChecking(acctHolder);
		break;
	case "2": acctHolder = acctsServ.withdrawalSavings(acctHolder);
		break;
	default:  System.out.println("\nError: Selection Invalid. Rerouting ...");
	}
return acctHolder;
}

public AccountHolder AcctTransfer(AccountHolder acctHolder) {
	
	System.out.println("\nAccount Status\n" + "\nAlright, I'll need a bit more information from you first. "
			+ "From which account would you like to transfer funds?");
	
	System.out.println("\n1) Checking Account" + "\n2) Savings Account");
	
	String selection = scanner.next().trim();
	
	switch (selection) {

	case "1": acctHolder = acctsServ.tChecking(acctHolder);
		break;
	case "2": acctHolder = acctsServ.tSavings(acctHolder);
		break;
	default:  System.out.println("\nError: Selection Invalid. Rerouting ...");
	}
return acctHolder;
}

}
