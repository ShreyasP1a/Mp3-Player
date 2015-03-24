package balcar.shreyas.Dossier.allSongs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import balcar.shreyas.Dossier.MainMenu.MainMenu;
import balcar.shreyas.Dossier.mp3Player.mp3Player;
import balcar.shreyas.Dossier.playSongs.playSongs;
import balcar.shreyas.Dossier.viewPlaylist.viewPlaylist;

public class allSongs extends JFrame {
	public static String selectedSong;

	private DefaultListModel listModel;
	public static int selectedSongIndex;
	public static String selectedSongString;
	
	mp3Player mp3 = new mp3Player();
	
	private JPanel contentPane;

	public allSongs() {

		setBounds(100, 100, 448, 487);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("                    All Songs");
		lblNewLabel.setBounds(10, 11, 314, 28);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
		final String OS = System.getProperty("os.name").toUpperCase();
		File f = null;

		
		
		if (OS.equals("WINDOWS 7")) {
			f = new File(MainMenu.newAppData + "/Dossier/music");
			
		} else {
			f = new File("/Users/shreyas/Desktop/Dossier-Project/music/");
			
		}

		final ArrayList<String> names = new ArrayList<String>(Arrays.asList(f
				.list()));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 70, 279, 331);
		contentPane.add(scrollPane);
		final String[] values = names.toArray(new String[names.size()]);

		for (int i = 0; i < values.length; i++) {
			String test = values[i];
			if (test.startsWith(".")) {
				values[i] = null;
			}
		}

		listModel = new DefaultListModel();

		for (String a : values) {

			if (a == null) {
			} else {
				String str = a.substring(0, a.length() - 4);
				listModel.addElement(str);
			}

		}

		final JList list = new JList(listModel);
		scrollPane.setViewportView(list);
		/*
		 * list.setModel(new AbstractListModel() {
		 * 
		 * public int getSize() { return values.length; } public Object
		 * getElementAt(int index) { return values[index]; } });
		 */

		JButton btnNewButton = new JButton("Play\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (list.getSelectedIndex() == -1) {
					JOptionPane
							.showMessageDialog(null, "Please select a song!");
				} else {
					selectedSong = (String) list.getModel().getElementAt(
							list.getSelectedIndex());


					selectedSongIndex = list.getSelectedIndex();
					selectedSongString = (String) list.getSelectedValue();
					
					new playSongs();
				}
			}
		});
		btnNewButton.setBounds(220, 412, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnDeleteSong = new JButton("Delete Song\r\n");
		btnDeleteSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(null,
							"You did not select a Song!");
				} else {

					Path pathWindows = Paths
							.get(MainMenu.newAppData + "/Dossier/music/"
									+ list.getSelectedValue() + ".mp3");

					Path pathMac = Paths
							.get("/Users/shreyas/Desktop/Dossier-Project/music/"
									+ list.getSelectedValue() + ".mp3");

					try {
						if (OS.equals("WINDOWS 7")) {
							Files.delete(pathWindows);
						} else {
							Files.delete(pathMac);
						}
						
						listModel.remove(list.getSelectedIndex());
				
					
					
					} catch (IOException t) {
						// TODO Auto-generated catch block
						t.printStackTrace();
					}
					
					
				}
			}
		});
		btnDeleteSong.setBounds(30, 412, 110, 23);
		contentPane.add(btnDeleteSong);
		
		JButton btnTestSongSearch = new JButton("Test Song Search");
		btnTestSongSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			removeSong("Cooler Than Me - Mike Posner.mp3");
			}
		});
		btnTestSongSearch.setBounds(319, 237, 89, 23);
		contentPane.add(btnTestSongSearch);
		setVisible(true);
	}
	public void removeSong(String name){
	
	File f = new File(MainMenu.newAppData +"/Dossier/playlist");
	final ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
	final String[] values = names.toArray(new String[names.size()]);
	
	
		for(int i = 0; i < values.length;i++){
			
			File t = new File(MainMenu.newAppData + "/Dossier/playlist/" + values[i]);
			Scanner sc = null;
			
			try {
				sc = new Scanner(t);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
				List<String> lines = new ArrayList<String>();
				while (sc.hasNextLine()) {
				  lines.add(sc.nextLine());
				}
				sc.close();
				final String[] arr = lines.toArray(new String[0]);
			
				for(int j = 0; j< arr.length;j++ ){
					if(name.equals(arr[j])){
						arr[j] = null;
					}
					System.out.println();
					System.out.println();
				}
			
		}
	
	
	
	
	}
}
