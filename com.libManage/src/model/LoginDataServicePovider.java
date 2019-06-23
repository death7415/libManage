package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dbConnector.DbConnector;

public class LoginDataServicePovider {

	public static String checkUser(String user,String password) {
		String status="";
		String query="select * from register_data where u_name='"+user+"'";
		String pass_check="";
		try {
			
			Connection connection=DbConnector.getConnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(query);
			
			while (resultSet.next()) {
				pass_check=resultSet.getString("pass");
			}
			if(password.equals(pass_check)) {
				status="pass";
			}else {
				status="fail";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			status="connection_fail";
		}
		
		return status;
	}
	
	
}
