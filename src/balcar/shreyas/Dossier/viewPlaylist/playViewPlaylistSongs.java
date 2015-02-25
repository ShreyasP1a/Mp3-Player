package balcar.shreyas.Dossier.viewPlaylist;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import balcar.shreyas.Dossier.MainMenu.MainMenu;
import balcar.shreyas.Dossier.aboutSong.aboutSong;
import balcar.shreyas.Dossier.allSongs.allSongs;
import balcar.shreyas.Dossier.mp3Player.mp3Player;

public class playViewPlaylistSongs extends JFrame {


	private JPanel contentPane;

	mp3Player mp3 = new mp3Player();
	public static File mp3PlaylistInfo;
	
	public playViewPlaylistSongs() {		
		this.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
	            	mp3.Stop();
	            	mp3PlaylistInfo=null;
	        
	        }
	    });
		
		
		
		
		
		
		if(MainMenu.OS.equals("WINDOWS 7")){
			mp3.Play(MainMenu.newAppData + "/Dossier/music/"+viewPlaylistSong.selectedPlaylistSong +".mp3");
			
		}else {
		mp3.Play("/Users/shreyas/Desktop/Dossier-Project/music/"+viewPlaylistSong.selectedPlaylistSong +".mp3");
		}
		setBounds(100, 100, 294, 191);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		final String OS = System.getProperty("os.name").toUpperCase();
		File f = null;
		if(OS.equals("WINDOWS 7")){
		 f =new File (MainMenu.newAppData + "/Dossier/Playlist/" + viewPlaylist.selectedPlaylist+".txt");
		}else{
			 f =new File ("/Users/shreyas/Desktop/Dossier-Project/Playlist/" + viewPlaylist.selectedPlaylist+".txt");

		}
	
		
		JButton btnNextSong = new JButton("Next song");
		
		btnNextSong.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNextSong.setBounds(191, 117, 80, 23);
		contentPane.add(btnNextSong);
		
		final JLabel songTitle = new JLabel(viewPlaylistSong.selectedPlaylistSong);
		
		songTitle.setHorizontalAlignment(SwingConstants.CENTER);
		songTitle.setBounds(6, 82, 265, 23);
		contentPane.add(songTitle);
		
		JLabel playlist = new JLabel(viewPlaylist.selectedPlaylist);
		playlist.setToolTipText("test");
		playlist.setHorizontalAlignment(SwingConstants.CENTER);
		playlist.setBounds(6, 6, 263, 23);
		contentPane.add(playlist);
		setVisible(true);
		
		
		
		
		

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

			final String[] songNames = lines.toArray(new String[0]);
			
			
				
		
		
		
		
		
		final JButton playPause = new JButton("Pause\r\n");
		playPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(playPause.getText().equals("Pause\r\n") ){
				playPause.setText("Play\r\n");
				mp3.Pause();
				
				
				}else {
					playPause.setText("Pause\r\n");
					
					if(MainMenu.OS.equals("WINDOWS 7")){
						mp3.Resume(MainMenu.newAppData + "/Dossier/music/" + songNames[viewPlaylistSong.selectedSongIndex] );
					}else {
					mp3.Resume("/Users/shreyas/Desktop/Dossier-Project/music/" + songNames[viewPlaylistSong.selectedSongIndex] );				
					} 
					}
			}
		});
		playPause.setBounds(99, 116, 80, 23);
		contentPane.add(playPause);
		btnNextSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mp3.Stop();	
				mp3.songIndex=0;
				if(playPause.equals("Play\r\n")){
					mp3.songIndex=0;
				}else {
					mp3.songIndex=0;
				}
				mp3.Stop();
				viewPlaylistSong.selectedSongIndex++;		
		System.out.println(viewPlaylistSong.selectedSongIndex);	
			System.out.println(songNames.length);
			if( viewPlaylistSong.selectedSongIndex >= songNames.length){
				viewPlaylistSong.selectedSongIndex =0;
			}
			

			songTitle.setText(songNames[viewPlaylistSong.selectedSongIndex].substring(0, songNames[viewPlaylistSong.selectedSongIndex].length()-4));
			
		if(playPause.getText().equals("Pause\r\n")){
		if(MainMenu.OS.equals("WINDOWS 7")){
		
			mp3.Play(MainMenu.newAppData + "/Dossier/music/"+songNames[viewPlaylistSong.selectedSongIndex]);
		}else{
			mp3.Play("/Users/shreyas/Desktop/Dossier-Project/music/"+songNames[viewPlaylistSong.selectedSongIndex]);
		}
		}	
				
			}
		});
		
		
		
		
		JButton btnLastSong = new JButton("Last song");
		btnLastSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				mp3.Stop();	
				if(playPause.equals("Play\r\n")){
					mp3.songIndex=0;
				}else {
					mp3.songIndex=0;
				}
				mp3.Stop();	
				
				viewPlaylistSong.selectedSongIndex--;

		
			if( viewPlaylistSong.selectedSongIndex < 0){
				viewPlaylistSong.selectedSongIndex =songNames.length-1;
			}

			
			
			songTitle.setText(songNames[viewPlaylistSong.selectedSongIndex].substring(0, songNames[viewPlaylistSong.selectedSongIndex].length()-4));
			
		if(playPause.getText().equals("Pause\r\n")){
			if(MainMenu.OS.equals("WINDOWS 7")){
				
				mp3.Play(MainMenu.newAppData + "/Dossier/music/"+songNames[viewPlaylistSong.selectedSongIndex]);
			}else{
				mp3.Play("/Users/shreyas/Desktop/Dossier-Project/music/"+songNames[viewPlaylistSong.selectedSongIndex]);
			}
		}

			}
		});

		
		
		
		
		JButton btnNewButton = new JButton("Shuffle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shuffle(songNames);

			}
		});
	
		
		
		
		
		
		
		
		btnNewButton.setBounds(6, 41, 89, 29);
		contentPane.add(btnNewButton);
		btnLastSong.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnLastSong.setBounds(6, 117, 81, 23);
		contentPane.add(btnLastSong);
		
		JButton btnAboutSong = new JButton("About Song");
		btnAboutSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(viewPlaylistSong.selectedSongIndex);
				System.out.println(songNames[viewPlaylistSong.selectedSongIndex]);
				if(MainMenu.OS.equals("WINDOWS 7")){
					mp3PlaylistInfo = new File(MainMenu.newAppData + "/Dossier/music/"+songNames[viewPlaylistSong.selectedSongIndex]);
					
				}else{
					mp3PlaylistInfo = new File("/Users/shreyas/Desktop/Dossier-Project/music/"+songNames[viewPlaylistSong.selectedSongIndex]);
				
				}
				new aboutSong();
				
		
			}
		});
		btnAboutSong.setBounds(158, 41, 117, 29);
		contentPane.add(btnAboutSong);
		
		
	}
	

	
	
	
	
	public static void shuffle(String[] arr){
		Random rnd = new Random();
	    for (int i = arr.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      String a = arr[index];
	      arr[index] = arr[i];
	      arr[i] = a;
	    }
	    
	}

	  
}

