package com.revature.daos;

import com.revature.models.AccountHolder;

import java.util.*;

public interface CustomerDAO {

	public AccountHolder getAccountHolderByUsername(String username); 
	
	public List<AccountHolder> getAllAccountHolders();

	public abstract void insertCustomer(AccountHolder acctHolder);
	
}
