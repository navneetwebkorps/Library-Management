package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

import MyLog.MyLogger;

public class DbConnector {
	static Connection con;
	public static Connection getConnection()
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/Lmgmt";
		String user="root";
		String pass="root";
		 con=DriverManager.getConnection(url, user, pass);
		 System.out.println("db success");
		}
		catch (Exception e) {
			MyLogger.logInfo("Error in Database"+e);
		}
		return con;
	}


}
