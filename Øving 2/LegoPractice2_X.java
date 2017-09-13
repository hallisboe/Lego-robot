import lejos.hardware.ev3.*;
import lejos.hardware.port.*;
import lejos.hardware.motor.*;

public class LegoPractice2 {
	
	private static UltraSonicSensor sensor;
	private static Engine engine;
	private static EV3 ev3;

	private static final String SENSOR_PORT = "S1";

	private static final NXTRegulatedMotor left = Motor.A;
	private static final NXTRegulatedMotor right = Motor.D;
	private static final int MOTOR_RPM = 700;

	private static final float maxDistance = 0.10f;

	private static boolean rotateRight = false;

	public static void main(String[] args){
		new LegoPractice2 ();
	}

	public LegoPractice2 (){
		ev3 = LocalEV3.get ();

		Port port = ev3.getPort(SENSOR_PORT);
		sensor = new UltraSonicSensor(SensorPort.S1);
		engine = new Engine(left,right,MOTOR_RPM);

		start ();
	}

	private void start (){

		while(true){
			moveAndStop ();
		}
	}

	private void moveAndStop (){
		engine.setSpeed(MOTOR_RPM);
		engine.moveForward ();

		while(!sensor.foundObject(maxDistance)){}

		engine.stop ();
		engine.setSpeed(400);
		sleep(1000);
		lookForAvailablePath ();
	}

	private void lookForAvailablePath (){
		engine.stop ();
		do{
			System.out.print("\nDistance: " + sensor.getDistance ());
			if(!rotateRight){right.forward ();}
			else{right.backward();}
			sleep(1000);
			right.stop ();
			sleep(500);
		}
		while(sensor.foundObject(maxDistance));
		rotateRight = !rotateRight;
		
	}

	private void sleep (int ms){
		try{
			Thread.sleep(ms);
		}
		catch(Exception e){
			System.out.print(e.getMessage ());
		}
	}

}