package com.revature.controller;

import java.util.*;

public class MenuController {
	
	RegistrationController rCont = new RegistrationController();
	
	SignInController sCont = new SignInController();
	
	//Display menu options to user
	public void menu() {
		System.out.println("Please choose from the following menu options: ");
		System.out.println("1) Register\n" + "2) Sign in\n"); 
		
		Scanner scanner = new Scanner(System.in);
		int selection = scanner.nextInt();
		
		switch (selection){
		
			case 1: rCont.register();
				break;
			case 2: sCont.signIn();
				break;
			default: System.out.println("Error: Selection Invalid!");
				break;
		}
	}
	
}