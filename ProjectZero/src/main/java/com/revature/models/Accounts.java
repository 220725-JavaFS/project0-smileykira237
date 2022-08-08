package com.revature.models;

import java.util.Objects;

public class Accounts {
	
	private boolean active;
	private boolean checkingAccount;
	private boolean savingsAccount;
	
	public Accounts(boolean active, boolean checkingAccount, boolean savingsAccount) {
		super();
		this.active = active;
		this.checkingAccount = checkingAccount;
		this.savingsAccount = savingsAccount;
	}

	public Accounts() {
		super();
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isCheckingAccount() {
		return checkingAccount;
	}

	public void setCheckingAccount(boolean checkingAccount) {
		this.checkingAccount = checkingAccount;
	}

	public boolean isSavingsAccount() {
		return savingsAccount;
	}

	public void setSavingsAccount(boolean savingsAccount) {
		this.savingsAccount = savingsAccount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(active, checkingAccount, savingsAccount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accounts other = (Accounts) obj;
		return active == other.active && checkingAccount == other.checkingAccount
				&& savingsAccount == other.savingsAccount;
	}

	@Override
	public String toString() {
		return "Accounts [active=" + active + ", checkingAccount=" + checkingAccount + ", savingsAccount="
				+ savingsAccount + "]";
	}
}
