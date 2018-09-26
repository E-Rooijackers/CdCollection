import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class GraphicalUserInterface {
	
	public void show()
	{
		JFrame frame = new JFrame();
		frame.setSize(1400, 700);
		
		JPanel panel1 = new JPanel(); 
		panel1.setName("Database");
			
		
		JTable table = getAlbumTable();
		
		// Set table sorter
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
		sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
		
		panel1.add(table);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.createHorizontalScrollBar();
		JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scroll,BorderLayout.CENTER);
        panel.setBounds(50, 250, 1400, 500);
		panel1.add(panel);
		
		JPanel panel2 = new JPanel();
		panel2.setName("Insert album");
		JLabel lbName = new JLabel("Name");
		JTextField tfName = new JTextField();
		lbName.setBounds(50,50,100, 20);
		tfName.setBounds(150,50,300,20);
		
		JLabel lbArtist = new JLabel("Artist");
		JTextField tfArtist = new JTextField();
		lbArtist.setBounds(50,150,100, 20);
		tfArtist.setBounds(150,150,300,20);
		
		JLabel lbGenre = new JLabel("Genre");
		JTextField tfGenre = new JTextField();
		lbGenre.setBounds(50,250,100, 20);
		tfGenre.setBounds(150,250,300,20);
		
		JLabel lbYear = new JLabel("Year");
		JTextField tfYear = new JTextField();
		lbYear.setBounds(50, 350,100, 20);
		tfYear.setBounds(150, 350,300,20);
		
		JButton btnInsert = new JButton("Insert album");
		btnInsert.setBounds(50, 450,400, 20);
		
		panel2.add(lbName);
		panel2.add(tfName);
		
		panel2.add(lbArtist);
		panel2.add(tfArtist);
		
		panel2.add(lbGenre);
		panel2.add(tfGenre);
		
		panel2.add(lbYear);
		panel2.add(tfYear);
		
		panel2.add(btnInsert);
		
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(
					ActionEvent arg0
			)
			{
				Album album = new Album();
				album.name = tfName.getText();
				album.artist = tfArtist.getText();
				album.genre = tfGenre.getText();
				album.year = Integer.parseInt(tfYear.getText());
				
				
			}
		});
		
		panel2.setLayout(null);
		
		JTabbedPane tabs = new JTabbedPane();
		tabs.add(panel1);
		tabs.add(panel2);
		
		frame.add(tabs);
		frame.setVisible(true);
	}
	
	public JTable getAlbumTable()
	{
		List<Album> albums = GetData.getAlbums();
		String[] columns = {"ID", "Name", "Artist", "Genre", "Year" };	
		String[][] data = new String[albums.size()][5];
		
		List<String[]> lRows = new ArrayList<String[]>();
		for(Album album : albums)
		{
			String[] aRow = {String.valueOf(album.id), album.name, album.artist, album.genre, String.valueOf(album.year)};
			lRows.add(aRow);
		}
		
		data = lRows.toArray(data);
		JTable table = new JTable(data, columns); 
		table.setSize(table.getMaximumSize());
		return table; 
	}
}
