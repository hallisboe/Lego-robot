import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.hardware.ev3.*;
import lejos.hardware.Key;

public class LegoUSSTest {

	private UltraSonicSensor USS;
	private Engine ENGINE;
	private Music music;
	private static final int rpm = 400;

	private static EV3 ev3;
	private static final String SENSORPORT = "S1";

	private static float maxDistance = 0.30f;

	public static void main(String[] args) throws Exception{
		new LegoUSSTest ();

	}

	public LegoUSSTest () throws Exception{
		ev3 = LocalEV3.get();
		Port port = ev3.getPort(SENSORPORT);

		this.USS = new UltraSonicSensor(port);
		this.ENGINE = new Engine (Motor.A,Motor.B,rpm);
		this.music = new Music("song.wav",ev3);

		music.Play ();
		StartMoving ();
		System.out.println("Program finished!");
	}

	private void StartMoving () throws Exception{

		int rounds = 0;
		while(isAnyKeyPressed ()) {
			ENGINE.moveForward ();

			while(!USS.foundObject(maxDistance)){}

			ENGINE.moveBackwards ();

			Thread.sleep(1000);

			ENGINE.stop ();
			ENGINE.rotate(360*2,0);

			rounds++;
			if(rounds == 10){break;}
		}

	}

	private boolean isAnyKeyPressed (){
	       if(Key.ENTER == 1 || Key.DOWN == 1 || Key.LEFT == 1 || Key.RIGHT == 1 || Key.UP == 1 || Key.ENTER == 1){
		       return true;
        	}
	        return false;
    }



}