package com.revature.service;

import com.revature.models.AccountHolder;
import com.revature.repository.AccountHolderRepo;


public class AccountHolderService {
	
	private AccountHolderRepo accountRepo = new AccountHolderRepo();
	
	public void newAccountHolder(AccountHolder accountHolder) {
		
		//Business logic to change name to lower case for storage in database. 
		accountHolder.setName(accountHolder.getName().toLowerCase());
		
		//save into "database"
		accountRepo.storeAccountHolder(accountHolder);
	}

}
