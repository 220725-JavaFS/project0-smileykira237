package com.revature.models;

import java.util.*;

public class AccountHolder {
	
	private String userName;
	private String userPassword;
	private String firstName;
	private String lastName;
	private String email;
	private long phoneNumber;
	private String strNumber;
	private String strName;
	private String city;
	private String state;
	private int zip;
	private boolean active;
	private double cAcctBalance = 5.00;
	private double sAcctBalance = 5.00;

	public AccountHolder(String userName, String userPassword, String firstName, String lastName, String email,
			long phoneNumber, String strNumber, String strName, String city, String state, int zip, boolean active,
			double cAcctBalance, double sAcctBalance) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.strNumber = strNumber;
		this.strName = strName;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.active = active;
		this.cAcctBalance = cAcctBalance;
		this.sAcctBalance = sAcctBalance;
	}

	public AccountHolder(String userName, String userPassword, String firstName, String lastName, String email,
			long phoneNumber, String strNumber, String strName, String city, String state, int zip, boolean active) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.strNumber = strNumber;
		this.strName = strName;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.active = active;
	}

	public AccountHolder() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStrNumber() {
		return strNumber;
	}

	public void setStrNumber(String strNumber) {
		this.strNumber = strNumber;
	}

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
		return Objects.hash(active, cAcctBalance, city, email, firstName, lastName, phoneNumber, sAcctBalance, state,
				strName, strNumber, userName, userPassword, zip);
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
		return active == other.active
				&& Double.doubleToLongBits(cAcctBalance) == Double.doubleToLongBits(other.cAcctBalance)
				&& Objects.equals(city, other.city) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& phoneNumber == other.phoneNumber
				&& Double.doubleToLongBits(sAcctBalance) == Double.doubleToLongBits(other.sAcctBalance)
				&& Objects.equals(state, other.state) && Objects.equals(strName, other.strName)
				&& Objects.equals(strNumber, other.strNumber) && Objects.equals(userName, other.userName)
				&& Objects.equals(userPassword, other.userPassword) && zip == other.zip;
	}

	@Override
	public String toString() {
		return "AccountHolder [userName=" + userName + ", userPassword=" + userPassword + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", strNumber="
				+ strNumber + ", strName=" + strName + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ ", active=" + active + ", cAcctBalance=" + cAcctBalance + ", sAcctBalance=" + sAcctBalance + "]";
	}

}
