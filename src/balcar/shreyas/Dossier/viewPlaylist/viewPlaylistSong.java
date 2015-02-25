package balcar.shreyas.Dossier.viewPlaylist;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
import balcar.shreyas.Dossier.mp3Player.mp3Player;
import balcar.shreyas.Dossier.playSongs.playSongs;

public class viewPlaylistSong extends JFrame {

	private JPanel contentPane;
	private DefaultListModel listModel;
	public static String selectedPlaylistSong;
	public static int selectedSongIndex;
	mp3Player mp3 = new mp3Player();
	 
	
	viewPlaylistSong() {
		
		setBounds(100, 100, 285, 449);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 249, 303);
		contentPane.add(scrollPane);
		
		
		//Add songs in playlist to listmodel
		listModel = new DefaultListModel();
		 File f = null;
		 if(MainMenu.OS.equals("WINDOWS 7")){ 
		 f = new File(MainMenu.newAppData + "/Dossier/playlist/" + viewPlaylist.selectedPlaylist+".txt");
		 }else {
			 f = new File("/Users/shreyas/Desktop/Dossier-Project/PlayList/" + viewPlaylist.selectedPlaylist+".txt");
		 }
		 
		Scanner sc = null;
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			List<String> lines = new ArrayList<String>();
			while (sc.hasNextLine()) {
			  lines.add(sc.nextLine());
			}
			final String[] arr = lines.toArray(new String[0]);

			for(String a : arr){
				
				String str = (a.substring(0, a.length()-4));
				listModel.addElement(str);
			}
		
		sc.close();
		final JList list = new JList(listModel);		
		scrollPane.setViewportView(list);
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("View Songs\r\n\r\n");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 249, 26);
		contentPane.add(lblNewLabel);
		
		
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(list.getSelectedValue()==null){
					
					JOptionPane.showMessageDialog(null, "You did not select a Song!");
				}else{
				
				selectedPlaylistSong = (String) list.getSelectedValue();
				selectedSongIndex = list.getSelectedIndex();
				
				new playViewPlaylistSongs();
				}
				
			}
		});
		
	
		btnPlay.setBounds(151, 377, 89, 23);
		contentPane.add(btnPlay);
		System.out.println(viewPlaylist.selectedPlaylist);
		JLabel playListName = new JLabel(viewPlaylist.selectedPlaylist);
		playListName.setHorizontalAlignment(SwingConstants.CENTER);
		playListName.setBounds(10, 41, 249, 14);
		contentPane.add(playListName);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println(list.getSelectedValue());
				if(list.getSelectedValue() == null){
					JOptionPane.showMessageDialog(null, "You did not select a Song!");
				}else {
					
					listModel.remove(list.getSelectedIndex());
					
					
					
					
					
					
				}
				
			}
		});
		btnDelete.setBounds(20, 377, 89, 23);
		contentPane.add(btnDelete);
		setVisible(true);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
	
	
		
	 
	 
	 
	 }
}
