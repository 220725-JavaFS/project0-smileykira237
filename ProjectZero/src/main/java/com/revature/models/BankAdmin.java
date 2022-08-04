package com.revature.models;

import java.util.Objects;

//CAN VIEW AND EDIT ALL ACCOUNTS
public class BankAdmin {
	
	private String name;
	private int adminID;
	
	public BankAdmin(String name, int adminID) {
		super();
		this.name = name;
		this.adminID = adminID;
	}

	public BankAdmin() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adminID, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAdmin other = (BankAdmin) obj;
		return adminID == other.adminID && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "BankAdmin [name=" + name + ", adminID=" + adminID + "]";
	}

}
