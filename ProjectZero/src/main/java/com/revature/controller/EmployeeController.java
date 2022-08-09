package com.revature.controller;

import java.util.Scanner;

import com.revature.daos.CustomerDAO;
import com.revature.daos.CustomerDAOImpl;
import com.revature.models.AccountHolder;
import com.revature.models.BankEmployee;

public class EmployeeController {

	private CustomerDAO cDAO = new CustomerDAOImpl();
	private Scanner scanner = new Scanner(System.in);
	private BankEmployee John = new BankEmployee();
	
	public void employeeMenu() {
		 System.out.println("\nThank you, " + John.getEmployeeID() + ". Enter access code: ");
		 String selection = scanner.next().trim();
		 
		 while(!John.getAccessCode().equals(selection)) {
			 String print = "Error: Access code incorrect. Please try again:";
			 System.out.println(print);
			 selection = scanner.nextLine().trim();
		 }
		 
		 System.out.println("\nWelcome, " + John.getFirstName());
		 
		 while(selection.contentEquals(selection)) {
		 System.out.println("\nEmployee Transaction Menu\n");
		System.out.println("Please choose from the following menu options: ");
		System.out.println("1) View account holder information \n" + "2) Approve/deny checking account application\n" + 
	    "3) Approve/deny checking account application\n" + "4) Exit");
		selection = scanner.next().trim();
		
		switch (selection){
		    case "1": System.out.println("\nPlease enter the username of the customer whose information you would like to view:");
		    selection = scanner.nextLine().trim();
		    selection = scanner.nextLine().trim();
		    
		    AccountHolder acctHolder = cDAO.getAccountHolderByUsername(selection);
		    System.out.println("\n" + acctHolder);
				break;
			case "2": 
				break;
			case "3": 
				break;
			case "4": System.out.println("Now Exiting ...");
				scanner.close();
				return;
			default: System.out.println("Error: Selection Invalid");
			scanner.close();
				return;
	}
}
	}
}
