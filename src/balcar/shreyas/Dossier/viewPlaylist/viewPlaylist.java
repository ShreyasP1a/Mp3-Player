package balcar.shreyas.Dossier.viewPlaylist;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import balcar.shreyas.Dossier.MainMenu.MainMenu;

public class viewPlaylist extends JFrame {

	private JPanel contentPane;
	private DefaultListModel listModel;
	public static String selectedPlaylist;

	
	/**
	 * Create the frame.
	 */
	public viewPlaylist() {
		
		setBounds(100, 100, 365, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\t\t\t\t\t\tPlaylists");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 329, 29);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 64, 265, 387);
		contentPane.add(scrollPane);
		File f = null;
		 final ArrayList<String> names;
		if(MainMenu.OS.equals("WINDOWS")){
		 f =new File ("C:/Users/s07994809/Desktop/workspace/Dossier Project/PlayList/");
		 names = new ArrayList<String>(Arrays.asList(f.list()));	
		}else{
			f =new File ("Users/shreyas/Desktop/Dossier-Project/PlayList/");
			 names = new ArrayList<String>(Arrays.asList(f.list()));	
		}
			
		
		 
		listModel = new DefaultListModel();
		for(int i=0;i<names.size();i++) {
			
			
	        String str = (names.get(i).substring(0, (names.get(i).length()-4)));
	        
			listModel.addElement(str);
		}
		
		final JList list = new JList(listModel);
		scrollPane.setViewportView(list);
		/*list.setModel(new DefaultListModel() {
			String[] values = names.toArray(new String[names.size()]);
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});*/
		
		scrollPane.setViewportView(list);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(list.getSelectedValue());
				if(list.getSelectedValue() == null){
					JOptionPane.showMessageDialog(null, "You did not select a playlist!");
				}else {
					
					Path path = Paths.get( "C:/Users/s07994809/Desktop/workspace/Dossier Project/Playlist/"+ list.getSelectedValue() +".txt");
					try {
						 Files.delete(path);
						//list.remove(list.getSelectedIndex());
						listModel.remove(list.getSelectedIndex());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btnDelete.setBounds(210, 476, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnViewPlaylist = new JButton("View Playlist");
		btnViewPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(list.getSelectedValue() == null){
				JOptionPane.showMessageDialog(null, "You did not select a Song!");
			}else {
				selectedPlaylist = (String) list.getSelectedValue();
				new viewPlaylistSong(); 
				
				
			
			      }
			}
		});
		btnViewPlaylist.setFont(new Font("Trebuchet MS", Font.PLAIN, 9));
		btnViewPlaylist.setBounds(32, 476, 89, 23);
		contentPane.add(btnViewPlaylist);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
