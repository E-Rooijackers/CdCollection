import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetData {
	public static Connection conn = DBConnect.connect();
	
	public static List<Album> getAlbums() {
		List<Album> albums = new ArrayList<Album>();
		try {
				conn = DBConnect.connect();
				String query = "SELECT * FROM albums";
				PreparedStatement stmt=conn.prepareStatement(query);  
				ResultSet rs=stmt.executeQuery();  
				
				while(rs.next()){  
					Album album = new Album();
					album.name = rs.getString("name");
					album.artist= rs.getString("artist");
					album.genre= rs.getString("genre");
					album.year= rs.getInt("year");
					albums.add(album);
				} 
	    		conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return albums;
	}
	
	public static void TransferData(Album album) {

		try {	
			conn = DBConnect.connect();
			String query = "INSERT INTO albums (name, artist, genre, year) VALUES (?,?,?,?)";
			PreparedStatement stmt=conn.prepareStatement(query); 
			stmt.setString(1, album.name);
			stmt.setString(2, album.artist);
			stmt.setString(3, album.genre);
			stmt.setInt(4, album.year);
			stmt.executeUpdate();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Genre> getGenre() {
		List<Genre> genres = new ArrayList<Genre>();
		try {
			conn = DBConnect.connect();
			String query = "SELECT * FROM genres";
			PreparedStatement stmt=conn.prepareStatement(query);  
			ResultSet rs=stmt.executeQuery();  
			while(rs.next()){  
				Genre genre = new Genre();
				genre.genre_id = rs.getInt("genre_id");
				genre.genre= rs.getString("genre");
				genres.add(genre);
			} 
	    	conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return genres;
	}
	
	public static int getGenreID(String genretext) {
		int id = 1;
		try {
			conn = DBConnect.connect();
			String query = "SELECT genre_id FROM genres WHERE genre == (?)";
			PreparedStatement stmt=conn.prepareStatement(query);  
			stmt.setString(1, genretext);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				id = result.getInt("genre_id");
			}
	    	conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	
	
	

}
