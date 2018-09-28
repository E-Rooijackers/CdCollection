import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class GetData {
	public static GraphicalUserInterface gui;
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
					album.genre= rs.getString("genre");
					album.year= rs.getInt("year");
					albums.add(album);
				} 
	    		conn.close();
		}catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(gui.frame, e.toString(),"SQL Exception", JOptionPane.WARNING_MESSAGE);
			gui.frame.setVisible(true);
			System.exit(1);
		}
		return albums;
	}
	
	public static boolean TransferData(Album album) {

		try {	
			Connection conn = DBConnect.connect();
			String query = "INSERT INTO albums (name, artist, genre, year) VALUES (?,?,?,?)";
			PreparedStatement stmt=conn.prepareStatement(query); 
			stmt.setString(1, album.name);
			stmt.setString(2, album.artist);
			stmt.setString(3, album.genre);
			stmt.setInt(4, album.year);
			stmt.executeUpdate();
			conn.close();
			return true;
		} 
		catch(SQLException e) 
		{
			JOptionPane.showMessageDialog(gui.frame, e.toString(),"SQL Exception", JOptionPane.WARNING_MESSAGE);
			gui.frame.setVisible(true);
			System.exit(1);
			return false;
        }
	}
	
	public static List<Genre> getGenres() {
		List<Genre> genres = new ArrayList<Genre>();
		try {
			Connection conn = DBConnect.connect();
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
			JOptionPane.showMessageDialog(gui.frame, e.toString(),"SQL Exception", JOptionPane.WARNING_MESSAGE);
			gui.frame.setVisible(true);
			System.exit(1);
		}
		return genres;
	}
	
	public static void setGui(GraphicalUserInterface ui)
	{
		gui = ui;
	}
}
