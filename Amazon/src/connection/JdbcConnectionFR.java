package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 

public class JdbcConnectionFR{
 
    private final static String url = "jdbc:postgresql://postgresql-ghb.alwaysdata.net/ghb_project";
    private final static String user = "ghb";
    private final static String password = "ghb123?";
    private static Connection connection;
    
    
    
    public static Connection getConnection() {		
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
        return conn;
    }
 
   
   
}