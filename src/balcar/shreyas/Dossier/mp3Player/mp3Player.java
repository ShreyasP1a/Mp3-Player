package balcar.shreyas.Dossier.mp3Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import org.tritonus.share.sampled.file.TAudioFileFormat;
public class mp3Player {






	FileInputStream mp3FileInpuStream;
	BufferedInputStream mp3BufferedInputStream;
	
	public long songIndex;
	public long songLength;
	public Player player;
	public int perceptPlayed;
	

	public void Stop(){
		if(player !=null){
			player.close();
		}
	}

	public void Play(String path){	
		try { 
			mp3FileInpuStream = new FileInputStream(path);
			mp3BufferedInputStream = new BufferedInputStream(mp3FileInpuStream);
			player = new Player(mp3BufferedInputStream);
			songLength = mp3FileInpuStream.available();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		new Thread()
		{
			@Override
			public void run(){
				try {
					player.play();
					System.out.println("I reach here");
				} catch (JavaLayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}.start();
	}




	public void Pause(){
		if(player !=null){
			try {
				songIndex = mp3FileInpuStream.available() ;
				player.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public void Resume(String path){	
		try {
			mp3FileInpuStream = new FileInputStream(path);
			mp3BufferedInputStream = new BufferedInputStream(mp3FileInpuStream);
			player = new Player(mp3BufferedInputStream);

			mp3FileInpuStream.skip(songLength-songIndex);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (JavaLayerException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		new Thread()
		{
			@Override
			public void run(){
				try {
					player.play();


				} catch (JavaLayerException e) {

					e.printStackTrace();
				}

			}
		}.start();
	}	
	
	public String[] getMp3Info(File file) throws UnsupportedAudioFileException, IOException {

	    AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
	    String[] infoSong = new String[5];
	    if (fileFormat instanceof TAudioFileFormat) {
	        Map<?, ?> properties = ((TAudioFileFormat) fileFormat).properties();
	        
	        String key = "duration";
	        Long microseconds = (Long) properties.get(key);
	        int mili = (int) (microseconds / 1000);
	        int sec = (mili / 1000) % 60;
	        int min = (mili / 1000) / 60;
	        String key_author = "author";
	        String author = (String) properties.get(key_author);
	        
	        
	        String key_title = "title";
	        String title = (String) properties.get(key_title);
	       
	        String key_album = "album";
	        String album = (String) properties.get(key_album);
	        
	        String key_date = "date";
	        String date = (String) properties.get(key_date);

	        
	        System.out.println("Time = " + min + ":" + sec);
	        System.out.println("Author: " + author);
	        System.out.println("Title: " + title);
	        System.out.println("Album: " + album);
	        System.out.println("Date: " + date);
	    
	        
	        
	        infoSong[0] = title;
	        infoSong[1] = author;
	        infoSong[2] = min + ":" + sec;
	        infoSong[3] = album;
	        infoSong[4] = date;
	    
	    
	    } else {
	        throw new UnsupportedAudioFileException();
	    }
		return infoSong;

	}

}
