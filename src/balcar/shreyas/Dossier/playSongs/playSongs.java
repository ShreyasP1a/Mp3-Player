package balcar.shreyas.Dossier.playSongs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import balcar.shreyas.Dossier.allSongs.allSongs;

public class playSongs extends JFrame {

	private JPanel contentPane;
	private int selectedIndex = allSongs.selectedSongIndex;
	


	public playSongs() {
		
		setBounds(100, 100, 340, 393);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final String OS = System.getProperty("os.name").toUpperCase();
		File f = null;
		if(OS.equals("WINDOWS")){
		 f =new File ("C:/Users/s07994809/Desktop/workspace/Dossier Project/music/");
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
		
		final JButton playPause = new JButton("Pause\r\n");
		playPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(playPause.getText().equals("Pause") ){
				playPause.setText("Play");
				}else {
					playPause.setText("Pause");

				}
			}
		});
		playPause.setBounds(127, 325, 80, 23);
		contentPane.add(playPause);
		
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
		playlist.setBounds(10, 22, 275, 23);
		contentPane.add(playlist);
		setVisible(true);
		
		
		
		
		btnNextSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			allSongs.selectedSongIndex++;
			
			
			
			if(allSongs.selectedSongIndex > array.length-1){
				allSongs.selectedSongIndex =0;
			}
			
			songTitle.setText(array[allSongs.selectedSongIndex].substring(0, array[allSongs.selectedSongIndex].length()-4));
			
		
				
				
				
				
				
			}
		});
	}
}

