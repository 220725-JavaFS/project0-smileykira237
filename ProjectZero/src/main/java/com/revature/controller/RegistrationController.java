package com.revature.controller;

import java.util.*;

import com.revature.models.AccountHolder;
import com.revature.service.AccountHolderService;

public class RegistrationController {

	private Scanner scanner = new Scanner(System.in);
	private AccountHolderService accountServ = new AccountHolderService();
	private SignInController rsCont = new SignInController();
	
	//Registers new user for a bank account
	public void register() {
		
		System.out.println("Registration Hub\n" + "\n" + "In order for you to register for a new account, I need some information first. ");
		System.out.println("What is your name?");
		
		String name = scanner.nextLine().trim();
		
		System.out.println("\n");
		System.out.println("Thank you, " + name + ". Now, you will need to create a username for your new account.");
		System.out.println("Please enter your new username here: ");
		
		String userName = scanner.nextLine().trim();
		
		System.out.println("\n");
		System.out.println("Great! Last step, you will need to create a password");
		System.out.println("Please enter your new password here: ");
		
		String password = scanner.nextLine().trim();
		
		System.out.println("\n");
		System.out.println("Thank you " + name + ", your account set-up is complete.");
		System.out.println("Your account details are as follows: ");
		System.out.println("UserName: " + userName);
		System.out.println("Password: " + password);
		System.out.println("Please keep this information somewhere safe.\n");
		
		rsCont.signIn();
	}
	
	
}
