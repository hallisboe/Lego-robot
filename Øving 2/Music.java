import lejos.hardware.Audio;
import lejos.hardware.ev3.*;
import java.io.File;

public class Music extends Thread {

	private static String FILENAME;
	private static final int VOLUME = 100;
	private static Audio audio;
	public boolean loop = true;

	public Music (String fileName, EV3 ev3){
		this.FILENAME = fileName;
		this.audio = ev3.getAudio ();
	}

	public void play (){
		try{
			audio.playSample(new File(FILENAME),VOLUME);
			if(loop){play ();}
		}
		catch(Exception e){
			System.out.println("Could not play file: " + FILENAME + "\n" + e.getMessage ());
		}
	}

	public Audio getAudioSource (){
		return audio;
	}
}