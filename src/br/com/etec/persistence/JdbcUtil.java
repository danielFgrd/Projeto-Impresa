package br.com.etec.persistence;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

	

public class JdbcUtil {
	
	private static String connectionDriverClass = "com.mysql.jdbc.Driver";
	
	private static String connectionUrl ="jdbc:mysql://localhost:3306/dbImpresa";
	
	private static String connectionUserName = "root";
		
	private static String connectionPassword = "";
	
	private static Connection connection;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if(JdbcUtil.connection != null) {
			return JdbcUtil.connection;
		}
		else {
			Class.forName(connectionDriverClass);
			return DriverManager.getConnection(connectionUrl, connectionUserName, connectionPassword);
		}
	}
	
	
}
