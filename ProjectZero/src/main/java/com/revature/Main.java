package com.revature;

import com.revature.controller.RegistrationController;

public class Main {

	public static void main(String[] args) {
	
		System.out.println("Hello! Welcome to the online banking system.");
		
		RegistrationController rCont = new RegistrationController();
		
		rCont.register();

	}

}
