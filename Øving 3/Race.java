import lejos.hardware.ev3.*;
import lejos.hardware.BrickFinder;
import lejos.hardware.lcd.*;
import lejos.hardware.sensor.*;
import lejos.hardware.Keys;
import lejos.hardware.port.*;
import lejos.hardware.motor.*;

class Race {
	private static ColorSensor colorSensor;
	private static Engine engine;

	public static void main(String[] args){
		new Washer();
	}

	public Race(){
		colorSensor = new ColorSensor (SensorPort.S1,0);
		engine = new Engine(Motor.A,Motor.B,150);

		startTime = System.currentTimeMillis ();

		boolean bigRot = true;

		Motor.D.forward();

		while(true){
			engine.moveForward();
			while(true) {
				soundDetected();
				if(checkRGBData()){
					break;
				}
			}
			engine.moveBackwards();
			sleep(1000);
			rotate180Degrees(bigRot);
		}
	}

	//Checks if the ground is black
	private boolean isGroundBlack(){
		float intensity = colorSensor.getData()[0];
		System.out.print("\nIntensity: " + intensity);
		if(intensity <= 0.11){
			return true;
		}
		return false;
	}

	//
	private boolean checkRGBData(){
		float[] data = colorSensor.getData();
		float r = data[0];
		float g = data[1];
		float b = data[2];
		//System.out.print("\n\nR: " + r + "\nG: " + g + "\nB: " + b);

		if(r <= 0.003 && g <= 0.006 && b <= 0.003){
			return true;
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

	private void soundDetected(){
		float soundStrength = soundSensor.getDB()*100;
		System.out.print("Sound: " + soundStrength);

		if(soundStrength >= minSoundStrength && getTimeDifference() >= 1500){
			resetStartTime();
			engine.stop();
			sleep(6000);
			fixRotation ();
			engine.moveForward();
			//return true;
		}
		//return false;
	}

	private void sleep(int time){
		try {
			Thread.sleep(time);
		} 
		catch(Exception e) {
			System.out.print("Error:" + e.getMessage());
		}
	}

	private void rotate180Degrees (boolean bigRot){
		Motor.A.forward();
		Motor.B.backward();
		sleep(2450);
		bigRot = !bigRot;
	}

	private void fixRotation (){
		Motor.A.forward();
		Motor.B.backward();
		sleep(200);
	}


	
	
}