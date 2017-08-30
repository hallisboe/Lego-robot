import static javax.swing.JOptionPane.*;


class ToSecMinHours {

	public static void main(String[] args) {

		while(true) {

			String input = showInputDialog(null, "Sekunder: ");

			try {

				double to_convert_sec = Double.parseDouble(input);

				showMessageDialog(null, to_convert_sec + " sekunder i SS:MM:HH er " +
					to_convert_sec % 60 + " sekunder, " +  
					Math.floor((to_convert_sec % 3600) / 60) + " minutter og " + 
					Math.floor(to_convert_sec / 3600) + " timer"
				);

				break;

			}

			catch(Exception e) {

				showMessageDialog(null, e);

			}

		}

	}

}