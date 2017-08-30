import static javax.swing.JOptionPane.*;

class ToSeconds {

	public static void main(String[] args) {

		// Konverter fra timer, minutter og sekunder til sekunder

		while(true) {

			String input_hours = showInputDialog(null, "Timer: ");
			String input_min = showInputDialog(null, "Minutter: ");
			String input_sec = showInputDialog(null, "Sekunder: ");

			try {

				double to_convert_hours = Double.parseDouble(input_hours);
				double to_convert_min = Double.parseDouble(input_min);
				double to_convert_sec = Double.parseDouble(input_sec);

				showMessageDialog(null, to_convert_hours + " timer, " +
					to_convert_min + " minutter og " +
					to_convert_sec + " sekunder er det samme som " + 
					(to_convert_sec + to_convert_min * 60 + to_convert_hours * 3600) + " sekuder");
					// Kunne rundet av til int, men double virker like logisk
				break;

			}

			catch(Exception e) {

				showMessageDialog(null, e);

			}



		}

	}

}