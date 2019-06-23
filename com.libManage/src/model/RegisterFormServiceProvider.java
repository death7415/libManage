package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dbConnector.DbConnector;

public class RegisterFormServiceProvider {
	
	
	
	
	public static String checkData(String email,String p_num) {
		String check="";
		
		Connection connection=DbConnector.getConnection();
		try {
			String email_check="";
			String phone="";
			
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select email,p_num from register_data");
			
			while(resultSet.next()) {
				email_check=resultSet.getString("email");
				phone=resultSet.getString("p_num");
				
			}
			
			if(email.equals(email_check)) {
				check="email";
			}
			else {
				
				if (p_num.equals(phone)) {
					check="phone";
				}else {
					check="clear";
				}
				
			}
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		
		return check;
	}
	
	
	public void  insertRegisterData(String uname,String email,String pass,String p_num,String fm_name,String random) {
		String uid="";
		Connection connection=DbConnector.getConnection();
		try {
			Statement statement=connection.createStatement();
					
			statement.executeUpdate("insert into register_data(u_name,email,pass,p_num,fm_name,random_id) values('"+uname+"','"+email+"','"+pass+"',"
						+ "'"+p_num+"','"+fm_name+"','"+random+"')");
			
			}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			uid="error";
		}
		
		
	}
	
}
