package com.revature.models;

import java.util.Objects;

//CAN VIEW AND EDIT ALL ACCOUNTS
public class BankAdmin {
	
	private int adminID;
	private String firstName;
	private String lastName;
	private String accessCode;
	
	public BankAdmin(int adminID, String firstName, String lastName, String accessCode) {
		super();
		this.adminID = adminID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accessCode = accessCode;
	}

	public BankAdmin(String firstName, String lastName, String accessCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accessCode = accessCode;
	}

	public BankAdmin() {
		super();
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accessCode, adminID, firstName, lastName);
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
		return Objects.equals(accessCode, other.accessCode) && adminID == other.adminID
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return "BankAdmin [adminID=" + adminID + ", firstName=" + firstName + ", lastName=" + lastName + ", accessCode="
				+ accessCode + "]";
	}
	
}
