package com.revature.models;

import java.util.Objects;

// CAN **VIEW** ALL CUSTOMER INFORMATION AND APPROVE OR DENY OPEN APPLICATIONS FOR NEW ACCOUNTS
public class BankEmployee {
	
	private String employeeID = "jonnyd44";
	private String firstName = "John";
	private String lastName = "Doe";
	private String accessCode = "employee1";
	
	public BankEmployee(String employeeID, String firstName, String lastName, String accessCode) {
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accessCode = accessCode;
	}

	public BankEmployee(String firstName, String lastName, String accessCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accessCode = accessCode;
	}

	public BankEmployee() {
		super();
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
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
		return Objects.hash(accessCode, employeeID, firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankEmployee other = (BankEmployee) obj;
		return Objects.equals(accessCode, other.accessCode) && employeeID == other.employeeID
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return "BankEmployee [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", accessCode=" + accessCode + "]";
	}

}
