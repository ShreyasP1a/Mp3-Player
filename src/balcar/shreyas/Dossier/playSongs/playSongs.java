package balcar.shreyas.Dossier.playSongs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;

import javax.sound.sampled.UnsupportedAudioFileException;
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

public class playSongs extends JFrame {


	private JPanel contentPane;
	private int selectedIndex = allSongs.selectedSongIndex;
	mp3Player mp3 = new mp3Player();
	public static File mp3Info = null;
	
	public playSongs() {		
		this.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
	            	mp3.Stop();
	            	mp3Info=null;
	        }
	    });
		
		File t = null;
		
		if(MainMenu.OS.equals("WINDOWS 7")){
			mp3.Play(MainMenu.newAppData + "/Dossier/music/"+allSongs.selectedSongString +".mp3");
			t = new File(MainMenu.newAppData + "/Dossier/music/"+allSongs.selectedSongString +".mp3");
		}else{
		mp3.Play("/Users/shreyas/Desktop/Dossier-Project/music/"+allSongs.selectedSongString +".mp3");
		t = new File("/Users/shreyas/Desktop/Dossier-Project/music/"+allSongs.selectedSongString +".mp3");
		
		}
		
		
		try {
			mp3.getMp3Info(t);
		} catch (UnsupportedAudioFileException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		setBounds(100, 100, 299, 184);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final String OS = System.getProperty("os.name").toUpperCase();
		File f = null;
		if(OS.equals("WINDOWS 7")){
		 f =new File (MainMenu.newAppData + "/Dossier/music/");
		}else{
			 f =new File ("/Users/shreyas/Desktop/Dossier-Project/music/");

		}
		final ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
		
		
		final String[] array = names.toArray(new String[names.size()]);
		
		
	
		
		JButton btnNextSong = new JButton("Next song");
		
		btnNextSong.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNextSong.setBounds(191, 117, 80, 23);
		contentPane.add(btnNextSong);
		
		final JLabel songTitle = new JLabel(allSongs.selectedSong);
		
		songTitle.setHorizontalAlignment(SwingConstants.CENTER);
		songTitle.setBounds(6, 82, 265, 23);
		contentPane.add(songTitle);
		
		JLabel playlist = new JLabel("No Playlist Selected");
		playlist.setToolTipText("test");
		playlist.setHorizontalAlignment(SwingConstants.CENTER);
		playlist.setBounds(6, 6, 263, 23);
		contentPane.add(playlist);
		

		
		
		
		setVisible(true);
		
		System.out.println();
		
		
		
		final String[] songNames = new String[array.length-1];	
		
		String[] test = new String[array.length];

		for(int i =0; i < array.length;i++){
			if(array[i].startsWith(".")){
				test[i] = null;
			}
			else{
				test[i] = array[i];
			}
		}
	
		for(int j =1; j< array.length; j++){
			songNames[j-1] = test[j];
		}
		
		
		
		
		final JButton playPause = new JButton("Pause\r\n");
		playPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(playPause.getText().equals("Pause\r\n") ){
				playPause.setText("Play\r\n");
				mp3.Pause();
				
				System.out.println("I am hear as well");
				}else {
					playPause.setText("Pause\r\n");
					if(MainMenu.OS.equals("WINDOWS 7")){
					mp3.Resume((MainMenu.newAppData + "/Dossier/music/" + songNames[allSongs.selectedSongIndex]));
							
					}else {
					
					mp3.Resume("/Users/shreyas/Desktop/Dossier-Project/music/" + songNames[allSongs.selectedSongIndex] );
					}
					
				}
			}
		});
		playPause.setBounds(99, 116, 80, 23);
		contentPane.add(playPause);
		
		
		
		
		
		btnNextSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mp3.Stop();	
				if(playPause.equals("Play\r\n")){
					mp3.songIndex=0;
				}
		
				mp3.Stop();
				
		allSongs.selectedSongIndex++;
		
		
		
		System.out.println(allSongs.selectedSongIndex);	
			System.out.println(songNames.length);
			if( allSongs.selectedSongIndex >= songNames.length){
				allSongs.selectedSongIndex =0;
			}
			
			
			int i =0;
			for(String a :songNames){
				System.out.println(i+": "+ a);
				i++;
			}
			
			songTitle.setText(songNames[allSongs.selectedSongIndex].substring(0, songNames[allSongs.selectedSongIndex].length()-4));
			
		if(playPause.getText().equals("Pause\r\n")){
			
		if(MainMenu.OS.equals("WINDOWS 7")){	
			mp3.Play((MainMenu.newAppData + "/Dossier/music/" + songNames[allSongs.selectedSongIndex]));
		}else{
			mp3.Play("/Users/shreyas/Desktop/Dossier-Project/music/"+songNames[allSongs.selectedSongIndex]);
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
				}
				mp3.Stop();	
				
		allSongs.selectedSongIndex--;
		
		
		
		System.out.println(allSongs.selectedSongIndex);	
			System.out.println(songNames.length);
			if( allSongs.selectedSongIndex < 0){
				allSongs.selectedSongIndex =songNames.length-1;
			}
			
			
			
			
			songTitle.setText(songNames[allSongs.selectedSongIndex].substring(0, songNames[allSongs.selectedSongIndex].length()-4));
			
		if(playPause.getText().equals("Pause\r\n")){
			if(MainMenu.OS.equals("WINDOWS 7")){	
				mp3.Play((MainMenu.newAppData + "/Dossier/music/" + songNames[allSongs.selectedSongIndex]));
			}else{
				mp3.Play("/Users/shreyas/Desktop/Dossier-Project/music/"+songNames[allSongs.selectedSongIndex]);
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
				
				
				
				
				if(MainMenu.OS.equals("WINDOWS 7")){
				
					mp3Info = new File(MainMenu.newAppData + "/Dossier/music/"+songNames[allSongs.selectedSongIndex]);
				}else {
				mp3Info = new File("/Users/shreyas/Desktop/Dossier-Project/music/"+songNames[allSongs.selectedSongIndex]);
				}
				new aboutSong();
				
		
			}
		});
		btnAboutSong.setBounds(158, 41, 117, 29);
		contentPane.add(btnAboutSong);
		
		
	}
	
	
	//shuffle the Songs
	
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

