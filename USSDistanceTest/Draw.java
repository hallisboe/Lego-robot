import lejos.hardware.lcd.*;
import lejos.hardware.Key;
import lejos.hardware.ev3.*;

public class Draw {

	private static float[] data;
	private static GraphicsLCD lcd;

	private static int HEIGHT;
	private static int WIDTH;

	private static float scale;

	public Draw (float[] data, EV3 ev3, float scale){

		this.data = data;
		lcd = ev3.getGraphicsLCD();
		HEIGHT = lcd.getHeight ();
		WIDTH = lcd.getWidth ();
		this.scale = scale;

	}

	public static void DrawEnvironment (){

		Pointer pointer = new Pointer ();

		for(int i = 1; i < data.length; i++){

			pointer.drawTo(
			-(int)((data[i]*WIDTH/2) * Math.cos(Math.toRadians(i  *scale))),
			(int) (data[i]*HEIGHT * Math.sin(Math.toRadians(scale * i)))
			);
		}

	}

	private static int map(double value,double from1,double to1,int from2,int to2){
		return (int)Math.round((value - from1)/(to1-from1)*((double)to2-(double)from2) + (double)from2);
	}

	private float findMaxValue(){
		float maxValue = 0f;
		for(float i : data){
			if(i > maxValue){
				maxValue = i;
			}
		}
		return maxValue;
	}

	private static class Pointer {

		private int currentX = WIDTH/2, currentY = HEIGHT;

		public Pointer (){

		}

		public void drawTo (int x,int y){


			lcd.drawLine(currentX,currentY,x + WIDTH/2, HEIGHT - y);

			currentX = WIDTH/2 + x;
			currentY = HEIGHT - y;
		}

	}

}