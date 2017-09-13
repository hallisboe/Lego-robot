import lejos.hardware.ev3.*;
import lejos.hardware.BrickFinder;
import lejos.hardware.lcd.*;
import lejos.hardware.sensor.*;
import lejos.hardware.Keys;
import lejos.hardware.port.*;
import lejos.hardware.motor.*;

class Race {
	private static ColorSensor colorSensor;

	public static void main(String[] args){
		new Race();
	}

	public Race(){
		colorSensor = new ColorSensor (SensorPort.S1,0);
		
		NXTRegulatedMotor[] motors = {Motor.A,Motor.B,Motor.C,Motor.D};
		for(NXTRegulatedMotor m : motors){
			m.setSpeed(900);
			m.forward ();
		}
		
	}

	//Checks if the ground is black, using RBG data
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

	//Simple function that handles Thread.sleep
	private void sleep(int time){
		try {
			Thread.sleep(time);
		} 
		catch(Exception e) {
			System.out.print("Error:" + e.getMessage());
		}
	}
}