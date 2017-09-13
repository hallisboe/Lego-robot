import lejos.hardware.motor.*;
import lejos.hardware.sensor.*;
import lejos.hardware.port.*;
import lejos.robotics.SampleProvider;
import lejos.hardware.ev3.*;
import lejos.hardware.lcd.*;
import lejos.robotics.navigation.*;

class RadarB {
	private final int FOV;

	private EV3 ev3;
	private NXTRegulatedMotor sensorMotor;
	private SensorModes sensor;
	private SampleProvider dataSampler;
	private GraphicsLCD lcd;
	private int HEIGHT;
	private int WIDTH;

	private float time = 0;
	private float[] distances; // Posisjon i arrayet er rotasjonsvinkel - 1 [[x, y + time], [x, y], [x, y]]
	private float[] dataSamples;
	private int position;
	private boolean direction;

	public RadarB(char motorPort, String sensorPort, int speed, int FOV, boolean direction, int position) {
		this.FOV = FOV; // OBS: Mulig problem med final
		this.distances = new float[FOV / 2]; // Indekser fra 0, FOV - 1 // DS
		this.direction = direction; // Direction true er postiv retning
		switch(motorPort) {
			case 'A':
				this.sensorMotor = Motor.A;
				break; 
			case 'B':
				this.sensorMotor = Motor.B; 
				break;
			case 'C':
				this.sensorMotor = Motor.C;
				break; 
			case 'D':
				this.sensorMotor = Motor.D; 
				break;
			default:
				throw new IllegalArgumentException();
		}
		if(0 < speed || speed < 900) { // ADVARSEL: For lav speed kan gjøre at sensor henger etter
			sensorMotor.setSpeed(speed);
		} else {
			throw new IllegalArgumentException();
		}
		this.position = position; // Burde kanskje være mellom x og y?
		// USS 
		ev3 = LocalEV3.get();
		sensor = new EV3UltrasonicSensor(ev3.getPort(sensorPort));
		dataSampler = sensor.getMode("Distance");
		dataSamples = new float[dataSampler.sampleSize()];
		// Display
		lcd = ev3.getGraphicsLCD();
		HEIGHT = lcd.getHeight();
		WIDTH = lcd.getWidth();
		
	}

	/*
		Loop:
		- Starter rotasjon
		- Fyller data-array
		- Starter tegning
	*/
	public void start() {
		sensorMotor.rotate(-position + 6); // DS
		position = 6; // DS
	}

	public void iterate(int i) {
		for(int j = 0; j < i; j++) {
			rotate();
			collect();
			draw();
			position += direction ? 2 : -2; // DS
		}
	}

	/*
		- Roterer motor
	*/
	private void rotate() {
		direction = (position <= 2 || position >= FOV) ? !direction : direction; // Halvor approver denne linja xD // DS
		sensorMotor.rotate(direction ? 2 : -2); // DS
	}

	/*
		- Henter data
	*/
	private void collect() {
		dataSampler.fetchSample(dataSamples, 0);
		distances[(position / 2) - 1] = (dataSamples[0] <= 1) ? (dataSamples[0] + 0.085f) * 2 : 2f + 0.085f; // DS
	}

	/*
		- Tegner radar fra data
	*/
	private void draw() {
		lcd.clear();
		int x0 = WIDTH / 2, y0 = HEIGHT, x1, y1; 
		int fill = (180-FOV) / 2;
		for(int i = 0; i < distances.length; i++){
			x1 = (int)((distances[i] * WIDTH / 2) * Math.cos(Math.toRadians(2 * i + fill))) + WIDTH/2; // DS
			y1 = -(int) (distances[i] * HEIGHT * Math.sin(Math.toRadians(2 * i + fill))) + HEIGHT; // DS
			lcd.drawLine(x0, y0, x1, y1);
			x0 = x1; // -time 
			y0 = y1;
		}
		lcd.drawLine(x0, y0, WIDTH / 2, HEIGHT);
	}

	public float[] getDistances() {
		return distances;
	}

	public static void main(String[] args) {
		RadarB r = new RadarB('B', "S1", 900, 100, true, 50);
		r.start ();
		r.iterate(2000);
	}

}