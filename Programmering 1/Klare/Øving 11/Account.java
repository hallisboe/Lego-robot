import java.util.*;
import java.io.*;


class Account {

	static double compute(double balance) throws IOException {
		String line;
		double change = 0;

		FileReader file = new FileReader("account.txt");
		BufferedReader reader = new BufferedReader(file);
		Scanner scan = new Scanner(reader);
		while(scan.hasNext()) {
			line = scan.nextLine();

			String[] t = line.trim().split(" ");
			for(String g : t) {
				System.out.println(g);
			}
			if(t[0].trim().equals("I")) {
				change += Double.parseDouble(t[1].trim());
			} else if(t[0].trim().equals("U")) {
				change -= Double.parseDouble(t[1].trim());
			}
		}
		
		return change;
	}

	public static void main(String[] args){
		double balance;
		try {
			FileReader file = new FileReader("saldo.txt");
			BufferedReader reader = new BufferedReader(file);
			Scanner scan = new Scanner(reader);
			
			balance = scan.nextDouble();
			double change = compute(balance);

			if(balance + change >= 0) {
				balance += change;
				System.out.println(change);
			} else {
				System.out.println("Ikke nok penger!");
			}
			
			FileWriter writer = new FileWriter("saldo.txt", false);
			PrintWriter printer = new PrintWriter(new BufferedWriter(writer));
			printer.println("" + balance);
			printer.close();
			System.out.println(balance);

		} catch(Exception e) {
			System.out.println(e);
		}
	}
}