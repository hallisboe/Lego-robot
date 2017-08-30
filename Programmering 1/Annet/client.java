import java.net.Socket;

public class client {

	public static void main(String []args) {

		try {

			System.out.println("client started...");
			Socket client = new Socket("localhost", 8080);

		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}

}