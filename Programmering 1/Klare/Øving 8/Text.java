class Text {

	final String[] SYMBOLS = {".", ":",";", "?", "!"};

	private String text;

	Text(String text) {
		this.text = text;
	}

	private String clean() {
		String string = this.text;
		for(String s : SYMBOLS) {
			string.replace(s, "");
		}
		string.replace(",", "");
		return string;
	}

	public int numberOfWords() {
		return this.clean().split(" ").length;
	}

	public double averageWordsPerPeriod() {
		int numberOfSymbols = 0;
		for(String s : SYMBOLS) {
			 // Antallet tegn - Antallet tegn som ikke er symbolet
			numberOfSymbols += this.text.length() - this.text.replace(s, "").length();
		}
		return (double) this.numberOfWords() / (double) numberOfSymbols;
	}

	public double averageWordLength() {
		return (double) this.clean().length() / (double) this.numberOfWords(); 
	}

	public void changeWord(String word, String with) {
		this.text = this.text.replace(word, with);
	}

	public String getText() {
		return this.text;
	}

	public String getUpperCaseText() {
		return this.text.toUpperCase();
	}

	public static void main(String[] args) {
		Text text = new Text("Hello Verden! Dette er en test. Det er kult.");
		System.out.println(text.numberOfWords());
		System.out.println(text.averageWordLength());
		System.out.println(text.averageWordsPerPeriod());
		text.changeWord("Hello", "Dumme");
		System.out.println(text.getText());
		System.out.println(text.getUpperCaseText());
	}

}