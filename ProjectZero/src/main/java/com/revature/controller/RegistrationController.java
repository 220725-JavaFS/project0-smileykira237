package com.revature.controller;

import java.util.*;

public class RegistrationController {

	Scanner scanner = new Scanner(System.in);
	
	public void register() {
		
		System.out.println("In order for you to register for a new account, I need some information first. ");
		System.out.print("What is your name?");
		
		String name = scanner.nextLine();
		
		System.out.println("Thank you, " + name + ". Now, you will need to create a username for your new account.");
		System.out.println("Please enter your new username here: ");
		
		String userName = scanner.nextLine();
		
		System.out.println("Great! Last step, you will need to create a password");
		System.out.println("Please enter your new password here: ");
		
		String password = scanner.nextLine();
		
		System.out.println("Thank you " + name + ", your account set-up is complete.");
		System.out.println("Your account details are as follows: ");
		System.out.println("UserName: " + userName);
		System.out.println("Password: " + password);
		System.out.println("Please keep this information somewhere safe.");
		
	}
}
