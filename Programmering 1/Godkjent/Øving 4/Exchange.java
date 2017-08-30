import static javax.swing.JOptionPane.*;


class Exchange {

	public static void main(String[] args) {

		Currency[] currencies = new Currency[3];

		currencies[0] = new Currency("Dollar", 0.127);
		currencies[1] = new Currency("Euro", 0.108);
		currencies[2] = new Currency("Yen", 13.889);

		String output = "Velg valuta: \n";
		
		for(int i = 0; i < currencies.length; i++) {

			output += (i + 1) + ": " + currencies[i].get_name() + "\n";

		}

		Currency currency = null;

		try {
			currency = currencies[Integer.parseInt(showInputDialog(null, output)) - 1];
		}

		catch (Exception e) {

		}
		
		// Spør bruker: konvertere til eller fra?

		Object[] options = {"Til", "Fra"}; 
		int value = showOptionDialog(null, "Til eller fra " + currency.get_name() + "?", "Konverter",
			DEFAULT_OPTION, QUESTION_MESSAGE,
			null, options, options[0]);

		if(value == 1) {
			showMessageDialog(null, 
				currency.to_nok(Double.parseDouble(showInputDialog(null, "Mengde: ")))
			);
		} else {
			showMessageDialog(null,
				currency.from_nok(Double.parseDouble(showInputDialog(null, "Mengde: ")))
			);
		}

	}

}