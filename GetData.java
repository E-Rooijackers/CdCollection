import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class GetData {
	public static Connection conn = DBConnect.connect();
	public static GraphicalUserInterface gui;
	public static List<Album> getAlbums() {
		List<Album> albums = new ArrayList<Album>();
		try {
				conn = DBConnect.connect();
				String query = "SELECT * FROM albums ta LEFT JOIN genres tb on ta.genre = tb.genre_id";
				PreparedStatement stmt=conn.prepareStatement(query);  
				ResultSet rs=stmt.executeQuery();  
				
				while(rs.next()){  
					Album album = new Album();
					album.id = rs.getInt("id");
					album.name = rs.getString("name");
					album.artist= rs.getString("artist");
					album.genre= rs.getInt("genre");
					album.genre_name= rs.getString("genre_name");
					album.year= rs.getInt("year");
					albums.add(album);
				} 
	    		conn.close();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(gui.frame, e.toString(),"SQL Exception", JOptionPane.WARNING_MESSAGE);
			gui.frame.setVisible(true);
			System.exit(1);
		}
		return albums;
	}
	
	public static boolean TransferData(Album album) {
		try {	
			conn = DBConnect.connect();
			String query = "INSERT INTO albums (name, artist, genre, year) VALUES (?,?,?,?)";
			PreparedStatement stmt=conn.prepareStatement(query); 
			stmt.setString(1, album.name);
			stmt.setString(2, album.artist);
			stmt.setInt(3, album.genre);
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
			conn = DBConnect.connect();
			String query = "SELECT * FROM genres";
			PreparedStatement stmt=conn.prepareStatement(query);  
			ResultSet rs=stmt.executeQuery();  
			while(rs.next()){  
				Genre genre = new Genre();
				genre.genre_id = rs.getInt("genre_id");
				genre.genre= rs.getString("genre_name");
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

	public static int getGenreID(String genretext) {
		int id = 1;
		try {
			conn = DBConnect.connect();
			String query = "SELECT genre_id FROM genres WHERE genre_name = ?";
			PreparedStatement stmt=conn.prepareStatement(query);  
			stmt.setString(1, genretext);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				id = result.getInt("genre_id");
			}
	    	conn.close();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(gui.frame, e.toString(),"SQL Exception", JOptionPane.WARNING_MESSAGE);
			gui.frame.setVisible(true);
			System.exit(1);
		}
		return id;
	}
	
	public static boolean deleteGenre(int genre_id) {
		int genre = genre_id;
		boolean del = false;
		try {
			conn = DBConnect.connect();
			String query = "SELECT name FROM albums WHERE genre = ?";
			PreparedStatement stmt=conn.prepareStatement(query);  
			stmt.setInt(1, genre);
			ResultSet rs = stmt.executeQuery();
			if(rs != null) {
				String deletequery = "DELETE FROM genres WHERE  genres.genre_id = ?";
				PreparedStatement stmt2=conn.prepareStatement(deletequery);  
				stmt2.setInt(1, genre);
				stmt2.executeUpdate();
				del = true;
				conn.close();
				return del;
			}else {
				del = false;
				conn.close();
				return del;
			}
			
		}catch(SQLException e){
			JOptionPane.showMessageDialog(gui.frame, e.toString(),"SQL Exception", JOptionPane.WARNING_MESSAGE);
			gui.frame.setVisible(true);
			System.exit(1);
			return del;
		}
			
		}
		
	public static void addGenre(String genre_name) {
		try {	
			conn = DBConnect.connect();
			String query = "INSERT INTO genres (genre_name) VALUES (?)";
			PreparedStatement stmt=conn.prepareStatement(query); 
			stmt.setString(1, genre_name);
			stmt.executeUpdate();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
		
		
	
	public static void setGui(GraphicalUserInterface ui)
	{
		gui = ui;
	}
}
