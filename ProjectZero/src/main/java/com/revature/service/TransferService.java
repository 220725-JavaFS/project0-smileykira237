package com.revature.service;

import java.util.*;

import com.revature.models.AccountHolder;

public class TransferService {
	
	@SuppressWarnings("unused")
	private Scanner scanner = new Scanner(System.in);
	
	public AccountHolder tChecking(AccountHolder acctHolder) {
		System.out.println(acctHolder.getcAcctBalance());
		return acctHolder;
	}
	
public AccountHolder tSavings(AccountHolder acctHolder) {
	System.out.println(acctHolder.getcAcctBalance());
		return acctHolder;
	}

}
