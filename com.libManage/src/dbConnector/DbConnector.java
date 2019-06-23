package dbConnector;

import java.sql.Connection;
import java.sql.DriverManager;
						/*               SINGLETON CLASS PATTERN USED                  */
						////////////////////////////////////////////////////////////////

public class DbConnector {
static	String user="root";
static	String password="shyam";
static	String url="jdbc:mysql://localhost:5555/lib";
static 	Connection connection=null;


static {
		try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			 connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
}
	
	private DbConnector() {}

	
public static Connection getConnection()  ///CALL THIS METHOD FOR ESTABLISHING THE CONNECTION WITH MYSQL 5.5 SERVER 
{
	return connection;
	}	
	
}
