import java.net.ServerSocket;
import java.net.Socket;

public class server {

	public static void main(String []args) {

		try {
			System.out.println("Waiting for clients...");
			ServerSocket server = new ServerSocket(8080);
			Socket client = server.accept();
			System.out.println("Connection!");
		} 

		catch (Exception e) {
			e.printStackTrace();			
		}

	}

}