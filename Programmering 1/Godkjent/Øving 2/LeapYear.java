import static javax.swing.JOptionPane.*;

class LeapYear {

	public static void main(String[] args) {

		// Sier om et år er skuddår

		while(true) {

			String input = showInputDialog(null, "Årstall: ");

			try {

				int year = Integer.parseInt(input);

				if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) { // Hvis årstallet går opp i 4 og ikke går opp i 100, annet en 400

					showMessageDialog(null, year + " er et skuddår");
					break;

				} else {

					showMessageDialog(null, year + " er ikke et skuddår");
					break;
					
				}

			}

			catch(Exception e) {

				showMessageDialog(null, e);

			}
		}
	}
}