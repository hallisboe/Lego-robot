import lejos.hardware.sensor.*;
import lejos.hardware.port.*;
import lejos.robotics.SampleProvider;

public class ColorSensor {

	private static EV3ColorSensor sensor;
	private static SensorMode sensorMode;
	private static SampleProvider dataSampler;
	private float[] data;

	public ColorSensor (Port port,int type){
		sensor = new EV3ColorSensor(port);

		switch(type){
			case 0: sensorMode = sensor.getRGBMode (); break;
			case 1: sensorMode = sensor.getAmbientMode (); break;
			default: sensorMode = sensor.getColorIDMode (); break;
		}

		data = new float[3];
	}

	public float[] getData (){
		sensorMode.fetchSample(data,0);
		return data;
	}


}