import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;

public class GraphicalUserInterface {
	
	public JFrame frame;
	private JTextField tfName;
	private JTextField tfArtist;
	private JComboBox<String> cbGenre;
	private DatePicker dpYear;
	private JTabbedPane tabs;
	private JPanel panel1;
	private JPanel panel3;
	private JTable genreTable;
	private JButton btnRemoveGenre;
	private JButton btnAddGenre;
	private int new_album = 0;
	
	public void show()
	{
		frame = new JFrame();
		frame.setSize(1400, 700);
		
		frame.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent e) {
		          System.exit(0);
		        }
		      });
		
		panel1 = new JPanel(); 
		panel1.setName("Albums");
		
		GetData.setGui(this);
			
		panel3 = new JPanel();
		panel3.setName("Genres");
		panel3.add(getGenreTablePanel());
		
		
		panel1.add(getAlbumTablePanel());
		
		JPanel panel2 = new JPanel();
		panel2.setName("Insert album");
		JLabel lbName = new JLabel("Name");
		tfName = new JTextField();
		lbName.setBounds(50,50,100, 20);
		tfName.setBounds(150,50,300,20);
		
		JLabel lbArtist = new JLabel("Artist");
		tfArtist = new JTextField();
		lbArtist.setBounds(50,150,100, 20);
		tfArtist.setBounds(150,150,300,20);
		
		JLabel lbGenre = new JLabel("Genre");
		lbGenre.setBounds(50,250,100, 20);
		
		cbGenre = new JComboBox<String>(getGenreArray());
		cbGenre.setBounds(150,250,300,20);
		
		JLabel lbYear = new JLabel("Year");
		dpYear = new DatePicker();
		lbYear.setBounds(50, 350,100, 20);
		dpYear.setBounds(150, 350,300,20);
		
		// TODO: Set date picker to show years only
		DatePickerSettings dpSet = new DatePickerSettings();
		dpSet.setAllowKeyboardEditing(false);
				
		//dpSet.setFormatForDatesCommonEra("yyyy");
		dpSet.setVisiblePreviousMonthButton(false);
		dpSet.setVisibleNextMonthButton(false);
		dpSet.setVisibleYearMenuButton(true);
		dpSet.setVisibleTodayButton(false);
		dpSet.setVisibleClearButton(false);
		dpYear.setSettings(dpSet);
		
		
		// Create DateChangeListeners and add it to date pickers.
		dpYear.addDateChangeListener(new DateChangeListener()
		{  
			@Override
			public void dateChanged(DateChangeEvent e) {
				if(dpYear.getDateStringOrEmptyString() == "")
				{
					return;
				}
				else if(!dateValid())
	    		{
	    			dpYear.clear();
	    		}
			}  
	    }); 
		
		JButton btnInsert = new JButton("Insert album");
		btnInsert.setBounds(50, 450,400, 20);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(500, 450,100, 20);
		
		btnRemoveGenre = new JButton("Delete selected genre");
		btnRemoveGenre.setBounds(600, 450,150, 20);
		
		btnRemoveGenre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(
					ActionEvent arg0
			)
			{
			
				int genre_id = Integer.parseInt(genreTable.getValueAt(genreTable.getSelectedRow(), 0).toString());
				if(GetData.deleteGenre(genre_id))
				{
					JOptionPane.showMessageDialog(frame, "Genre successfully deleted", "Genre deleted", JOptionPane.INFORMATION_MESSAGE);
					refreshGenreTable();
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Could not delete genre. Perhaps you have albums with this genre type?", "Genre not deleted", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btnAddGenre = new JButton("Add new genre");
		btnAddGenre.setBounds(800, 450,150, 20);
		
		btnAddGenre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(
					ActionEvent arg0
			)
			{
				String new_genre = JOptionPane.showInputDialog(frame, "Which genre would you like to add?", "<Genre>");
				GetData.addGenre(new_genre);
				new_album = GetData.getGenreID(new_genre);
				refreshGenreTable();
			}
		});
		
		panel2.add(lbName);
		panel2.add(tfName);
		
		panel2.add(lbArtist);
		panel2.add(tfArtist);
		
		
		panel2.add(lbGenre);
		panel2.add(cbGenre);
		
		
		panel2.add(lbYear);
		panel2.add(dpYear);
		
		panel3.add(btnRemoveGenre);
		panel3.add(btnAddGenre);
		
		panel2.add(btnInsert);
		panel2.add(btnClear);
		
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(
					ActionEvent arg0
			)
			{
				if(!checkkInput())
				{
					return;
				}
				
				Album album = new Album();
				album.name = tfName.getText();
				album.artist = tfArtist.getText();
				album.genre = GetData.getGenreID(cbGenre.getSelectedItem().toString());
				album.year = (dpYear.getDate().getYear());
				new_album = 9;
				
				boolean isInserted = GetData.TransferData(album);
				System.out.println("INSERTED? : " + isInserted);
				System.out.println("Album id : " + new_album);
				if(isInserted)
				{
					tabs.setSelectedIndex(0);
					refreshAlbumTable();
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Album not inserted", "Album not inserted", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(
					ActionEvent arg0
			)
			{
				tfName.setText("");
				tfArtist.setText("");
				cbGenre.setSelectedIndex(0);
				dpYear.setText("");
			}
		});
		
		panel2.setLayout(null);
		
		tabs = new JTabbedPane();
		tabs.add(panel1);
		tabs.add(panel3);
		tabs.add(panel2);

		frame.add(tabs);
		frame.setVisible(true);
		//Parser parser = new Parser();
		//String message = parser.getJSON(GetData.getAlbums()).toString();
		//JOptionPane.showMessageDialog(frame, message, "JSON Test", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public JPanel getAlbumTablePanel()
	{
		List<Album> albums = GetData.getAlbums();
		String[] columns = {"ID", "Name", "Artist", "Genre", "Year" };	
		String[][] data = new String[albums.size()][5];
		
		List<String[]> lRows = new ArrayList<String[]>();
		for(Album album : albums)
		{
			String[] aRow = {String.valueOf(album.id), album.name, album.artist, String.valueOf(album.genre_name), String.valueOf(album.year)};
			lRows.add(aRow);
		}
		
		data = lRows.toArray(data);
		JTable table = new JTable(data, columns); 
		table.setSize(table.getMaximumSize());
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Set table sorter
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		//sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.createHorizontalScrollBar();
		JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scroll,BorderLayout.CENTER);
        panel.setBounds(50, 250, 1400, 500);
        
		return panel; 
	}
	
	public void refreshAlbumTable()
	{
		panel1.removeAll();
		panel1.add(getAlbumTablePanel());
	}
	
	public void refreshGenreTable()
	{
		panel3.removeAll();
		panel3.add(getGenreTablePanel());
		panel3.add(btnRemoveGenre);
		panel3.add(btnAddGenre);
	}
	
	public String[] getGenreArray()
	{
		List<Genre> genreList = GetData.getGenres();
		String[] genres = new String[genreList.size()];
		for(int i = 0; i < genreList.size(); i++)
		{
			genres[i] = (String) genreList.get(i).genre;
		} 
		
		return genres;
	}
	
	public JPanel getGenreTablePanel()
	{
		List<Genre> genres = GetData.getGenres();
		String[] columns = {"ID", "Genre"};	
		String[][] data = new String[genres.size()][2];
		
		List<String[]> lRows = new ArrayList<String[]>();
		for(Genre genre : genres)
		{
			String[] aRow = {String.valueOf(genre.genre_id), genre.genre};
			lRows.add(aRow);
		}
		
		data = lRows.toArray(data);
		JTable table = new JTable(data, columns); 
		table.setSize(table.getMaximumSize());
		
		// Set table sorter
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		//sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		genreTable = table;
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.createHorizontalScrollBar();
		JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scroll,BorderLayout.CENTER);
        panel.setBounds(50, 250, 1400, 500);
				
		return panel; 
	}
	
	public boolean checkkInput()
	{
		boolean inputOke = true;
		String msg = "";
		
		if(tfName.getText().length() == 0 ||tfArtist.getText().length() == 0
		|| dpYear.getText().length() == 0)
		{
			inputOke = false;
			msg = "Not all fields have values.";
		}
				
		if(!inputOke)
		{
			JOptionPane.showMessageDialog(frame, msg, "Input invalid", JOptionPane.WARNING_MESSAGE);
		}
		
		return inputOke;
	}
	
	public boolean dateValid()
	{
		Long localDate = LocalDate.now().toEpochDay();

		if(!(dpYear.getDate().toEpochDay() <= localDate))
		{
			JOptionPane.showMessageDialog(frame, "Please choose a date before today.", "Date invalid", JOptionPane.WARNING_MESSAGE);
			return false;
		}// Must be later than -40150 days ( divided 365 = 110 years. 1970 is epoch)
		else if(!(dpYear.getDate().toEpochDay() >= -40150))
		{
			JOptionPane.showMessageDialog(frame, "Year of release can't be before 1860: the year of when the first sound was recorded.", "Date invalid", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else
		{
			return true;
		}
		
	}

}
