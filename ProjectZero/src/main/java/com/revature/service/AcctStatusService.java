package com.revature.service;

import java.util.*;

import com.revature.models.AccountHolder;

public class AcctStatusService {
	
	@SuppressWarnings("unused")
	private Scanner scanner = new Scanner(System.in);
	
	public AccountHolder statChecking(AccountHolder acctHolder) {
		System.out.println("\nChecking Account Balance: $" + acctHolder.getcAcctBalance() + "0");
		
		return acctHolder;
	}
	
public AccountHolder statSavings(AccountHolder acctHolder) {
	System.out.println("\nSavings Account Balance: $" + acctHolder.getsAcctBalance() + "0");
	
		return acctHolder;
	}	



}
