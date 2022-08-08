package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.AccountHolder;
import com.revature.utilities.ConnectionUtility;

public class AccountHolderDAOImpl implements AccountHolderDAO{
	
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
	    result.getBoolean("active"));
			return acctHolder;
			}
			
		} catch (SQLException e) {
			System.out.println("There was an SQL exception");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		AccountHolderDAO aDao = new AccountHolderDAOImpl();
		
		AccountHolder a = aDao.getAccountHolderByUsername("'tester'");
		System.out.println(a);
	}
}
