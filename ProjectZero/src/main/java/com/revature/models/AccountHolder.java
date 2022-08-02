package com.revature.models;

import java.util.*;

public class AccountHolder {
	
	private String name;
	private String userName;
	private String password;
	

	public AccountHolder(String name, String userName, String password) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
	}


	public AccountHolder() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public int hashCode() {
		return Objects.hash(name, password, userName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountHolder other = (AccountHolder) obj;
		return Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(userName, other.userName);
	}


	@Override
	public String toString() {
		return "AccountHolder [name=" + name + ", userName=" + userName + ", password=" + password + "]";
	}
	
	

}
