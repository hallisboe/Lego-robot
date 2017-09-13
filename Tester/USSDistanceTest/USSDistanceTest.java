import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.hardware.ev3.*;

public class USSDistanceTest {

	private static UltraSonicSensor sensor;
	private static EV3 ev3;

	private static final String SENSORPORT = "S1";
	private static NXTRegulatedMotor sensorMotor;

	private static float[] data;
	private static final int FOV = 180;
	public static final int DATA_POINTS = 90;
	public static final int UNIT = (int) Math.round((float)FOV / (float)DATA_POINTS);

	int currentPosition = 0; //Start position er 90 grader, rett fram

	public static void main(String[] args) throws Exception {
		new USSDistanceTest ();
	}

	public USSDistanceTest () throws Exception{
		ev3 = LocalEV3.get ();
		Port port = ev3.getPort(SENSORPORT);

		sensor = new UltraSonicSensor (port);
		sensorMotor = Motor.A;

		data = new float[DATA_POINTS]; //Hvis error, add 2(?)

		Draw draw = new Draw(RotateSensor(), ev3, UNIT);
		draw.DrawEnvironment();
		Thread.sleep(10000);

	}

	private float[] RotateSensor (){

		float reading;

		for(;currentPosition < DATA_POINTS; currentPosition++){
			reading = sensor.getDistance ();
			if(reading > 3.0) data[currentPosition] = 3.0f;
			else data[currentPosition] = reading;
			sensorMotor.rotate(UNIT);
			//System.out.println("Distance " + data[currentPosition]);
		}

		/*for(;currentPosition > 0; currentPosition--){
			data[currentPosition] = sensor.getDistance ();
			sensorMotor.rotate(FOV/DATA_POINTS);
			//System.out.println("Distance " + data[currentPosition]);
		}*/

		return data;
	}


}