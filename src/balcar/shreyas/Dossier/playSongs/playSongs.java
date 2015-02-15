package balcar.shreyas.Dossier.playSongs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import balcar.shreyas.Dossier.allSongs.allSongs;
import balcar.shreyas.Dossier.mp3Player.mp3Player;

public class playSongs extends JFrame {

	private JPanel contentPane;
	private int selectedIndex = allSongs.selectedSongIndex;
	mp3Player mp3 = new mp3Player();


	public playSongs() {
		mp3.Play("/Users/shreyas/Desktop/Dossier-Project/music/"+allSongs.selectedSongString +".mp3");
		
		setBounds(100, 100, 340, 393);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final String OS = System.getProperty("os.name").toUpperCase();
		File f = null;
		if(OS.equals("WINDOWS 7")){
		 f =new File ("C:/Users/s07994809/Desktop/workspace/Dossier-Project/music/");
		}else{
			 f =new File ("/Users/shreyas/Desktop/Dossier-Project/music/");

		}
		final ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
		
		
		final String[] array = names.toArray(new String[names.size()]);	
				
		
		
		
		
		

	
		
		
		
		
		
		
		
		JSlider slider = new JSlider();
		slider.setBackground(Color.LIGHT_GRAY);
		slider.setForeground(Color.LIGHT_GRAY);
		slider.setValue(0);
		slider.setBounds(10, 291, 304, 23);
		contentPane.add(slider);
		
		
		JButton btnLastSong = new JButton("Last song");
		btnLastSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLastSong.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnLastSong.setBounds(10, 325, 81, 23);
		contentPane.add(btnLastSong);
		
		JButton btnNextSong = new JButton("Next song");
		
		btnNextSong.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNextSong.setBounds(234, 325, 80, 23);
		contentPane.add(btnNextSong);
		
		final JLabel songTitle = new JLabel(allSongs.selectedSong);
		
		songTitle.setHorizontalAlignment(SwingConstants.CENTER);
		songTitle.setBounds(10, 257, 275, 23);
		contentPane.add(songTitle);
		
		JLabel playlist = new JLabel("");
		playlist.setToolTipText("test");
		playlist.setHorizontalAlignment(SwingConstants.CENTER);
		playlist.setBounds(33, 6, 275, 23);
		contentPane.add(playlist);
		
		JButton btnNewButton = new JButton("Shuffle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(245, 41, 89, 29);
		contentPane.add(btnNewButton);
		
		
		ImageIcon shuffle = new ImageIcon("/Users/shreyas/Desktop/Dossier-Project/shuffle3.png");
		setVisible(true);
		
		System.out.println();
		
		
		
		final String[] songNames = new String[array.length-1];	
		
		String[] test = new String[array.length];

			
		
		
		
		
		
		
		btnNextSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
			

		mp3.Play("/Users/shreyas/Desktop/Dossier-Project/music/"+songNames[allSongs.selectedSongIndex]);
				
				
				
				
				
			}
		});
		final JButton playPause = new JButton("Pause\r\n");
		playPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(playPause.getText().equals("Pause\r\n") ){
				playPause.setText("Play\r\n");
				mp3.Pause();
				}else {
					playPause.setText("Pause\r\n");
					mp3.Resume("/Users/shreyas/Desktop/Dossier-Project/music/" + allSongs.selectedSongString + ".mp3");
					
					
				}
			}
		});
		playPause.setBounds(127, 325, 80, 23);
		contentPane.add(playPause);
		
	}
}

