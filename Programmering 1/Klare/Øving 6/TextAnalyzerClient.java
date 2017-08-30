import static javax.swing.JOptionPane.*;


class TextAnalyzerClient {

	public static void main(String[] args) {
		
		TextAnalyzer analyzer = new TextAnalyzer(
			showInputDialog("Tekst som skal analysers: ")
		);

		System.out.println("Antall unike chars: " + analyzer.numberOfUniqueChar()); 
		
		System.out.println("Lengde: " + analyzer.getLength()); 

		System.out.println("Prosentandel bokstaver: " + analyzer.percentageLetters()); 

		System.out.println("Antall ganger (a): " + analyzer.numberOfApearances('a'));

		System.out.println("De(n) mest vanlige: ");
		for(int i : analyzer.mostApearances()) {
			System.out.println((char) (i + 97) + " som forekommer " + analyzer.numberOfChar[i] + " ganger.");
		
		}
	}

}