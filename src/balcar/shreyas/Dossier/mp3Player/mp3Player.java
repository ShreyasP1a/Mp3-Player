package balcar.shreyas.Dossier.mp3Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;
public class mp3Player {
	
	
	
	
	
	
	FileInputStream FIS;
	BufferedInputStream BIS;
	public long songIndex;
	public long songLength;
	public Player player;

	public void Stop(){
		if(player !=null){
			player.close();
		}
		

		
	}
	
public void Play(String path){	
try {
	FIS = new FileInputStream(path);
	BIS = new BufferedInputStream(FIS);
	player = new Player(BIS);
	songLength = FIS.available();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}.start();
}




public void Pause(){
	if(player !=null){
		try {
			songIndex = FIS.available();
			player.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
public void Resume(String path){	
try {
	FIS = new FileInputStream(path);
	BIS = new BufferedInputStream(FIS);
	player = new Player(BIS);
	
	FIS.skip(songLength-songIndex);
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}.start();
}	

}
