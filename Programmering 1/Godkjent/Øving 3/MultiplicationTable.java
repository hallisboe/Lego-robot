import static javax.swing.JOptionPane.*;


class MultiplicationTable {

	// Printer ut gangetabellen

	static String getTable(int start, int slutt) {

		String output = ""; // String builder

		for(int i = start; i <= slutt; i++) {

			output += i + "-gangen:\n";

			for(int j = 1; j <= 10; j++) {

				output += i + " x " + j + " = " + (i * j) + "\n";

			}

		}

		return output;

	}

	public static void main(String[] args) {

		while(true) {

			try {

				int start = Integer.parseInt(showInputDialog(null, "Start: "));
				int slutt = Integer.parseInt(showInputDialog(null, "Slutt: "));
				showMessageDialog(null, getTable(start, slutt));
				break;

			}

			catch (Exception e) {

				showMessageDialog(null, e);

			}

		}

	}

}