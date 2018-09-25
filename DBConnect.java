import java.sql.*;

public class DBConnect{   		
	public static Connection connect(){			
		String url = "jdbc:mysql://localhost:3306/cdcollection";		
		String username = "root";			
		String password = "";					
		System.out.println("Connecting database...");			
		try { 							
			Connection conn = DriverManager.getConnection(url, username, password);			
			System.out.println("Database connected!");			
			return conn;			
		} catch (SQLException e) {			
			throw new IllegalStateException("Cannot connect the database!", e);			
		}	
	}	
}
