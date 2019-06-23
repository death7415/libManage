package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dbConnector.DbConnector;

public class PasswordRecoveryServiceProvider {
	
	public static ArrayList<String> getPassword(String type,String data,String fm_name,String uid) {
	
	ArrayList<String> aList= new ArrayList<>();
	String query="select u_name,pass from register_data where "+type+"='"+data+"' and fm_name='"+fm_name+"' and random_id='"+uid+"'";
	String pass="";
	String uname="";
	
	
	
	try {
		Connection connection=DbConnector.getConnection();
		Statement statement=connection.createStatement();
		
		ResultSet resultSet=statement.executeQuery(query);
		
		while (resultSet.next()) {
		pass=	resultSet.getString("pass");
		uname=resultSet.getString("u_name");	
		
		if(uname==null) 
		{}
		else {
				
		if((uname!=null) || (pass!=null)) {
				aList.add(uname);
				aList.add(pass);
			}
		}
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	
	return aList;
}
}
