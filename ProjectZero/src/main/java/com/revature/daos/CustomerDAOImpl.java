package com.revature.daos;

import java.sql.*;

import com.revature.models.AccountHolder;
import com.revature.utilities.ConnectionUtility;

import java.util.*;

public class CustomerDAOImpl implements CustomerDAO{
	
	@Override
	public AccountHolder getAccountHolderByUsername(String username) {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "select * from customers where username = " + username + ";";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {//resultSets have cursors. .next(); is called to move cursor to next group of values
				AccountHolder acctHolder = new AccountHolder(result.getString("username"), result.getString("user_password"), 
		result.getString("first_name"), result.getString("last_name"), result.getString("email"), result.getLong("phone_number"),
	    result.getString("str_number"), result.getString("str_name"), result.getString("city"), result.getString("state"), result.getInt("zip"), 
	    result.getBoolean("checking_account"), result.getBoolean("savings_account"));
			return acctHolder;
			}
			
		} catch (SQLException e) {
			System.out.println("There was an SQL exception");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AccountHolder> getAllAccountHolders() {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM customers;";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			List<AccountHolder> customerList = new ArrayList<AccountHolder>();
			
			while(result.next()) { //resultSets are cursor based, each time .next is called the cursor moves to the next group of values. 
				//It starts one before so you always need to call next.
				AccountHolder acctHolder = new AccountHolder(
						result.getString("username"),
						result.getString("user_password"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getString("email"),
						result.getLong("phone_number"),
						result.getString("str_number"),
						result.getString("str_name"),
						result.getString("city"),
						result.getString("state"),
						result.getInt("zip"),
						result.getBoolean("checking_account"),
						result.getBoolean("savings_account")
						);
				
				customerList.add(acctHolder);
			}
			
			return customerList;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertCustomer(AccountHolder acctHolder) {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "INSERT INTO customers (username, user_password, first_name, last_name, email, phone_number, str_number, "
					+ "str_name, city, state, zip, checking_account, savings_account)" + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 1;
			statement.setString(count++, acctHolder.getUserName());
			statement.setString(count++, acctHolder.getUserPassword());
			statement.setString(count++, acctHolder.getFirstName());
			statement.setString(count++, acctHolder.getLastName());
			statement.setString(count++, acctHolder.getEmail());
			statement.setLong(count++, acctHolder.getPhoneNumber());
			statement.setString(count++, acctHolder.getStrNumber());
			statement.setString(count++, acctHolder.getStrName());
			statement.setString(count++, acctHolder.getCity());
			statement.setString(count++, acctHolder.getState());
			statement.setInt(count++, acctHolder.getZip());
			statement.setBoolean(count++, acctHolder.isCheckingAccount());
			statement.setBoolean(count++, acctHolder.isSavingsAccount());

			statement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}
}
