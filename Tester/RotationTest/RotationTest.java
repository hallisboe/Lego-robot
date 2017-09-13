import lejos.hardware.motor.*;
import lejos.hardware.port.SensorPort;
import lejos.hardware.ev3.*;


public class RotationTest {


	private UltraSonicSensor sensor;
	private NXTRegulatedMotor sensorMotor;
	private Engine engine;
	private static EV3 ev3;
	private static Music music;

	private static final String SENSOR_PORT = "S1";
	private static final int SENSOR_ROTATION_SPEED = 50;

	private static float[] data;

	private static final float ROTATION_PUSH = 1.8f;

	private static final String SONG_FILENAME = "song.wav";

	public static void main(String[] args) throws Exception{
		new RotationTest ();
	}

	public RotationTest () throws Exception{
		//Gets the ev3 and gets the port of the UltraSonicSensor
		ev3 = LocalEV3.get();

		//Initializes the sensorMotor, the sensor and the engine
		sensorMotor = Motor.B;
		sensorMotor.setSpeed(SENSOR_ROTATION_SPEED);
		sensor = new UltraSonicSensor (SensorPort.S1);
		engine = new Engine (Motor.A,Motor.D);

		RotateAndPrint ();
		PrintData ();

		music = new Music(SONG_FILENAME,ev3);
		music.Play ();
	}

	private void RotateAndPrint () throws Exception{

		sensorMotor.rotate(-90);
		int rotation = 180;
		data = new float[180];
		sensorMotor.rotate(rotation,true);
		
		int index = 0;
		while(!sensorMotor.isStalled ()){
			data[index] = sensor.getDistance ();
			Thread.sleep((rotation/SENSOR_ROTATION_SPEED)*4);
			if(index >= rotation-1){break;}
			index++;
		}

		index = FindBiggestValueIndex (data); 
		System.out.print("Angle: " + index);
		int rotateTo = (int)((rotation-index)*ROTATION_PUSH);
		engine.rotate(rotateTo,Motor.A);
		sensorMotor.rotate(-90);

	}

	private void PrintData(){
		String output = "";
		for (int i = 0; i < data.length; i++) {
			output += "\n" + Integer.toString(i) +  "Distance: " + Float.toString(data[i]);
		}
		System.out.print(output);
	}

	private int FindBiggestValueIndex(float[] list){
		float biggestValue = 0f;
		int index = 0;
		int maxIndex = 0;
		boolean severalIndexes = false;
		for (int i = 0; i < list.length; i++) {
			if(list[i] > biggestValue){
				index = i;
				biggestValue = list[i];
				severalIndexes = false;
			}
			else if(list[i] == biggestValue){
				maxIndex = i;
				severalIndexes = true;
			}
		}
		return (!severalIndexes)? index : (int)((maxIndex-index/2) + index);
	}


}