import java.sql.*;

public class DBConnect{   		
	public static Connection connect()
	{			
		String url = "jdbc:mysql://localhost:3306/cdcollection";		
		String username = "root";			
		String password = "";					
		System.out.println("Connecting database...");			
						
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}			
		System.out.println("Database connected!");			
		return conn;			

	}	
}
