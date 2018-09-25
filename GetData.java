import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetData {
	public static String SearchItem =  Search.searchItem();
	
	public static List<Album> getAlbums() {
		List<Album> albums = new ArrayList<Album>();
		try {
				Connection conn = DBConnect.connect();
				String query = "SELECT * FROM albums";
				PreparedStatement stmt=conn.prepareStatement(query);  
				ResultSet rs=stmt.executeQuery();  
				
				while(rs.next()){  
					Album album = new Album();
					album.name = rs.getString("name");
					album.artist= rs.getString("artist");
					album.artist= rs.getString("genre");
					album.artist= rs.getString("year");
					albums.add(album);
				} 
	    		conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return albums;
	}
}