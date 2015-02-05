package balcar.shreyas.Dossier.MainMenu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import balcar.shreyas.Dossier.Settings.Settings;
import balcar.shreyas.Dossier.allSongs.allSongs;
import balcar.shreyas.Dossier.createPlaylist.createPlaylist;
import balcar.shreyas.Dossier.viewPlaylist.viewPlaylist;

public class MainMenu extends JFrame {
public static String playlistName;

public static File  file;
public static String  fileName;
public static  String OS = System.getProperty("os.name").toUpperCase();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 491);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		

		
		JLabel lblNewLabel = new JLabel("                     Mp3 Player");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(24, 11, 400, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("All Songs");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new allSongs();
			}
		});
		btnNewButton.setBounds(116, 73, 227, 47);
		contentPane.add(btnNewButton);
		
		JButton btnCreatePlaylist = new JButton("Create Playlist");
		btnCreatePlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playlistName = JOptionPane.showInputDialog(null, "Enter Your Playlist Name");
				new createPlaylist().setVisible(true);
				
				}
		});
		btnCreatePlaylist.setBounds(116, 139, 227, 47);
		contentPane.add(btnCreatePlaylist);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			new Settings();
			}
		});
		btnSettings.setBounds(116, 325, 227, 47);
		contentPane.add(btnSettings);
		
		JButton btnAddSongs = new JButton("Add Songs");
		btnAddSongs.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser ();
				FileFilter filter = new FileNameExtensionFilter("Mp3", "mp3"); 
				fc.addChoosableFileFilter(filter);
				fc.setFileFilter(filter);
				int returnVal = fc.showOpenDialog(contentPane);
							
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					 file = fc.getSelectedFile();
					fileName = file.getName();
					
					
					
					
					if(OS.equals("WINDOWS")){
					file.renameTo(new File("C:/Users/s07994809/Desktop/workspace/Dossier Project/music/" + fileName ));
					}
					if(!fc.getSelectedFile().getAbsolutePath().endsWith("mp3")){ 
						file = new File(fc.getSelectedFile() + ".mp3"); 

				
					}
				}
				
				
			}
		});
		btnAddSongs.setBounds(116, 267, 227, 47);
		contentPane.add(btnAddSongs);
		
		JButton btnAbout = new JButton("About");
		btnAbout.setBounds(116, 395, 227, 47);
		contentPane.add(btnAbout);
		
		JButton btnViewPlaylist = new JButton("View Playlists");
		btnViewPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new viewPlaylist();
			}
		});
		btnViewPlaylist.setBounds(116, 209, 227, 47);
		contentPane.add(btnViewPlaylist);
	}
}
