package com.revature.models;

import java.util.*;

public class AccountHolder {
	
	private String name;
	private String userName;
	private String password;
	private double cAcctBalance = 5.00;
	private double sAcctBalance = 5.00;

	public AccountHolder(String name, String userName, String password, double cAcctBalance, double sAcctBalance) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.cAcctBalance = cAcctBalance;
		this.sAcctBalance = sAcctBalance;
	}

	public AccountHolder() {
		super();
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
	

	public double getcAcctBalance() {
		return cAcctBalance;
	}


	public void setcAcctBalance(double cAcctBalance) {
		this.cAcctBalance = cAcctBalance;
	}


	public double getsAcctBalance() {
		return sAcctBalance;
	}


	public void setsAcctBalance(double sAcctBalance) {
		this.sAcctBalance = sAcctBalance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cAcctBalance, name, password, sAcctBalance, userName);
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
		return Double.doubleToLongBits(cAcctBalance) == Double.doubleToLongBits(other.cAcctBalance)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Double.doubleToLongBits(sAcctBalance) == Double.doubleToLongBits(other.sAcctBalance)
				&& Objects.equals(userName, other.userName);
	}


	@Override
	public String toString() {
		return "AccountHolder [name=" + name + ", userName=" + userName + ", password=" + password + ", cAcctBalance="
				+ cAcctBalance + ", sAcctBalance=" + sAcctBalance + "]";
	}

}
