import static javax.swing.JOptionPane.*;


class BangForYourBuck {

	public static void main(String[] args) {

		// Forteller deg basert på vekt of pris hvilket produkt du burde velge

		while(true) {

			try {
				double weight_one = Double.parseDouble(showInputDialog(null, "Vekt (første merke, i kilogram): "));
				double price_one = Double.parseDouble(showInputDialog(null, "Pris (første merke, i kr): "));
				double weight_two = Double.parseDouble(showInputDialog(null, "Vekt (første merke, i kilogram): "));
				double price_two = Double.parseDouble(showInputDialog(null, "Pris (første merke, i kr): "));

				double value_one = price_one / weight_one;
				double value_two = price_two / weight_two;

				String tip;

				if(value_one > value_two) {
					tip = "Derfor burde du velge merke 2.";
				} else if(value_two > value_one) {
					tip = "Derfor burde du velge merke 1."; 
				} else {
					tip = "De har samme verdi, velg den som ser best ut :-D";
				}
				showMessageDialog(null, "Pris for per kilogram for merke 1 er " + value_one +
					" kr, mens pris per kilo for merke 2 er " + value_two + "kr \n" + tip);
				break;
			}

			catch(Exception e) {

				showMessageDialog(null, e);

			}
		}

	}

}