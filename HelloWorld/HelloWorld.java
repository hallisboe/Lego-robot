import lejos.hardware.motor.*;

public class HelloWorld {

	public static void main(String[] args){
		System.out.print("Hello World");
		Motor.D.forward ();
		try{
			Thread.sleep(10000);
		}
		catch(Exception e){
			System.out.print(e.getMessage ());
		}
		while(true){}
	}

}