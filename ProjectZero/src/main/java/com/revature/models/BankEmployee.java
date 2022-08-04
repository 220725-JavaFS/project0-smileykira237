package com.revature.models;

import java.util.Objects;

// CAN **VIEW** ALL CUSTOMER INFORMATION AND APPROVE OR DENY OPEN APPLICATIONS FOR NEW ACCOUNTS
public class BankEmployee {
	
	private String name;
	private int employeeID;
	
	public BankEmployee(String name, int employeeID) {
		super();
		this.name = name;
		this.employeeID = employeeID;
	}

	public BankEmployee() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeID, name);
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
		return employeeID == other.employeeID && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "BankEmployee [name=" + name + ", employeeID=" + employeeID + "]";
	}

}
