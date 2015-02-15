package balcar.shreyas.Dossier.allSongs;

import java.awt.Color;
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

		setBounds(100, 100, 350, 487);
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
			f = new File(
					"C:/Users/s07994809/Desktop/workspace/Dossier-Project/music/");
			System.out.println("Windows");
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
							.get("C:/Users/s07994809/Desktop/workspace/Dossier-Project/Music/"
									+ list.getSelectedValue() + ".mp3");

					Path pathMac = Paths
							.get("/Users/shreyas/Desktop/Dossier-Project/music/"
									+ list.getSelectedValue() + ".mp3");

					try {
						if (OS.equals("Windows 7")) {
							Files.delete(pathWindows);
						} else {
							Files.delete(pathMac);
						}
						System.out.println(true);
		
						listModel.remove(list.getSelectedIndex());
						
						

						File f = null;
						
						
						
						
						if(MainMenu.OS.equals("WINDOWS 7")){
						 f =new File ("C:/Users/s07994809/Desktop/workspace/Dossier-Project/PlayList/");
						}else {
							f =new File ("/Users/shreyas/Desktop/Dossier-Project/PlayList/");
						}
						final ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));	
						 
						
						
						
						String[] values = names.toArray(new String[names.size()]);
						
						
						
						
						
						
						for(int i = 1; i < values.length; i++){
						
						
						File t = null;
						 if(MainMenu.OS.equals("WINDOWS 7")){ 
						 t = new File("C:/Users/s07994809/Desktop/workspace/Dossier-Project/PlayList/" + values[i]);
						 }else {
							 t = new File("/Users/shreyas/Desktop/Dossier-Project/PlayList/" + values[i]);
						 }
						
						Scanner sc = null;
							
						
						
						
						
						
						
						
						sc = new Scanner(t);
						
							 
							 
								List<String> lines = new ArrayList<String>();
								while (sc.hasNextLine()) {
								  lines.add(sc.nextLine());
								}

								final String[] arr = lines.toArray(new String[0]);
								
								for(int j =0; j< arr.length;j++){
									if(arr[j].equals(list.getSelectedValue())){
										System.out.println("true");
									}
								}
								
								
								
								sc.close();
								
					
						
						}	
						
					} catch (IOException t) {
						// TODO Auto-generated catch block
						t.printStackTrace();
					}
				}
			}
		});
		btnDeleteSong.setBounds(30, 412, 110, 23);
		contentPane.add(btnDeleteSong);
		setVisible(true);
	}
}
