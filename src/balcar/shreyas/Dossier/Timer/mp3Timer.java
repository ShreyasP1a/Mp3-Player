package balcar.shreyas.Dossier.Timer;


import java.util.TimerTask;

import javax.swing.Timer;

public class mp3Timer extends TimerTask{
public int time = 0;
	@Override
	public void run() {
		time++;
		System.out.println(time);
	}
	
}
