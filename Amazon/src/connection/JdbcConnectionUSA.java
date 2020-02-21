package connection;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnectionUSA {
	private static String host = "mysql-amazon.alwaysdata.net";
	private static String base = "amazon_usa";
	private static String port = "3306";
	private static String user = "amazon";
	private static String password = "amazonTFC95";
	private static String url = "jdbc:mysql://" + host + ":" + port + "/" + base + "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";

	/**
	 * Singleton instance.
	 */
	private static Connection connection;

	public static Connection getConnection() {		
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, user, password);
				System.out.println("Connection Mysql Reussi !");
			} catch (Exception e) {
				System.err.println("Connection failed : " + e.getMessage());			
			}
		}
		return connection;
	}
}
