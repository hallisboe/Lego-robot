import static javax.swing.JOptionPane.*;


class Convert {

	public static void main(String[] args) {

		// Konverter fra tommer til cm

		while(true) {

			String input = showInputDialog(null, "Tommer: ");
			
			try {

				double to_convert = Double.parseDouble(input);
				showMessageDialog(null, to_convert + " i tommer er " + 
					to_convert * 2.54 + " cm");
				break;

			}

			catch(Exception e) {

				showMessageDialog(null, e);

			}



		}

	}

}