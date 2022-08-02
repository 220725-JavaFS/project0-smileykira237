package com.revature.repository;

import com.revature.models.AccountHolder;

public class AccountHolderRepo {
	
	private static AccountHolder[] accountHolders = new AccountHolder[5];
	
	public void storeAccountHolder(AccountHolder accountHolder) {
		for (int i = 0; i < accountHolders.length; i++) {
			if (accountHolders[i] == null) {
				accountHolders[i] = accountHolder;
				return;
			}
		}
	}
	
	public AccountHolder getAccountHolderByName(String name) {
		for (AccountHolder a : accountHolders) {
			if(a.getName().equals(name.toLowerCase())) {
				return a;
			}
		}
		return null;
		}
	}