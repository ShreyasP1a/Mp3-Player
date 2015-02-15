package balcar.shreyas.Dossier.aboutSong;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import balcar.shreyas.Dossier.mp3Player.mp3Player;
import balcar.shreyas.Dossier.playSongs.playSongs;
import balcar.shreyas.Dossier.viewPlaylist.playViewPlaylistSongs;

public class aboutSong extends JFrame {

	private JPanel contentPane;

	public aboutSong() {
		
		setBounds(100, 100, 333, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setBounds(6, 31, 39, 16);
		contentPane.add(lblTitle);
		
		JLabel lblNewLabel_1 = new JLabel("About Song");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(6, 4, 321, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(6, 81, 61, 16);
		contentPane.add(lblAuthor);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(6, 134, 61, 16);
		contentPane.add(lblDuration);
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setBounds(6, 190, 61, 16);
		contentPane.add(lblAlbum);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(6, 232, 61, 22);
		contentPane.add(lblDate);
		JLabel title = new JLabel();
		title.setHorizontalAlignment(SwingConstants.LEFT);
		title.setBounds(6, 53, 321, 16);
		contentPane.add(title);
		
		JLabel author = new JLabel("");
		author.setHorizontalAlignment(SwingConstants.LEFT);
		author.setBounds(6, 106, 321, 16);
		contentPane.add(author);
		
		JLabel Duration = new JLabel("");
		Duration.setHorizontalAlignment(SwingConstants.LEFT);
		Duration.setBounds(6, 162, 321, 16);
		contentPane.add(Duration);
		
		JLabel album = new JLabel("");
		album.setHorizontalAlignment(SwingConstants.LEFT);
		album.setBounds(6, 214, 321, 16);
		contentPane.add(album);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(6, 256, 321, 16);
		contentPane.add(label);
		setVisible(true);
		File mp3Info=null;
		if(playSongs.mp3Info != null){
		 mp3Info = playSongs.mp3Info;
		}else {
			mp3Info = playViewPlaylistSongs.mp3PlaylistInfo;
		}
		
		mp3Player mp3 = new mp3Player();
		
		try {
			String[] mp3Information = mp3.getMp3Info(mp3Info);
			title.setText(mp3Information[0]);
			author.setText(mp3Information[1]);
			Duration.setText(mp3Information[2]);
			album.setText(mp3Information[3]);
			label.setText(mp3Information[4]);
			
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
