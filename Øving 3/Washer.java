import lejos.hardware.ev3.*;
import lejos.hardware.BrickFinder;
import lejos.hardware.lcd.*;
import lejos.hardware.sensor.*;
import lejos.hardware.Keys;
import lejos.hardware.port.*;
import lejos.hardware.motor.*;

public class Washer {

	private static SoundSensor soundSensor;
	private static ColorSensor colorSensor;
	private static Engine engine;

	private static long startTime;

	private static final int minSoundStrength = 40; //in desibel*100

	private static boolean isArmUp = false;
	private static boolean isMoving = false;

	public static void main(String[] args){
		new Washer();
	}

	public Washer(){
		soundSensor = new SoundSensor(SensorPort.S3);
		colorSensor = new ColorSensor (SensorPort.S1,0);
		engine = new Engine(Motor.A,Motor.B,150);

		startTime = System.currentTimeMillis ();

		boolean bigRot = true;

		while(true){
			engine.moveForward();
			while(!checkRGBData()) {
				if(soundDetected()){
					engine.stop();
					sleep(6000);
					engine.moveForward();
				}
			}

			rotate90Degrees(bigRot);
		}
		

		
	}

	//Checks if the ground is black
	private boolean isGroundBlack(){
		int iterations = 0;
		while(iterations <= 10){
			float intensity = colorSensor.getData()[0];
			System.out.print("\nIntensity: " + intensity);
			if(intensity <= 0.11){
				return true;
			}
			iterations++;
		}
		return false;
	}

	private boolean checkRGBData(){
		int iterations = 0;
		while(iterations <= 10){
			float[] data = colorSensor.getData();
			float r = data[0];
			float g = data[1];
			float b = data[2];
			System.out.print("\n\nR: " + r + "\nG: " + g + "\nB: " + b);

			if(r <= 0.003 && g <= 0.006 && b <= 0.003){
				return true;
			}
		}
		return false;
	}

	//Returns the time difference in millis between the startTime and when the function is called
	private long getTimeDifference(){
		return System.currentTimeMillis() - startTime;
	}

	//Resets the start time
	private void resetStartTime(){
		startTime = System.currentTimeMillis();
	}

	private boolean soundDetected(){
		if(soundSensor.getDB() >= minSoundStrength && getTimeDifference() >= 1500){
			resetStartTime();
			return true;
		}
		return false;
	}

	private void rotateArm(){
		NXTRegulatedMotor arm = Motor.C;
		int angle = 70;
		int direction = (isArmUp)? 1 : -1;
		arm.rotate(angle*direction);
		isArmUp = !isArmUp;
	}

	private void sleep(int time){
		try{
			Thread.sleep(time);
		}
		catch(Exception e){
			System.out.print("Error:" + e.getMessage ());
		}
	}

	private void rotate90Degrees (boolean bigRot){
		Motor.A.forward();
		Motor.B.backward();
		float time = (bigRot)? 2350 : 2300;
		sleep(2300);
		bigRot = !bigRot;
	}


	
	
}