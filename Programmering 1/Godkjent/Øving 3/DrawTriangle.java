import static javax.swing.JOptionPane.*;


class DrawTriangle {

	// Tegner triangler

	public static void main(String[] args) {

		int number_of_lines;

		while(true) {

			try {

				number_of_lines = Integer.parseInt(showInputDialog(null, "Antall linjer: "));
				break;

			}

			catch(Exception e) {

				showMessageDialog(null, e);

			}

		}

		String output = "";
		/* Delopggave 1 
		for(int i = 1; i <= number_of_lines; i++) {

			for(int j = 0; j < i; j++) {

				output += "*";

			}

			output += "\n";

		}
		*/
		/* Delopggave 2 */

		int number_of_whitespaces = number_of_lines;

		for(int i = 0; i <= number_of_lines; i++) {

			for(int k = 0; k < number_of_whitespaces; k++) {

				output += "  ";

			}

			number_of_whitespaces--;

			for(int j = 0; j < (i * 2) + 1; j++) {

				output += "*";

			}

			output += "\n";

		}

		showMessageDialog(null, output);

	}

}